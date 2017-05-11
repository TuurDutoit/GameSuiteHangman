package ui;

import domain.HangMan;
import domain.Speler;
import domain.WoordenLijst;

public class HangManUi {
	private Speler speler;
	private WoordenLijst lijst;

	public HangManUi(Speler speler, WoordenLijst lijst) {
		if (speler == null) {
			throw new UiException("Speler mag niet null zijn");
		}

		this.speler = speler;
		this.lijst = lijst;
	}
	
	public void play() {
		HangMan spel = new HangMan(speler, lijst);
		HangmanPaneel paneel = new HangmanPaneel(spel);
		HangManHoofdScherm scherm = new HangManHoofdScherm(spel, paneel);
		scherm.start();
	}

}
