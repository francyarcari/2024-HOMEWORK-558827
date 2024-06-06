package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.*;
import org.junit.jupiter.api.BeforeEach;
import java.io.FileNotFoundException;

class LabirintoTest {
	private Labirinto labirinto;
	Stanza biblioteca;
	Stanza DS1;
	
	@BeforeEach
	public void setUp() throws FileNotFoundException, FormatoFileNonValidoException {
		this.labirinto = Labirinto.newBuilder("labirinto2").getLabirinto();
		this.biblioteca = new Stanza("biblioteca");
		this.DS1 = new Stanza("DS1");
	}
	
	@Test
	public void testGetStanzaVincente() {
		assertEquals("Biblioteca", this.labirinto.getStanzaVincente().getNome());
	}


	@Test
	public void testSetStanzaCorrente() {
		this.labirinto.setStanzaCorrente(DS1);
		assertEquals(DS1, this.labirinto.getStanzaCorrente());
	}
	@Test
	public void testGetStanzaCorrente() {
		assertEquals("Atrio", this.labirinto.getStanzaCorrente().getNome());
	}

	
}
