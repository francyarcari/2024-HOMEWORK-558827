package it.uniroma3.diadia.comando;
import it.uniroma3.diadia.*;

public class ComandoNonValido implements Comando {
	private IO io;
	
	@Override
	public void esegui(Partita partita) {
		io.mostraMessaggio("Comando non valido.");
	}
	
	@Override
	public void setParametro(String parametro) {

	}
	
	@Override
	public void setIO(IO io) {
		this.io = io;
	}
}
