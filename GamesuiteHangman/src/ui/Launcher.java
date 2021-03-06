package ui;

import javax.swing.JOptionPane;

import db.WoordenLezer;
import domain.Speler;
import domain.WoordenLijst;

public class Launcher {
	private static final String[] games = {"HangMan", "Pictionary"};
	
	public static void main(String[] args) {
		try {
			String naam = JOptionPane.showInputDialog("Welkom!\nHoe heet je?");
			Speler speler = new Speler(naam);
			JOptionPane.showMessageDialog(null, speler.toString(), speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);
			
			String game = (String) JOptionPane.showInputDialog(null, "Dag " + naam + ", welk spel wilt u spelen?", "Keuze spel", JOptionPane.INFORMATION_MESSAGE, null, games, null);
			
			if(game.equals("Pictionary")) {
				PictionaryUi ui = new PictionaryUi(speler);
				ui.showMenu();
			}
			else {
				WoordenLijst woordenLijst = new WoordenLezer("hangman.txt").lees();
				HangManUi ui = new HangManUi(speler, woordenLijst);
				ui.play();
			}
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Er is een fout opgetreden: " + e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
		}
	}
	
}
