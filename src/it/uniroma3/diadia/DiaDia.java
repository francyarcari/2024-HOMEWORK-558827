package it.uniroma3.diadia;
import java.util.Scanner;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.giocatore.*;


/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	static final private String[] elencoComandi = {"vai", "prendi", "posa", "aiuto", "fine"};

	private Partita partita;
	private IOConsole console;

	public DiaDia(IOConsole console) {
		this.partita = new Partita();
		this.console = console;
	}

	public void gioca() {
		String istruzione; 
		//Scanner scannerDiLinee;
		IOConsole console = new IOConsole();
		console.mostraMessaggio(MESSAGGIO_BENVENUTO);
		//scannerDiLinee = new Scanner(console.leggiRiga());
		do
			istruzione = console.leggiRiga();
		while(!processaIstruzione(istruzione));
		
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		IOConsole console = new IOConsole();
		Comando comandoDaEseguire = new Comando(istruzione);
		final String nome = comandoDaEseguire.getNome();
		if(nome==null) {
			console.mostraMessaggio("Digita un altro comando");
			return false;
		}

		if (nome.equals("fine")) {
			this.fine(); 
			return true;
		} else if (nome.equals("vai"))
			this.vai(comandoDaEseguire.getParametro());
		else if(nome.equals("prendi")) 
			this.prendi(comandoDaEseguire.getParametro());
		else if(nome.equals("posa")) 
			this.posa(comandoDaEseguire.getParametro());
		else if (nome.equals("aiuto"))
			this.aiuto();
		else {
			console.mostraMessaggio("Comando sconosciuto");
			return true;
		}
		if (this.partita.isFinita()) {
			if(this.partita.vinta()) {
				console.mostraMessaggio("Hai vinto!");
				return true;
			}
		} else
			if(this.partita.getGiocatore().getCfu()==0) {
				console.mostraMessaggio("Hai finito le vite!");
				console.mostraMessaggio("GAME OVER");
				return true;
			}
			return false;
	}   

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		IOConsole console = new IOConsole();
		for(int i=0; i< elencoComandi.length; i++) 
			console.mostraMessaggio(elencoComandi[i]+" ");
		System.out.println();
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		IOConsole console = new IOConsole();
		if(direzione==null)
			console.mostraMessaggio("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			console.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getCfu();
			this.partita.setCfu(cfu--);
		}
		System.out.println(partita.getStanzaCorrente().getDescrizione());
	}
	
	/* Prendi attrezzo da una stanza e lo poni nella borsa */
	private void prendi(String nomeAttrezzo) {
		IOConsole console = new IOConsole();
		//Se l'attrezzo non è presente nella stanza
		if(!this.partita.getStanzaCorrente().hasAttrezzo(nomeAttrezzo)) {
			console.mostraMessaggio("L'attrezzo "+nomeAttrezzo+" non è presente nella stanza");
			return;
		}
		
		//Se l'attrezzo è presente nella stanza
		Attrezzo attrezzo = this.partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		if(this.partita.getStanzaCorrente().hasAttrezzo(nomeAttrezzo)) {
			if(this.partita.getGiocatore().getBorsa().getPeso()+this.partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo).getPeso()<=this.partita.getGiocatore().getBorsa().getPesoMax()) { 
				this.partita.getStanzaCorrente().removeAttrezzo(attrezzo);
				this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
				console.mostraMessaggio("L'attrezzo "+nomeAttrezzo+" è stato rimosso dalla stanza e aggiunto in borsa!");
				return;
			}
			else {
				console.mostraMessaggio("La borsa è piena!");
				return;
			}
		}
		
	}
	
	/* Posa l'attrezzo nella stanza, quindi viene preso dalla borsa*/
	private void posa(String nomeAttrezzo) {
		IOConsole console = new IOConsole();
		//Se l'attrezzo non è presente nella borsa
		if(!this.partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo)) {
			console.mostraMessaggio("L'attrezzo "+nomeAttrezzo+" non è presente nella borsa");
			return;
		}
		
		//Se l'attrezzo è presente nella borsa
		Attrezzo attrezzo = this.partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
		if(this.partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo)) {
			this.partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
			this.partita.getStanzaCorrente().addAttrezzo(attrezzo);
			console.mostraMessaggio("L'attrezzo "+nomeAttrezzo+" è stato aggiunto alla stanza");
			return;
		}
	}

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		console.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}

	public static void main(String[] argc) {
		IOConsole console = new IOConsole();
		DiaDia gioco = new DiaDia(console);
		gioco.gioca();
	}

}