package it.uniroma3.diadia.comando;
import it.uniroma3.diadia.*;
import it.uniroma3.diadia.ambienti.*;

public class ComandoVai implements Comando {
	private String direzione;
	private IO io;
	
	public ComandoVai(String direzione) {
		this.direzione = direzione;
	}
	
	@Override
	public void setParametro(String parametro) {
		this.direzione = parametro;
	}
	
	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Stanza prossimaStanza = null;
		if(this.direzione==null) {
			io.mostraMessaggio("Dove vuoi andare? Devi specificare una direzione.");
			return;
		}
		
		prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.direzione);
		if(prossimaStanza==null) {
			io.mostraMessaggio("Direzione inesistente.");
			return;
		}
		partita.setStanzaCorrente(prossimaStanza);
		io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		partita.getGiocatore().setCfu((partita.getGiocatore().getCfu()-1));
	}
	
	@Override
	public void setIO(IO console) {
		this.io = console;
	}
}
