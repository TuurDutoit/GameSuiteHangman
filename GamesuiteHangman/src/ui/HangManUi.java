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
		
		while(!woord.isGeraden()) {
			String input = JOptionPane.showInputDialog(null, "Raad een letter:\n" + woord, title, JOptionPane.INFORMATION_MESSAGE);
			char letter = input.charAt(0);
			
			if(woord.raad(letter)) {
				JOptionPane.showMessageDialog(null, "Goed geraden!", title, JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(null, "Deze letter zit niet in het woord. Probeer het nog eens.", title, JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
		JOptionPane.showMessageDialog(null, "U heeft het woord geraden!\n>>> " + woord + " <<<", "GEWONNEN!", JOptionPane.INFORMATION_MESSAGE);
	}
	
}
