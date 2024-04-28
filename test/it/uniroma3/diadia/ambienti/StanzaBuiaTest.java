package it.uniroma3.diadia.ambienti;
import it.uniroma3.diadia.attrezzi.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StanzaBuiaTest {
	private StanzaBuia stanzaBuia;
	private Attrezzo attrezzoLucente;
	
	@BeforeEach
	public void setUp() {
		this.stanzaBuia = new StanzaBuia("Stanza Buia", "lanterna");
		this.attrezzoLucente = new Attrezzo("lanterna", 4);
	}
	
	@Test
	public void testAttrezzoLucentePresente() {
		this.stanzaBuia.addAttrezzo(attrezzoLucente);
		assertEquals(this.stanzaBuia.toString(), this.stanzaBuia.getDescrizione());
	}
	
	@Test
	public void testAttrezzoLucenteNonPresente() {
		String buio = "Qui c'è un buio pesto!";
		assertEquals(buio, this.stanzaBuia.getDescrizione());
	}
	

}
