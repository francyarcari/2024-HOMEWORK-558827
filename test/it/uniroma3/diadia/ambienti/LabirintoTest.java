package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;

import org.junit.jupiter.api.BeforeEach;

class LabirintoTest {
	private Labirinto labirinto;
	
	@BeforeEach
	public void setUp() {
		this.labirinto = new Labirinto();
	}
	
	@Test
	public void testStanzaCorrenteNotNull() {
		assertNotNull(this.labirinto.getStanzaCorrente());
	}
	
	@Test
	public void testStanzaVincenteNotNull() {
		assertNotNull(this.labirinto.getStanzaVincente());
	}
	
}
