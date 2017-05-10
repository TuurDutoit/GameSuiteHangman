package ui;

import javax.swing.JOptionPane;

import domain.Speler;

public class Launcher {
	
	public static void main(String[] args) {
		try {
			String naam = JOptionPane.showInputDialog("Welkom!\nHoe heet je?");
			Speler speler = new Speler(naam);
			JOptionPane.showMessageDialog(null, speler.toString(), speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);
		
			PictionaryUi ui = new PictionaryUi(speler);
			ui.showMenu();
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Er is een fout opgetreden: " + e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
		}
	}
	
}
