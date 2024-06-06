package it.uniroma3.diadia.comando;
import it.uniroma3.diadia.*;

public class ComandoAiuto extends AbstractComando {
	public static final String[] elenco_comandi = {"vai", "aiuto", "prendi", "posa", "fine", 
			"guarda", "saluta", "interagisci", "regala"};
	private IO io;
	
	@Override
	public void esegui(Partita partita) {
		for(int i=0; i<elenco_comandi.length; i++) {
			io.mostraMessaggio(elenco_comandi[i]+" ");
		}
	}
	
	@Override
	public void setParametro(String parametro) {
		
	}
	
	@Override
	public void setIO(IO io) {
		this.io = io;
	}
}
