package ui;

import javax.swing.JOptionPane;

import domain.Speler;

public class Launcher {
	
	private static final String[] spelen = {"Hangman", "Pictionary"};
	
	public static void main(String[] args) {
		try {
			String naam = JOptionPane.showInputDialog("Welkom!\nHoe heet je?");
			Speler speler = new Speler(naam);
			JOptionPane.showMessageDialog(null, speler.toString(), speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);
			PictionaryUi ui = new PictionaryUi(speler);
			
			String keuze = (String) JOptionPane.showInputDialog(null, "Dag " + speler.getNaam() + ", welk spel wil u spelen?", "Input", JOptionPane.INFORMATION_MESSAGE, null, spelen, null);
			switch(keuze) {
			case "Hangman":
				break;
				
			case "Pictionary":
				ui.showMenu();
				break;
			}
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Er is een fout opgetreden: " + e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
		}
	}
	
}
