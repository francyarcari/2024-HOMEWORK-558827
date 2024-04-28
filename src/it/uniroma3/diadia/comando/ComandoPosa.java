package it.uniroma3.diadia.comando;
import it.uniroma3.diadia.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando {
	private String nomeAttrezzo;
	private IO io;

	
	@Override
	public void esegui(Partita partita) {
		//Se l'attrezzo non è presente nella borsa
		if(!partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo)) {
			io.mostraMessaggio("L'attrezzo "+nomeAttrezzo+" non è presente nella borsa");
			return;
		}
		
		//Se l'attrezzo è presente nella borsa
		Attrezzo attrezzo = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
		if(partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo)) {
			partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
			partita.getStanzaCorrente().addAttrezzo(attrezzo);
			io.mostraMessaggio("L'attrezzo "+nomeAttrezzo+" è stato aggiunto alla stanza");
			return;
		}
	}
	
	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}
	
	@Override
	public void setIO(IO io) {
		this.io = io;
	}
}
