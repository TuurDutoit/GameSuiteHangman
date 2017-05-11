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
				}
			}
			
			content += "Raad een letter:\n\n" + woord;
			String input = JOptionPane.showInputDialog(null, content, title, JOptionPane.INFORMATION_MESSAGE);
			letter = input.charAt(0);
			juist = woord.raad(letter);
		}
		
		JOptionPane.showMessageDialog(null, "U heeft het woord geraden!\n\n>>> " + woord + " <<<", "GEWONNEN!", JOptionPane.INFORMATION_MESSAGE);
	}
	
}
