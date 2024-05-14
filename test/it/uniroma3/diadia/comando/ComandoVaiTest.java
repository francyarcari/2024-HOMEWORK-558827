package it.uniroma3.diadia.comando;
import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ComandoVaiTest {
	private Stanza s1;
	private Stanza s2;
	private Partita partita;
	private Comando comando;
	private String direzione;
	private Labirinto labirinto;
	
	@BeforeEach
	public void setUp() {
		this.s1 = new Stanza("aula 1");
		this.s2 = new Stanza("aula 2");
		this.partita = new Partita(labirinto);
		this.comando = new ComandoVai(this.direzione);
		this.comando.setIO(new IOConsole());
	}
	
	@Test
	public void testVaiNull() {
		this.partita.setStanzaCorrente(s1);
		comando.setParametro(null);
		comando.esegui(partita);
		assertEquals(s1, partita.getStanzaCorrente());
	}
	
	@Test
	public void testVaiDirezioneInesistente() {
		this.partita.setStanzaCorrente(s1);
		this.s1.impostaStanzaAdiacente("est", s2);
		this.comando.setParametro("nord");
		this.comando.esegui(partita);
		assertNotEquals(s2, this.partita.getStanzaCorrente());
	}
	
	@Test
	public void testVaiDirezioneEsistente() {
		this.partita.setStanzaCorrente(s1);
		this.s1.impostaStanzaAdiacente("est", s2);
		this.comando.setParametro("est");
		this.comando.esegui(partita);
		assertEquals(s2, this.partita.getStanzaCorrente());
	}

}
