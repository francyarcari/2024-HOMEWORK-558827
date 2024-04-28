package it.uniroma3.diadia.ambienti;
import it.uniroma3.diadia.attrezzi.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StanzaBloccataTest {
	private StanzaBloccata stanzaBloccata;
	private Stanza stanzaAdiacente;
	private Attrezzo attrezzoSbloccante;
	
	@BeforeEach
	public void setUp() {
		this.stanzaBloccata = new StanzaBloccata("Stanza Bloccata", "ovest", "grimaldello");
		this.stanzaAdiacente = new Stanza("Magazzino");
		this.attrezzoSbloccante = new Attrezzo("grimaldello", 1);
		this.stanzaBloccata.impostaStanzaAdiacente("ovest", stanzaAdiacente);
	}
	
	@Test
	public void testGetStanzaAdiacenteDirezioneBloccata() {
		assertEquals(this.stanzaBloccata, this.stanzaBloccata.getStanzaAdiacente("ovest"));
	}
	
	@Test
	public void testGetStanzaAdiacenteDirezioneSbloccata() {
		this.stanzaBloccata.addAttrezzo(attrezzoSbloccante);
		assertEquals(this.stanzaAdiacente, this.stanzaBloccata.getStanzaAdiacente("ovest"));
	}
	
	@Test
	public void testGetDescrizioneStanzaSbloccata() {
		this.stanzaBloccata.addAttrezzo(attrezzoSbloccante);
		assertEquals(this.stanzaBloccata.toString(), this.stanzaBloccata.getDescrizione());
	}
	
	@Test
	public void testGetDescrizioneStanzaBloccata() {
		String bloccata = "Stanza bloccata nella direzione: ovest"+".\nPrendi l'attrezzo grimaldello"
				+ " e posalo nella stanza.";
		assertEquals(bloccata, this.stanzaBloccata.getDescrizione());
	}
}
