package it.uniroma3.diadia.giocatore;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import it.uniroma3.diadia.attrezzi.*;


class BorsaTest {
	private Borsa borsa;
	private Borsa b1;
	private Borsa b2;
	private Attrezzo falce;
	private Attrezzo pala;
	private Attrezzo sega;
	private Attrezzo racchetta;
	private Attrezzo laptop;
	private Attrezzo asta;
	private static final String ATTREZZO = "Attrezzo semplice";
	private static final int PESO_MAX = 10;
	
	@BeforeEach
	public void setUp() {
		this.borsa = new Borsa();
		this.b1 = new Borsa();
		this.b2 = new Borsa();
		this.falce = new Attrezzo("falce", 2);
		this.pala = new Attrezzo("pala", 3);
		this.sega = new Attrezzo("sega", 8);
		this.racchetta = new Attrezzo("racchetta", 3);
		this.laptop = new Attrezzo("laptop", 2);
		this.asta = new Attrezzo("asta", 2);
		
	}
	
	public Attrezzo creaAttrezzoEAggiungiInBorsa(Borsa borsa, String nomeAttrezzo, int peso) {
		Attrezzo attrezzo = new Attrezzo(ATTREZZO, 7);
		this.borsa.addAttrezzo(attrezzo);
		return attrezzo;
	}
	
	@Test
	public void testAddAttrezzoEsist() {
		Attrezzo attrezzo = creaAttrezzoEAggiungiInBorsa(this.borsa, ATTREZZO, 7);
		assertEquals(attrezzo, this.borsa.getAttrezzo(ATTREZZO));
	}
	
	@Test
	public void testAddAttrezzoTroppoPesante() {
		Attrezzo attrezzo = new Attrezzo(ATTREZZO, 11);
		assertFalse(this.borsa.addAttrezzo(attrezzo));
	}
	
	@Test
	public void testGetAttrezzoBorsaVuota() {
		assertNull(this.borsa.getAttrezzo(ATTREZZO));
	}
	
	@Test
	public void testGetAttrezzoInesistente() {
		assertNull(this.borsa.getAttrezzo(null));
	}
	
	@Test
	public void testGetPesoMax() {
		assertEquals(PESO_MAX, this.borsa.getPesoMax());
	}
	
	@Test
	public void testGetPesoIniziale() {
		assertEquals(0, this.borsa.getPeso());
	}
	
	@Test
	public void testGetPesoDopoAverAggiuntoAttrezzo() {
		creaAttrezzoEAggiungiInBorsa(this.borsa, ATTREZZO, 7);
		assertEquals(7, this.borsa.getPeso());
	}
	
	@Test
	public void testIsEmptyIniziale() {
		assertTrue(this.borsa.isEmpty());
	}
	
	@Test
	public void testIsNotEmptyAnymore() {
		creaAttrezzoEAggiungiInBorsa(this.borsa, ATTREZZO, 7);
		assertFalse(this.borsa.isEmpty());
	}
	
	@Test
	public void testHasAttrezzoInesistente() {
		assertNull(this.borsa.getAttrezzo(ATTREZZO));
	}
	
	@Test
	public void testHasAttrezzoEsistente() {
		creaAttrezzoEAggiungiInBorsa(this.borsa, ATTREZZO, 7);
		assertTrue(this.borsa.hasAttrezzo(ATTREZZO));
	}
	
	@Test
	public void testHasAttrezzoBorsaVuota() {
		assertFalse(this.borsa.hasAttrezzo(ATTREZZO));
	}
	
	@Test
	public void testRemoveAttrezzo() {
		creaAttrezzoEAggiungiInBorsa(this.borsa, ATTREZZO, 7);
		assertEquals(ATTREZZO, this.borsa.removeAttrezzo(ATTREZZO).getNome());
	}
	
	@Test
	public void testRemoveAttrezzoInesistente() {
		assertNull(this.borsa.removeAttrezzo(ATTREZZO));
	}
	
	@Test
	public void testGetSortedSetOrdinatoPerPesoAttrezziStessoPeso() {
		this.b1.addAttrezzo(falce);
		this.b1.addAttrezzo(laptop);
		Set<Attrezzo> expected = new TreeSet<>(new ComparatoreAttrezziPerPeso());
		expected.add(falce);
		expected.add(laptop);
		System.out.println(b1.getSortedSetOrdinatoPerPeso());
		assertArrayEquals(expected.toArray(), this.b1.getSortedSetOrdinatoPerPeso().toArray());
	}
	
	@Test
	public void testGetSortedSetOrdinatoPerPesoAttrezziPesoDiversi() {
		this.b2.addAttrezzo(falce);
		this.b2.addAttrezzo(pala);
		Set<Attrezzo> e = new TreeSet<>(new ComparatoreAttrezziPerPeso());
		e.add(falce);
		e.add(pala);
		System.out.println(b2.getSortedSetOrdinatoPerPeso());
		assertArrayEquals(e.toArray(), this.b2.getSortedSetOrdinatoPerPeso().toArray());
	}
	
	public boolean controllaList(List<?> c1, List<?> c2) {
		if(c1.size()!=c2.size())
			return false;
		for(int i = 0; i<c1.size(); i++ ) {
			if(!c1.get(i).equals(c2.get(i)) )
				return false;
		}
		return true;
	}

	
	@Test
	public void testGetContenutoOrdinatoPerPesoStessoPeso() {
		this.b2.addAttrezzo(falce);
		this.b2.addAttrezzo(asta);
		List<Attrezzo> e = new ArrayList<>();
		e.add(asta);
		e.add(falce);
		System.out.println(b2.getContenutoOrdinatoPerPeso());
		assertTrue(this.controllaList(e, b2.getContenutoOrdinatoPerPeso()));
	}
	
	@Test
	public void testGetContenutoOrdinatoPerPesoPesiDiversi() {
		this.b2.addAttrezzo(falce);
		this.b2.addAttrezzo(racchetta);
		List<Attrezzo> e = new ArrayList<>();
		e.add(falce);
		e.add(racchetta);
		System.out.println(b2.getContenutoOrdinatoPerPeso());
		assertTrue(this.controllaList(e, b2.getContenutoOrdinatoPerPeso()));
	}
	
	public boolean controllaSet(Set<Attrezzo> m1, Set<Attrezzo> m2) {
		if(m1.size()!=m2.size())
			return false;
		Iterator<Attrezzo> iter1 = m1.iterator();
		Iterator<Attrezzo> iter2 = m2.iterator();
		while(iter1.hasNext() && iter2.hasNext()) {
			if(!iter1.next().equals(iter2.next()))
				return false;
		}
		return true;
	}
	
	@Test
	public void testGetContenutoOrdinatoPerNomeStessoPeso() {
		this.b2.addAttrezzo(pala);
		this.b2.addAttrezzo(racchetta);
		Set<Attrezzo> e = new TreeSet<>();
		e.add(pala);
		e.add(racchetta);
		System.out.println(b2.getContenutoOrdinatoPerNome());
		assertTrue(this.controllaSet(e, b2.getContenutoOrdinatoPerNome()));
	}
	
	@Test
	public void testGetContenutoOrdinatoPerNomePesiDiversi() {
		this.b2.addAttrezzo(sega);
		this.b2.addAttrezzo(laptop);
		Set<Attrezzo> e = new TreeSet<>();
		e.add(laptop);
		e.add(sega);
		System.out.println(b2.getContenutoOrdinatoPerNome());
		assertTrue(this.controllaSet(e, b2.getContenutoOrdinatoPerNome()));
	}
	
	public boolean controllaMap(Map<Integer, Set<Attrezzo>> m1, Map<Integer, Set<Attrezzo>> m2) {
		if(m1.size()!=m2.size())
			return false;
		
		Iterator<Integer> iter1 = m1.keySet().iterator();
		Iterator<Integer> iter2 = m2.keySet().iterator();
		while(iter1.hasNext() && iter2.hasNext()) {
			if(!this.controllaSet(m1.get(iter1.next()), m2.get(iter2.next()))) {
				return false;
			}
		}
		return true;
	}
	
	@Test
	public void testGetContenutoRaggruppatoPerPesoPesiDiversiSingolo() {
		this.b2.addAttrezzo(asta);
		this.b2.addAttrezzo(pala);
		Map<Integer, Set<Attrezzo>> e = new TreeMap<>();
		Set<Attrezzo> s1 = new TreeSet<>();
		Set<Attrezzo> s2 = new TreeSet<>();
		s1.add(asta);
		s2.add(pala);
		e.put(2, s1);
		e.put(3, s2);
		System.out.println(b2.getContenutoRaggruppatoPerPeso());
		assertTrue(this.controllaMap(e, b2.getContenutoRaggruppatoPerPeso()));
	}
	
	@Test
	public void testGetContenutoRaggruppatoPerPesoPesiDiversiGruppi() {
		this.b2.addAttrezzo(asta);
		this.b2.addAttrezzo(falce);
		this.b2.addAttrezzo(pala);
		this.b2.addAttrezzo(racchetta);
		Map<Integer, Set<Attrezzo>> e = new TreeMap<>();
		Set<Attrezzo> s1 = new TreeSet<>();
		Set<Attrezzo> s2 = new TreeSet<>();
		s1.add(asta);
		s1.add(falce);
		s2.add(pala);
		s2.add(racchetta);
		e.put(2, s1);
		e.put(3, s2);
		System.out.println(b2.getContenutoRaggruppatoPerPeso());
		assertTrue(this.controllaMap(e, b2.getContenutoRaggruppatoPerPeso()));
	}
}
