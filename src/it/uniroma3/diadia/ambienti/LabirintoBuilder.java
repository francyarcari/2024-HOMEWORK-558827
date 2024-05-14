package it.uniroma3.diadia.ambienti;
import it.uniroma3.diadia.attrezzi.*;
import java.util.*;

public class LabirintoBuilder {
	private Labirinto labirinto;
	private Stanza ultimaStanzaAggiunta;
	private Map<String, Stanza> stanze;
	
	public LabirintoBuilder() {
		this.labirinto = new Labirinto();
		this.stanze = new HashMap<String, Stanza>();
	}
	
	public Labirinto getLabirinto() {
		return this.labirinto;
	}
	
	public Map<String, Stanza> getStanze() {
		return this.stanze;
	}
	
	/* Inserisce una stanza nella mappa */
	public void ultimaStanzaAggiuntaEAggiorna(Stanza stanza) {
		this.ultimaStanzaAggiunta = stanza;
		this.stanze.put(stanza.getNome(), stanza);
	}
	
	/*Metodo che setta la stanza iniziale del gioco*/
	public LabirintoBuilder addStanzaIniziale(String stanzaIniziale) {
		Stanza s = new Stanza(stanzaIniziale);
		this.labirinto.setStanzaCorrente(s);
		this.ultimaStanzaAggiuntaEAggiorna(s);
		return this;
	}
	
	//Metodo che specifica quale stanza sarà quella vincente
	public LabirintoBuilder addStanzaVincente(String stanzaVincente) {
		Stanza s = new Stanza(stanzaVincente);
		this.labirinto.setStanzaVincente(s);
		this.ultimaStanzaAggiuntaEAggiorna(s);
		return this;
	}
	
	public LabirintoBuilder addStanza(String stanza) {
		Stanza s = new Stanza(stanza);
		this.ultimaStanzaAggiuntaEAggiorna(s);
		return this;
	}
	
	/* Permette di aggiungere una stanza adiacente in una certa direzione della
	 * stanza corrente.                                     */
	public LabirintoBuilder addAdiacenza(String sc, String sa, String direzione) {
		Stanza c = this.stanze.get(sc);
		Stanza a = this.stanze.get(sa);
		c.impostaStanzaAdiacente(direzione, a);
		return this;
	}
	
	/* Metodo che aggiunge un attrezzo nell'ULTIMA stanza aggiunta */
	public LabirintoBuilder addAttrezzo(String attrezzo, int peso) {
		Attrezzo a = new Attrezzo(attrezzo, peso);
		if(this.ultimaStanzaAggiunta==null) {
			return this;
		}
		this.ultimaStanzaAggiunta.addAttrezzo(a);
		return this;
	}
	
	public LabirintoBuilder addStanzaMagica(String nome) {
		Stanza sm = new StanzaMagica(nome);
		this.ultimaStanzaAggiuntaEAggiorna(sm);
		return this;
	}
	
	public LabirintoBuilder addStanzaBuia(String nome, String attrezzoLucente) {
		Stanza sb = new StanzaBuia(nome, attrezzoLucente);
		this.ultimaStanzaAggiuntaEAggiorna(sb);
		return this;
	}
	
	public LabirintoBuilder addStanzaBloccata(String nome, String direzioneBloccata, String attrezzoSbloccante) {
		Stanza sb = new StanzaBloccata(nome, direzioneBloccata, attrezzoSbloccante);
		this.ultimaStanzaAggiuntaEAggiorna(sb);
		return this;
	}
	
}
