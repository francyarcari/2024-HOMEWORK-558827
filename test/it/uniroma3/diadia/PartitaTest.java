package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;


class PartitaTest {
	private Partita partita;
	
	@BeforeEach
	public void setUp() {
		this.partita = new Partita();
	}
	
	@Test
	public void testGetStanzaVincenteNotNull() {
		assertNotNull(this.partita.getLabirinto().getStanzaVincente());
	}
	
	@Test
	public void testIsVinta() {
		this.partita.getLabirinto().setStanzaCorrente(this.partita.getLabirinto().getStanzaVincente());
		assertTrue(this.partita.getLabirinto().getStanzaCorrente()==this.partita.getLabirinto().getStanzaVincente());
	}
	
	@Test
	public void testIsNotVintaStanzeDiverse() {
		assertFalse(this.partita.getLabirinto().getStanzaCorrente()==this.partita.getLabirinto().getStanzaVincente());;
	}
	
	@Test
	public void testFinitaSeEspl() {
		this.partita.setFinita();
		assertTrue(this.partita.isFinita());
	}
	
	@Test
	public void testFinita0CFU() {
		this.partita.setCfu(0);
		assertTrue(this.partita.isFinita());
	}
	
	@Test
	public void testNonFinitaInizioPartita() {
		assertFalse(this.partita.isFinita());
	}

}
