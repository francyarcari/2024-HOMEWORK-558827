package it.uniroma3.diadia.comando;
import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class ComandoPrendiTest {
	private Stanza stanza;
	private Attrezzo attrezzo;
	private Attrezzo attrezzoNull;
	private Attrezzo attrezzoPesante;
	private Comando comando;
	private Partita partita;
	private IO io;
	
	@BeforeEach
	public void setUp() {
		this.partita = new Partita();
		this.stanza = new Stanza("Stanza di test");
		this.attrezzo = new Attrezzo("osso", 2);
		this.attrezzoPesante = new Attrezzo("alabarda", 12);
		this.attrezzoNull = null;
		this.comando = new ComandoPrendi();
		this.io = new IOConsole();
		comando.setIO(io);
	}
	
	@AfterEach
	public void tearDown() throws Exception {
	}

	
	public boolean attrezzoPresente(String s) {
		Attrezzo[] array = partita.getStanzaCorrente().getAttrezzi();
		for(Attrezzo a : array) {
			if(a != null && s.equals(a.getNome()))
					return true;
		}
		return false;
	}


	@Test
	public void testStanzaVuota() {
		comando.setParametro("osso");
		comando.esegui(partita);
		assertFalse(attrezzoPresente("osso"));
	}
	
	@Test
	public void testAttrezzoPreso() {
		partita.getStanzaCorrente().addAttrezzo(attrezzo);
		comando.setParametro("osso");
		comando.esegui(partita);
		assertTrue(attrezzoPresente("osso"));
	}
	
	@Test
	public void testAttrezzoPesante() {
		partita.getStanzaCorrente().addAttrezzo(attrezzoPesante);
		comando.setParametro("alabarda");
		comando.esegui(partita);
		assertTrue(attrezzoPresente("alabarda"));
	}
}
