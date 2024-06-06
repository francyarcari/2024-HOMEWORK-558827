package it.uniroma3.diadia.personaggi;
import it.uniroma3.diadia.*;
import it.uniroma3.diadia.attrezzi.*;

public abstract class AbstractPersonaggio {
	private String nome;
	private String presentazione;
	private boolean haSalutato;
	
	public AbstractPersonaggio(String nome, String presentazione) {
		this.nome = nome;
		this.presentazione = presentazione;
		this.haSalutato = false;
	}

	public String getNome() {
		return this.nome;
	}

	public String getPresentazione() {
		return this.presentazione;
	}

	public boolean isHaSalutato() {
		return this.haSalutato;
	}
	
	public String saluta() {
		StringBuilder risposta = new StringBuilder("Ciao, io sono ");
		risposta.append(this.getNome()+".");
		if(!isHaSalutato()) {
			risposta.append(this.presentazione);
		}
		else {
			risposta.append("Ci siamo già presentati!");
		}
		this.haSalutato = true;
		return risposta.toString();
	}
	
	abstract public String agisci(Partita partita);
	
	@Override
	public String toString() {
		return this.getNome();
	}
	
	abstract public String riceviRegalo(Attrezzo attrezzo, Partita partita);

}
