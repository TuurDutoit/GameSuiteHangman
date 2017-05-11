package ui;

import javax.swing.JOptionPane;

import domain.HintWoord;
import domain.Speler;

public class HangManUi {
	private Speler speler;
	private String title;
	
	public HangManUi(Speler speler) {
		if(speler == null) {
			throw new UiException("Speler mag niet null zijn");
		}
		
		this.speler = speler;
		this.title = "HangMan - " + speler.getNaam();
	}
	
	public void play() {
		HintWoord woord = new HintWoord("test");
		TekeningHangMan tekening = new TekeningHangMan();
		GameHoofdScherm view = new GameHoofdScherm(speler.getNaam(), tekening);
		view.setVisible(true);
		view.teken();
		boolean juist = false;
		char letter = 0;
		
		while(!woord.isGeraden()) {
			String content = "";
			
			if(letter != 0) {
				if(juist) {
					content += letter + " is juist geraden!\n\n";
				}
				else {
					content += letter + " zit niet in het woord (of heb je al eens geprobeerd)...\n\n";
					tekening.zetVolgendeZichtbaar();
					view.teken();
					
					if(tekening.alleVormenZichtbaar()) {
						break;
					}
				}
			}
			
			content += "Raad een letter:\n\n" + woord;
			String input = JOptionPane.showInputDialog(null, content, title, JOptionPane.INFORMATION_MESSAGE);
			letter = input.charAt(0);
			juist = woord.raad(letter);
		}
		
		if(woord.isGeraden()) {
			JOptionPane.showMessageDialog(null, "U heeft het woord geraden!\n\n>>> " + woord + " <<<", "GEWONNEN!", JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			JOptionPane.showMessageDialog(null,  "U heeft het woord niet geraden...\nHet woord was:\n\n" + woord.getWoord(), "VERLOREN", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
}
