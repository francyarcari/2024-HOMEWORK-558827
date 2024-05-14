package it.uniroma3.diadia.ambienti;
import it.uniroma3.diadia.attrezzi.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

class LabirintoBuilderTest {

	private LabirintoBuilder lb;
	
	@BeforeEach
	public void setUp() throws Exception{
		lb = new LabirintoBuilder();
	}
	
	@AfterEach
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void testGetLabirinto() {
		assertNotNull(lb.getLabirinto());
		assertEquals(Labirinto.class, lb.getLabirinto().getClass());
	}
	
	@Test
	public void testAddStanza() {
		this.lb.addStanza("Stanza");
		Stanza stanza = new Stanza("Stanza");
		assertEquals(stanza, this.lb.getStanze().get("Stanza"));
	}
	
	@Test
	public void testAddAttrezzoSenzaUltimaStanzaAggiunta() {
		assertEquals(LabirintoBuilder.class, this.lb.addAttrezzo("martello", 4).getClass());
	}
	
	@Test
	public void testAddAttrezzoConUltimaStanzaAggiunta() {
		this.lb.addStanzaIniziale("stanza").addAttrezzo("martello", 4);
		Attrezzo attrezzo = new Attrezzo("martello", 4);
		assertEquals(attrezzo, this.lb.getLabirinto().getStanzaCorrente().getAttrezzo("martello"));
	}
	
	@Test
	public void testAddAttrezzoConStanza() {
		this.lb.addStanza("stanza");
		this.lb.addAttrezzo("martello", 4);
		assertTrue(this.lb.getStanze().get("stanza").hasAttrezzo("martello"));
	}
	
	@Test
	public void testAddAdiacenza() {
		this.lb.addStanzaIniziale("stanza1");
		this.lb.addStanza("stanza2");
		this.lb.addAdiacenza("stanza1", "stanza2", "ovest");
		Stanza s1 = new Stanza("stanza1");
		Stanza s2 = new Stanza("stanza2");
		s1.impostaStanzaAdiacente("ovest", s2);
		assertEquals(s2, this.lb.getStanze().get("stanza1").getStanzaAdiacente("ovest"));
	}
	
	
	
	

}
