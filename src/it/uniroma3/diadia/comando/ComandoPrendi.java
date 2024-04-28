package it.uniroma3.diadia.comando;
import it.uniroma3.diadia.*;
import it.uniroma3.diadia.attrezzi.*;

public class ComandoPrendi implements Comando {
	private String nomeAttrezzo;
	private IO io;
	
	@Override
	public void esegui(Partita partita) {
		//Se l'attrezzo non è presente nella stanza
		if(!partita.getStanzaCorrente().hasAttrezzo(nomeAttrezzo)) {
			io.mostraMessaggio("L'attrezzo "+nomeAttrezzo+" non è presente nella stanza");
			return;
		}
		
		//Se l'attrezzo è presente nella stanza
		Attrezzo attrezzo = partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		if(partita.getStanzaCorrente().hasAttrezzo(nomeAttrezzo)) {
			if(partita.getGiocatore().getBorsa().getPeso()+partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo).getPeso()<=partita.getGiocatore().getBorsa().getPesoMax()) { 
				partita.getStanzaCorrente().removeAttrezzo(attrezzo);
				partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
				io.mostraMessaggio("L'attrezzo "+nomeAttrezzo+" è stato rimosso dalla stanza e aggiunto in borsa!");
				return;
			}
			else {
				io.mostraMessaggio("La borsa è piena!");
				return;
			}
		}
	}
	
	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}
	
	@Override
	public void setIO(IO io) {
		this.io = io;
	}
}
