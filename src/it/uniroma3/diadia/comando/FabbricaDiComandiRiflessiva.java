package it.uniroma3.diadia.comando;
import it.uniroma3.diadia.*;
import java.util.Scanner;

public class FabbricaDiComandiRiflessiva implements FabbricaDiComandi{
	private IO io;
	
	public FabbricaDiComandiRiflessiva(IO io) {
		this.io = io;
	}
	
	public Comando costruisciComando(String istruzione) throws Exception{
		Scanner scannerDiParole = new Scanner(istruzione);
		String nomeComando = null;
		String parametro = null;
		Comando comando = null;
		
		if(scannerDiParole.hasNext()) {
			nomeComando = scannerDiParole.next();
		}
		if(scannerDiParole.hasNext()) {
			parametro = scannerDiParole.next();
		}
		
		StringBuilder nomeClasse = new StringBuilder("it.uniroma3.diadia.comando.Comando");
		nomeClasse.append(Character.toUpperCase(nomeComando.charAt(0)));
		nomeClasse.append(nomeComando.substring(1));
		comando = (Comando)Class.forName(nomeClasse.toString()).getDeclaredConstructor().newInstance();
		comando.setParametro(parametro);
		comando.setIO(io);
		return comando;
		
	}

}
