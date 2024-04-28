package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza {
	private String direzioneBloccata;
	private String attrezzoSbloccante;
	
	public StanzaBloccata(String nome, String direzioneBloccata, String attrezzoSbloccante) {
		super(nome);
		this.direzioneBloccata = direzioneBloccata;
		this.attrezzoSbloccante = attrezzoSbloccante;
	}
	
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if(this.direzioneBloccata.equals(direzione) && !this.hasAttrezzo(attrezzoSbloccante)) {
			return this;
		}
		else
			return super.getStanzaAdiacente(direzione);
	}
	
	@Override
	public String getDescrizione() {
		String bloccata = "Stanza bloccata nella direzione: "+this.direzioneBloccata+"."
				+ "\nPrendi l'attrezzo "+this.attrezzoSbloccante+" e posalo nella stanza.";
		if(!this.hasAttrezzo(this.attrezzoSbloccante)) {
			return bloccata;
		}
		else
			return super.getDescrizione();
	}
}