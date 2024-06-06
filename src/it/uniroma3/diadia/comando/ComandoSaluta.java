package it.uniroma3.diadia.comando;
import it.uniroma3.diadia.*;

public class ComandoSaluta extends AbstractComando{
	private IO io;
	
	@Override
	public void esegui(Partita partita) {
		if(partita.getStanzaCorrente().getPersonaggio()!=null) {
			io.mostraMessaggio(partita.getStanzaCorrente().getPersonaggio().saluta());
		}
		else
			io.mostraMessaggio("Non c'è alcun personaggio in questa stanza!");
	}
	
	@Override
	public void setIO(IO io) {
		this.io = io;
	}
}
