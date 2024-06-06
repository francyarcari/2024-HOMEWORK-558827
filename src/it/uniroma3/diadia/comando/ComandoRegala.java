package it.uniroma3.diadia.comando;
import it.uniroma3.diadia.*;
import it.uniroma3.diadia.attrezzi.*;

public class ComandoRegala extends AbstractComando{
	private IO io;
	
	@Override 
	public void esegui(Partita partita) {
		Attrezzo attrezzo = partita.getGiocatore().getBorsa().getAttrezzo(getParametro());
		io.mostraMessaggio(partita.getStanzaCorrente().getPersonaggio().riceviRegalo(attrezzo, partita));
		partita.getGiocatore().getBorsa().getAttrezzo(getParametro());
	}
	
	@Override
	public void setIO(IO io) {
		this.io = io;
	}
}
