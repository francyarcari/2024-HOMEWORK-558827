package it.uniroma3.diadia.comando;
import it.uniroma3.diadia.*;
import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.attrezzi.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class ComandoPosaTest {
	private Partita partita;
	private IO io;
	private Attrezzo attrezzo;
	private Comando comando;

	@BeforeEach
	public void setUp() {
		this.partita = new Partita();
		this.attrezzo = new Attrezzo("osso", 2);
		this.comando = new ComandoPosa();
		this.io = new IOConsole();
		comando.setIO(io);
	}
	
	@AfterEach
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testAttrezzoPosato() {
		this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
		comando.setParametro("osso");
		comando.esegui(partita);
		assertTrue(this.partita.getStanzaCorrente().hasAttrezzo("osso"));
	}
	
	@Test
	public void testAttrezzoNull() {
		comando.setParametro("osso");
		comando.esegui(partita);
		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo("osso"));
	}
}
