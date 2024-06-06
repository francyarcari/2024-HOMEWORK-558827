package it.uniroma3.diadia.comando;
import it.uniroma3.diadia.*;

public abstract class AbstractComando implements Comando {
	private IO io;
	private String parametro;
	private final static String NOME = "AbstractComando";
	
	abstract public void esegui(Partita partita);
	
	public String getParametro() {
		return this.parametro;
	}
	
	@Override
	public void setParametro(String parametro) {
		this.parametro = parametro;
	}
	
	@Override
	public void setIO(IO io) {
		this.io = io;
	}
	
	@Override
	public String getNome() {
		return NOME;
	}

	
	
}
