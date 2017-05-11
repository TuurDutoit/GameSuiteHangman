package domain;

import ui.TekeningHangMan;

public class HangMan {
	private Speler speler;
	private WoordenLijst woorden;
	private HintWoord woord;
	private TekeningHangMan tekening;
	
	public HangMan(Speler speler, WoordenLijst woorden) {
		if(speler == null) {
			throw new DomainException("Speler mag niet null zijn");
		}
		if(woorden == null) {
			throw new DomainException("Woordenlijst mag niet null zijn");
		}
		
		this.speler = speler;
		this.woorden = woorden;
		this.woord = new HintWoord(woorden.getRandomWoord());
		this.tekening = new TekeningHangMan();
	}
	
	public String getHint() {
		return woord.toString();
	}
	
	public Speler getSpeler() {
		return speler;
	}
	
	public TekeningHangMan getTekening() {
		return tekening;
	}
	
	public boolean raad(char letter) {
		boolean res = woord.raad(letter);
		
		if(!res) {
			tekening.zetVolgendeZichtbaar();
		}
		
		return res;
	}
	
	public boolean isGameOver() {
		return tekening.alleVormenZichtbaar();
	}
	
	public boolean isGewonnen() {
		return woord.isGeraden();
	}
	
	public void reset() {
		woord = new HintWoord(woorden.getRandomWoord());
		tekening.reset();
	}

}
