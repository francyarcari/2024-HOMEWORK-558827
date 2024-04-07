package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.jupiter.api.BeforeEach;

class StanzaTest {
	private static final int MAX_ATTREZZI = 10;
	private static final String ATTREZZO = "Attrezzo di test";
	private static final String STANZA = "Stanza di test";
	private static final String STANZA_ADIACENTE = "Stanza adiacente";
	private static final String NORD = "nord";
	private Stanza stanza;
	
	@BeforeEach
	public void setUp() {
		this.stanza = new Stanza(STANZA);
	}
	
	public Stanza creaEImpostaStanzaAdiacente(Stanza stanzaDiPartenza, String nomeStanzaAdiacente, String direzione) {
		Stanza stanzaAdiacente = new Stanza(STANZA_ADIACENTE);
		stanzaDiPartenza.impostaStanzaAdiacente(direzione, stanzaAdiacente);
		return stanzaAdiacente;
	}
	
	@Test
	public void testImpostaStanzaAdiacente() {
		Stanza adiacente = creaEImpostaStanzaAdiacente(this.stanza, STANZA_ADIACENTE, NORD);
		assertEquals(adiacente, this.stanza.getStanzaAdiacente(NORD));
		
	}
	
	@Test
	public void testCambiaStanzaAdiacente() {
		creaEImpostaStanzaAdiacente(this.stanza, STANZA_ADIACENTE, NORD);
		Stanza nuova = creaEImpostaStanzaAdiacente(this.stanza, "nuova adiacente", NORD);
		assertEquals(nuova, this.stanza.getStanzaAdiacente(NORD));
	}
	
	@Test
	public void testMassimo4Stanze() {
		Stanza adiacente = new Stanza(STANZA_ADIACENTE);
		String[] direzioni = {"nord", "sud", "est", "ovest"};
		for(String direzione : direzioni) {
			this.stanza.impostaStanzaAdiacente(direzione, adiacente);
		}
		
		String nuovaDirezione = "sud-ovest";
		assertNotContains(this.stanza.getDirezioni(), nuovaDirezione);
	}
	
	public void assertNotContains(String[] direzioni, String direzioneNuova) {
		boolean contiene = false;
		for(String direzione : direzioni) {
			if(direzione!=null && direzione.equals(direzioneNuova)) {
				contiene = true;
			}
		}
		assertFalse(contiene);
	}
	
	@Test
	public void testGetStanzaAdiacenteNonEsistente() {
		assertNull(this.stanza.getStanzaAdiacente(NORD));
	}
	
	@Test
	public void testGetStanzaAdiacenteEsistente() {
		creaEImpostaStanzaAdiacente(this.stanza, STANZA_ADIACENTE, NORD);
		assertNotNull(this.stanza.getStanzaAdiacente(NORD));
	}
	
	@Test
	public void testGetStanzaAdiacenteDirezioneNonValida() {
		creaEImpostaStanzaAdiacente(this.stanza, STANZA_ADIACENTE, NORD);
		assertNull(this.stanza.getStanzaAdiacente(null));
	}
	
	@Test
	public void testAddAttrezzo() {
		Attrezzo attrezzo = new Attrezzo(ATTREZZO, 7);
		this.stanza.addAttrezzo(attrezzo);
		assertEquals(attrezzo, this.stanza.getAttrezzo(ATTREZZO));
	}
	
	@Test
	public void testAddAttrezzoOltreMax() {
		for(int i=0; i<MAX_ATTREZZI; i++) {
			Attrezzo attrezzo = new Attrezzo(ATTREZZO+i, 7);
			assertTrue(this.stanza.addAttrezzo(attrezzo));
		}
		
		Attrezzo attrezzoOltre = new Attrezzo(ATTREZZO+MAX_ATTREZZI, 1);
		assertFalse(this.stanza.addAttrezzo(attrezzoOltre));
	}
	
	@Test
	public void testHasAttrezzo() {
		Attrezzo attrezzo = new Attrezzo(ATTREZZO, 7);
		this.stanza.addAttrezzo(attrezzo);
		assertTrue(this.stanza.hasAttrezzo(ATTREZZO));
	}
	
	@Test
	public void testHasNotAttrezzo() {
		assertFalse(this.stanza.hasAttrezzo(ATTREZZO));
	}
	
	@Test
	public void testHasAttrezzoNull() {
		assertFalse(this.stanza.hasAttrezzo(null));
	}
	
	@Test
	public void testGetDirezioniVuoto() {
		assertArrayEquals(new String[0], this.stanza.getDirezioni());
	}
	
	@Test
	public void testGetDirezioniSingole() {
		creaEImpostaStanzaAdiacente(this.stanza, STANZA_ADIACENTE, NORD);
		String[] direzioni = new String[1];
		direzioni[0] = NORD;
		assertArrayEquals(direzioni, this.stanza.getDirezioni());
	}
	
	@Test
	public void testRemoveAttrezzo() {
		Attrezzo attrezzo = new Attrezzo(ATTREZZO, 7);
		this.stanza.addAttrezzo(attrezzo);
		assertTrue(this.stanza.removeAttrezzo(attrezzo));
	}
	
	@Test
	public void testRemoveAttrezzoInesistente() {
		assertFalse(this.stanza.removeAttrezzo(null));
	}
	
	@Test
	public void testRemoveAttrezzoErrato() {
		Attrezzo attrezzo = new Attrezzo(ATTREZZO, 7);
		this.stanza.addAttrezzo(attrezzo);
		Attrezzo attrezzo2 = new Attrezzo("Pistola", 10);
		assertFalse(this.stanza.removeAttrezzo(attrezzo2));
	}

}
