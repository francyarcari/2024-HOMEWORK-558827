package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.attrezzi.*;

class StanzaMagicaTest {
	final static private int SOGLIA_MAGICA_DEFAULT = 3;
	final static private String STANZA = "Stanza magica di test ";
	private StanzaMagica stanzaMagica;
	
	@BeforeEach
	public void setUp() {
		this.stanzaMagica = new StanzaMagica(STANZA, SOGLIA_MAGICA_DEFAULT);
	}
	
	@Test
	public void modificaAttrezzoTest() {
		Attrezzo attrezzo = new Attrezzo("spada", 7);
		Attrezzo attrezzoMagico = new Attrezzo ("adaps", 14);
		assertEquals(attrezzoMagico, this.stanzaMagica.modificaAttrezzo(attrezzo));
	}
	
	@Test
	public void modificaAttrezzoSbagliatoTest() {
		Attrezzo attrezzo = new Attrezzo("scudo", 10);
		Attrezzo attrezzoMagico = new Attrezzo("oducs", 22);
		assertNotEquals(attrezzoMagico, this.stanzaMagica.modificaAttrezzo(attrezzo));
	}
			
}
