package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import it.uniroma3.diadia.attrezzi.*;


class BorsaTest {
	private Borsa borsa;
	private static final String ATTREZZO = "Attrezzo semplice";
	private static final int PESO_MAX = 10;
	
	@BeforeEach
	public void setUp() {
		this.borsa = new Borsa();
	}
	
	public Attrezzo creaAttrezzoEAggiungiInBorsa(Borsa borsa, String nomeAttrezzo, int peso) {
		Attrezzo attrezzo = new Attrezzo(ATTREZZO, 7);
		this.borsa.addAttrezzo(attrezzo);
		return attrezzo;
	}
	
	@Test
	public void testAddAttrezzoEsist() {
		Attrezzo attrezzo = creaAttrezzoEAggiungiInBorsa(this.borsa, ATTREZZO, 7);
		assertEquals(attrezzo, this.borsa.getAttrezzo(ATTREZZO));
	}
	
	@Test
	public void testAddAttrezzoTroppoPesante() {
		Attrezzo attrezzo = new Attrezzo(ATTREZZO, 11);
		assertFalse(this.borsa.addAttrezzo(attrezzo));
	}
	
	@Test
	public void testGetAttrezzoBorsaVuota() {
		assertNull(this.borsa.getAttrezzo(ATTREZZO));
	}
	
	@Test
	public void testGetAttrezzoInesistente() {
		assertNull(this.borsa.getAttrezzo(null));
	}
	
	@Test
	public void testGetPesoMax() {
		assertEquals(PESO_MAX, this.borsa.getPesoMax());
	}
	
	@Test
	public void testGetPesoIniziale() {
		assertEquals(0, this.borsa.getPeso());
	}
	
	@Test
	public void testGetPesoDopoAverAggiuntoAttrezzo() {
		creaAttrezzoEAggiungiInBorsa(this.borsa, ATTREZZO, 7);
		assertEquals(7, this.borsa.getPeso());
	}
	
	@Test
	public void testIsEmptyIniziale() {
		assertTrue(this.borsa.isEmpty());
	}
	
	@Test
	public void testIsNotEmptyAnymore() {
		creaAttrezzoEAggiungiInBorsa(this.borsa, ATTREZZO, 7);
		assertFalse(this.borsa.isEmpty());
	}
	
	@Test
	public void testHasAttrezzoInesistente() {
		assertNull(this.borsa.getAttrezzo(ATTREZZO));
	}
	
	@Test
	public void testHasAttrezzoEsistente() {
		creaAttrezzoEAggiungiInBorsa(this.borsa, ATTREZZO, 7);
		assertTrue(this.borsa.hasAttrezzo(ATTREZZO));
	}
	
	@Test
	public void testHasAttrezzoBorsaVuota() {
		assertFalse(this.borsa.hasAttrezzo(ATTREZZO));
	}
	
	@Test
	public void testRemoveAttrezzo() {
		creaAttrezzoEAggiungiInBorsa(this.borsa, ATTREZZO, 7);
		assertEquals(ATTREZZO, this.borsa.removeAttrezzo(ATTREZZO).getNome());
	}
	
	@Test
	public void testRemoveAttrezzoInesistente() {
		assertNull(this.borsa.removeAttrezzo(ATTREZZO));
	}
}
