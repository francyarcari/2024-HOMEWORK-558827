package it.uniroma3.diadia.comando;
import it.uniroma3.diadia.*;

public interface Comando {
	public void esegui(Partita partita);
	public void setParametro(String parametro);
	public void setIO(IO console);
	String getNome();
}
