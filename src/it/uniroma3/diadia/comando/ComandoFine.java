package it.uniroma3.diadia.comando;
import it.uniroma3.diadia.*;

public class ComandoFine extends AbstractComando {
	private IO io;	
	
		@Override
		public void esegui(Partita partita) {
			io.mostraMessaggio("Grazie per aver giocato!");
		}
		
		@Override
		public void setParametro(String parametro) {
			
		}
		
		@Override
		public void setIO(IO io) {
			this.io = io;
		}
	
}
