package ui;

import javax.swing.JOptionPane;

import domain.Cirkel;
import domain.Punt;
import domain.Speler;

public class Launcher {

	public static void main(String[] args) {
		try {
			String naam = JOptionPane.showInputDialog("Welkom! \nHoe heet je?");
			Speler speler = new Speler(naam);
			
			JOptionPane.showMessageDialog(null, "... heeft als score: "+speler.getScore(), speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);
		
		
			int x = Integer.parseInt(JOptionPane.showInputDialog("x coordinaat van het punt:"));
			int y = Integer.parseInt(JOptionPane.showInputDialog("y coordinaat van het punt:"));
			int r = Integer.parseInt(JOptionPane.showInputDialog("Radius van de cirkel:"));
			
			Punt punt = new Punt(x, y);
			Cirkel cirkel = new Cirkel(punt, r);
			
			JOptionPane.showMessageDialog(null, "U heeft een correcte cirkel aangemaakt: " + cirkel.toString(), speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);
		}
		catch(Exception exc) {
			JOptionPane.showMessageDialog(null,  "Er is een fout opgetreden: " + exc.getMessage(), "Fout", JOptionPane.ERROR_MESSAGE);
		}
	}
	
}
