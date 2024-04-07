package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class GiocatoreTest {
	private static final int CFU_INIZIALI = 20;
	private Giocatore giocatore;
	
	@BeforeEach
	public void setUp() {
		this.giocatore = new Giocatore();
	}
	
	@Test
	public void testCfuNonFinitiIniziali() {
		assertNotEquals(0, this.giocatore.getCfu());
	}
	
	@Test
	public void testCfuIniziali() {
		assertEquals(CFU_INIZIALI, this.giocatore.getCfu());
	}
	
	@Test
	public void testBorsaNotNull() {
		assertNotNull(this.giocatore.getBorsa());
	}
	
	
	

}
