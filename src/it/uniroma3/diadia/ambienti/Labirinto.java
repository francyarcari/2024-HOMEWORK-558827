package it.uniroma3.diadia.ambienti;
import java.util.*;
import java.io.FileNotFoundException;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.*;
import it.uniroma3.diadia.*;

public class Labirinto {
	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;
	
	private Labirinto(String nomeFile) throws FileNotFoundException, FormatoFileNonValidoException {
		CaricatoreLabirinto c = new CaricatoreLabirinto(nomeFile);
		c.carica();
		this.stanzaCorrente = c.getStanzaIniziale();
		this.stanzaVincente = c.getStanzaVincente();
	}
	

//	private void creaStanze() {

		/* crea gli attrezzi */
    //    	Attrezzo lanterna = new Attrezzo("lanterna",3);
	//		Attrezzo osso = new Attrezzo("osso",1);
	//	Attrezzo spada = new Attrezzo("spada", 7);
	//	Attrezzo scudo = new Attrezzo("scudo", 10);
	//	Attrezzo grimaldello = new Attrezzo("grimaldello", 1);
    	
		/* crea stanze del labirinto */
	//	Stanza atrio = new Stanza("Atrio");
	//	Stanza aulaN11 = new StanzaMagica("Aula N11");
	//	Stanza aulaN10 = new StanzaBloccata("Aula N10", "est", "grimaldello");
	//	Stanza laboratorio = new StanzaBuia("Laboratorio Campus", "lanterna");
	//	Stanza biblioteca = new Stanza("Biblioteca");
		
		/* collega le stanze */
	//	atrio.impostaStanzaAdiacente("nord", biblioteca);
	//	atrio.impostaStanzaAdiacente("est", aulaN11);
	//	atrio.impostaStanzaAdiacente("sud", aulaN10);
	//	atrio.impostaStanzaAdiacente("ovest", laboratorio);
	//	aulaN11.impostaStanzaAdiacente("est", laboratorio);
	//	aulaN11.impostaStanzaAdiacente("ovest", atrio);
	//	aulaN10.impostaStanzaAdiacente("nord", atrio);
	//	aulaN10.impostaStanzaAdiacente("est", aulaN11);
	//	aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
	//	laboratorio.impostaStanzaAdiacente("est", atrio);
	//	laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
	//	biblioteca.impostaStanzaAdiacente("sud", atrio);

        /* pone gli attrezzi nelle stanze */
	//	aulaN10.addAttrezzo(lanterna);
	//	atrio.addAttrezzo(osso);
	//  aulaN11.addAttrezzo(grimaldello);
	//   laboratorio.addAttrezzo(scudo);
        
        
		// il gioco comincia nell'atrio
	//  stanzaCorrente = atrio;  
	//	stanzaVincente = biblioteca;
	//    }

	
	public Stanza getStanzaCorrente() {
		return stanzaCorrente;
	}

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}

	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}

	public void setStanzaVincente(Stanza stanzaVincente) {
		this.stanzaVincente = stanzaVincente;
	}
	
	public static LabirintoBuilder newBuilder(String labirinto) throws FileNotFoundException, FormatoFileNonValidoException {
		return new LabirintoBuilder(labirinto);
	}
	
	public static class LabirintoBuilder {
		private Labirinto labirinto;
		private Map<String, Stanza> nome2stanza;
		private Stanza ultimaStanzaAggiunta;
		
		public LabirintoBuilder(String labirinto) throws FileNotFoundException, FormatoFileNonValidoException {
			this.labirinto = new Labirinto(labirinto);
			this.nome2stanza = new HashMap<>();
		}
		

		public Map<String, Stanza> getNome2stanza() {
			return nome2stanza;
		}

		public Labirinto getLabirinto() {
			return this.labirinto;
		}

		public LabirintoBuilder addStanzaIniziale(String stanzaIniziale) {
			Stanza i = new Stanza(stanzaIniziale);
			this.labirinto.setStanzaCorrente(i);
			this.UltimaStanzaAggiuntaEAggiorna(i);
			return this;
		}

		public LabirintoBuilder addStanzaVincente(String stanzaVincente) {
			Stanza s = new Stanza(stanzaVincente);
			this.labirinto.setStanzaVincente(s);
			this.UltimaStanzaAggiuntaEAggiorna(s);
			return this;
		}

		public LabirintoBuilder addStanza(String stanza) {
			Stanza s = new Stanza(stanza);
			this.UltimaStanzaAggiuntaEAggiorna(s);
			return this;
		}	
		
		public LabirintoBuilder  addMago(String nome, String presentazione, Attrezzo attrezzo) {
			Mago m = new Mago(nome, presentazione, attrezzo);
			if(this.ultimaStanzaAggiunta==null)
				return this;
			this.ultimaStanzaAggiunta.setPersonaggio(m);
			return this;
		}

		public LabirintoBuilder  addCane(String nome, String presentazione) {
			Cane c = new Cane(nome, presentazione);
			if(this.ultimaStanzaAggiunta==null)
				return this;
			this.ultimaStanzaAggiunta.setPersonaggio(c);
			return this;
		}

		public LabirintoBuilder  addStrega(String nome, String presentazione) {
			Strega s = new Strega(nome, presentazione);
			if(this.ultimaStanzaAggiunta==null)
				return this;
			this.ultimaStanzaAggiunta.setPersonaggio(s);
			return this;
		}

		public LabirintoBuilder addAttrezzo(String attrezzo, int peso) {
			Attrezzo a = new Attrezzo(attrezzo, peso);
			if(this.ultimaStanzaAggiunta==null)
				return this;
			this.ultimaStanzaAggiunta.addAttrezzo(a);
			return this;
		}

		public LabirintoBuilder addAdiacenza(String stanzaCorrente, String stanzaAdiecente, Direzione direzione) {
			Stanza c = this.nome2stanza.get(stanzaCorrente);
			Stanza a = this.nome2stanza.get(stanzaAdiecente);
			c.impostaStanzaAdiacente(direzione, a);
			return this;
		}

		public LabirintoBuilder addStanzaMagica(String nome) {
			Stanza stanza = new StanzaMagica(nome);
			this.UltimaStanzaAggiuntaEAggiorna(stanza);
			return this;
		}

		public LabirintoBuilder addStanzaBuia(String nome, String attrezzoPerVedere) {
			Stanza stanza = new StanzaBuia(nome,attrezzoPerVedere);
			this.UltimaStanzaAggiuntaEAggiorna(stanza);
			return this;
		}

		public LabirintoBuilder addStanzaBloccata(String nome, String attrezzoSbloccante, String direzioneBloccata) {
			Stanza stanza = new StanzaBloccata(nome, Direzione.valueOf(direzioneBloccata), attrezzoSbloccante);
			this.UltimaStanzaAggiuntaEAggiorna(stanza);
			return this;
		}

		public void UltimaStanzaAggiuntaEAggiorna(Stanza stanza) {
			this.ultimaStanzaAggiunta = stanza;
			this.nome2stanza.put(stanza.getNome(), stanza);
		}


	}


}
