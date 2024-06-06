package it.uniroma3.diadia.comando;
import it.uniroma3.diadia.*;

public class ComandoNonValido extends AbstractComando {
	private final static String NOME = "non valido";
	private IO io;
	
	@Override
	public void esegui(Partita partita) {
	      io.mostraMessaggio("Comando non valido.");
	}
	
	@Override
	public String getNome() {
		return NOME;
	}
	
	@Override
	public void setIO(IO io) {
		this.io = io;
	}
}
