package it.uniroma3.diadia;
import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.*;
import it.uniroma3.diadia.attrezzi.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Fixture {
		public static IOSimulator creaSimulazionePartitaEGiocaEasy(List<String> comandiDaLeggere) {
			IOSimulator io = new IOSimulator(comandiDaLeggere);
			Labirinto labirinto = new LabirintoBuilder()
					.addStanzaIniziale("Atrio")
					.addAttrezzo("martello", 3)
					.addStanzaVincente("Biblioteca")
					.addAdiacenza("Atrio", "Biblioteca", "nord")
					.addAdiacenza("Biblioteca", "Atrio", "sud")
					.getLabirinto();
			DiaDia gioco = new DiaDia(io, labirinto);
			gioco.gioca();
			return io;
		}

		public static IOSimulator creaSimulazionePartitaEGiocaHard(List<String> comandiDaLeggere) {
			IOSimulator io = new IOSimulator(comandiDaLeggere);
			Labirinto labirinto = new LabirintoBuilder()
					.addStanzaIniziale("Atrio")
					.addAttrezzo("martello", 3)
					.addStanzaVincente("Biblioteca")
					.addAdiacenza("Atrio", "Biblioteca", "nord")
					.addAdiacenza("Biblioteca", "Atrio", "sud")
					.addStanza("Bagno")
					.addAdiacenza("Bagno", "Atrio", "sud")
					.addAdiacenza("Atrio", "Bagno", "nord")
					.addStanza("Studio")
					.addAdiacenza("Studio", "Atrio", "est")
					.addAdiacenza("Atrio", "Studio", "ovest")
					.getLabirinto();
			DiaDia gioco = new DiaDia(io, labirinto);
			gioco.gioca();
			return io;
		}

		public static IOSimulator creaSimulazionePartitaEGiocaMonolocale(List<String> comandiDaLeggere) {
			IOSimulator io = new IOSimulator(comandiDaLeggere);
			Labirinto monolocale = new LabirintoBuilder()
					.addStanzaIniziale("salotto") 
					.addStanzaVincente("salotto") 
					.getLabirinto();
			DiaDia gioco = new DiaDia(io, monolocale);
			gioco.gioca();
			return io;
		}
		
		
		public static IOSimulator creaSimulazionePartitaEGiocaBilocale(List<String> comandiDaLeggere) {
			IOSimulator io = new IOSimulator(comandiDaLeggere);
			Labirinto bilocale = new LabirintoBuilder()
					.addStanzaIniziale("salotto")
					.addStanzaVincente("camera")
					.addAttrezzo("letto",10) // dove? fa riferimento all’ultima stanza aggiunta
					.addAdiacenza("salotto", "camera", "nord") // camera si trova a nord di salotto
					.getLabirinto();
			DiaDia gioco = new DiaDia(io, bilocale);
			gioco.gioca();
			return io;
		}
		
		public static IOSimulator creaSimulazionePartitaEGiocaTrilocale(List<String> comandiDaLeggere) {
			IOSimulator io = new IOSimulator(comandiDaLeggere);
			Labirinto trilocale = new LabirintoBuilder()
					.addStanzaIniziale("salotto")
					.addStanza("cucina")
					.addAttrezzo("pentola",1) // dove? fa riferimento all’ultima stanza aggiunta
					.addStanzaVincente("camera")
					.addAdiacenza("salotto", "cucina", "nord")
					.addAdiacenza("cucina", "camera", "est")
					.getLabirinto();
			DiaDia gioco = new DiaDia(io, trilocale);
			gioco.gioca();
			return io;
		}

		public static Attrezzo creaAttrezzoEAggiugniAStanza(Stanza stanzaDaRiempire, String nomeAttrezzo, int peso) {
			Attrezzo attrezzo = new Attrezzo(nomeAttrezzo, peso);
			stanzaDaRiempire.addAttrezzo(attrezzo);
			return attrezzo;
		}


}
