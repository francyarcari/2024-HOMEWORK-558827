package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import org.junit.jupiter.api.BeforeEach;

class StanzaTest {
	Stanza s1 = new Stanza("s1");
	Stanza s2= new Stanza("s2");
	Attrezzo m = new Attrezzo("martello", 42);
	@Test
	public void testGetStanzaAdiacente() {
		assertNull(s1.getStanzaAdiacente(Direzione.sud));
	}
	

	@Test
	public void testImpostaStanzaAdiacente() {
		s1.impostaStanzaAdiacente(Direzione.sud, s2);
		assertEquals(s2, s1.getStanzaAdiacente(Direzione.sud));
	}
	
	@Test
	public void testAddAttrezzo() {
		
		assertTrue(s1.addAttrezzo(m));
	}
	
	@Test
	public void testRemoveAttrezzo() {
		s1.addAttrezzo(m);
		assertTrue(s1.removeAttrezzo(m));
	}
	
	@Test
	public void testHasAttrezzo() {
		s1.addAttrezzo(m);
		assertTrue(s1.hasAttrezzo(m.getNome()));
	}
	
	@Test
	public void testGetAttrezzo() {
		s1.addAttrezzo(m);
		assertEquals(m, s1.getAttrezzo(m.getNome()));
	}

	
	
}
