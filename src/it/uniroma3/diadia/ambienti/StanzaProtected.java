package it.uniroma3.diadia.ambienti;
import it.uniroma3.diadia.attrezzi.*;
import java.util.*;

public class StanzaProtected {
	static final protected int NUMERO_MASSIMO_DIREZIONI = 4;
	static final protected int NUMERO_MASSIMO_ATTREZZI = 10;
	
	protected String nome;
	protected Map<String, Attrezzo> attrezzi;
	protected int numeroAttrezzi;
    protected Map<String, StanzaProtected> stanzeAdiacenti;
    protected int numeroStanzeAdiacenti;
	
	public StanzaProtected(String nome) {
		this.nome = nome;
		this.numeroStanzeAdiacenti = 0;
		this.numeroAttrezzi = 0;
		this.stanzeAdiacenti = new HashMap<>();
		this.attrezzi = new HashMap<>();
	}
	
	public int getNumeroStanzeAdiacenti() {
		return numeroStanzeAdiacenti;
	}

	public void setNumeroStanzeAdiacenti(int numeroStanzeAdiacenti) {
		this.numeroStanzeAdiacenti = numeroStanzeAdiacenti;
	}

	public int getNumeroAttrezziPossibili() {
		return NUMERO_MASSIMO_ATTREZZI-this.numeroAttrezzi;
	}
	
	public void impostaStanzaAdiacente(String direzione, StanzaProtected stanza) {
		boolean aggiornato = false;
		if(this.stanzeAdiacenti.containsKey(direzione)) {
			this.stanzeAdiacenti.put(direzione, stanza);
			aggiornato = true;
		}
		if(!aggiornato) {
			if(this.numeroStanzeAdiacenti<NUMERO_MASSIMO_DIREZIONI) {
				this.stanzeAdiacenti.put(direzione, stanza);
				this.numeroStanzeAdiacenti++;
			}
		}
	}
	
	public StanzaProtected getStanzaAdiacente(String direzione) {
        StanzaProtected stanza = null;
		if(this.stanzeAdiacenti.containsKey(direzione)) {
			stanza = this.stanzeAdiacenti.get(direzione);
		}
        return stanza;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getDescrizione() {
        return this.toString();
    }
	
	public Collection<Attrezzo> getAttrezzi() {
		return this.attrezzi.values();
	}
	
	public boolean addAttrezzo(Attrezzo attrezzo) {
        if(attrezzo!=null && this.numeroAttrezzi<NUMERO_MASSIMO_ATTREZZI) {
        	this.attrezzi.put(attrezzo.getNome(), attrezzo);
        	this.numeroAttrezzi++;
        	return true;
        }
        else {
        	return false;
        }
    }
	
	public String toString() {
    	StringBuilder risultato = new StringBuilder();
    	risultato.append(this.nome);
		risultato.append("\nUscite: ");
		risultato.append(this.getDirezioni().toString());
		risultato.append("\nAttrezzi nella stanza: ");
		risultato.append(this.getAttrezzi().toString());
		return risultato.toString();

    }
	
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.containsKey(nomeAttrezzo);
	}
	
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo attrezzoCercato;
		attrezzoCercato = null;
		if(this.attrezzi.containsKey(nomeAttrezzo)) {
			attrezzoCercato = this.attrezzi.get(nomeAttrezzo);
		}
		return attrezzoCercato;	
	}
	
	public boolean removeAttrezzo(Attrezzo attrezzo) {
		if(attrezzo!=null) {
			this.attrezzi.remove(attrezzo.getNome(), attrezzo);
			return true;
		}
		else {
			return false;
		}
	}
	
	public Set<String> getDirezioni() {
		return this.stanzeAdiacenti.keySet();
    }


}
