package it.uniroma3.diadia.personaggi;
import java.util.*;
import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.*;
import it.uniroma3.diadia.ambienti.*;

public class Strega extends AbstractPersonaggio {
	private static final String MESSAGGIO_SALUTATA = "Solo perchè mi hai salutata, non ti mando in uno scantinato!";
	private static final String MESSAGGIO_NON_SALUTATA = "Sei proprio una brutta persona, vai nella stanza con meno attrezzi!";
	
	public Strega(String nome, String presentazione) {
		super(nome, presentazione);
	}
	
	@Override
	public String agisci(Partita partita) {
		String msg;
		List<Stanza> stanzeAdiacenti = partita.getStanzaCorrente().getStanzeAdiacenti();
		Stanza maxAttrezzi = stanzeAdiacenti.get(0);
		Stanza minAttrezzi = stanzeAdiacenti.get(0);
		for(Stanza s : stanzeAdiacenti) {
			if(s!=null) {
				if(s.getNumeroAttrezzi()> maxAttrezzi.getNumeroAttrezzi()) {
					maxAttrezzi = s;
				}
				if(s.getNumeroAttrezzi()< minAttrezzi.getNumeroAttrezzi()) {
					minAttrezzi = s;
				}
			}
		}
		
		if(isHaSalutato()) {
			partita.setStanzaCorrente(maxAttrezzi);
			msg = MESSAGGIO_SALUTATA;
		}
		else {	
			partita.setStanzaCorrente(minAttrezzi);
			msg = MESSAGGIO_NON_SALUTATA;
		}
		return msg;
	}
	
	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		return "HAHAHAHAHAHAHAHA";
	}
	
}
