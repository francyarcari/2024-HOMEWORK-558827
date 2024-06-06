package it.uniroma3.diadia.comando;
import it.uniroma3.diadia.*;

public class ComandoGuarda extends AbstractComando {
	private IO io;
	
	@Override
	public void esegui(Partita partita) {
		io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		io.mostraMessaggio("Hai ancora: "+partita.getGiocatore().getCfu()+ "CFU");
		io.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
	}
	
	@Override
	public void setParametro(String parametro) {
		
	}
	
	@Override
	public void setIO(IO console) {
		this.io = console;
	}

}
