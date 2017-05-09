package ui;

import javax.swing.JOptionPane;

import domain.Cirkel;
import domain.Punt;
import domain.Rechthoek;
import domain.Speler;

public class Launcher {

	public static void main(String[] args) {
		try {
			String naam = JOptionPane.showInputDialog("Welkom! \nHoe heet je?");
			Speler speler = new Speler(naam);
			
			JOptionPane.showMessageDialog(null, "... heeft als score: "+speler.getScore(), speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);
		
			int x = Integer.parseInt(JOptionPane.showInputDialog("x coordinaat van het punt:"));
			int y = Integer.parseInt(JOptionPane.showInputDialog("y coordinaat van het punt:"));
			Punt punt = new Punt(x, y);
			JOptionPane.showMessageDialog(null, "U heeft een correct punt aangemaakt: " + punt.toString() ,speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);
			
			Object[] shapes = {"Cirkel", "Rechthoek"};
			Object keuze = JOptionPane.showInputDialog(null, "Wat wilt u tekenen", "input", JOptionPane.INFORMATION_MESSAGE, null, shapes, null);
			
			if(keuze=="Rechthoek") {
				int breedte = Integer.parseInt(JOptionPane.showInputDialog("Breedte van de Rechtoek"));
				int hoogte = Integer.parseInt(JOptionPane.showInputDialog("Hoogte van de Rechthoek"));
				Rechthoek rechthoek = new Rechthoek(punt, breedte, hoogte);
				JOptionPane.showMessageDialog(null, "U heeft een correcte rechthoek aangemaakt: " + rechthoek.toString(), speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);
	
				
			}
			else if(keuze == "Circle") {	
			
				
				int r = Integer.parseInt(JOptionPane.showInputDialog("Radius van de cirkel:"));
				
				
				Cirkel cirkel = new Cirkel(punt, r);
				
				JOptionPane.showMessageDialog(null, "U heeft een correcte cirkel aangemaakt: " + cirkel.toString(), speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);
			}
		}
		catch(Exception exc) {
			JOptionPane.showMessageDialog(null,  "Er is een fout opgetreden: " + exc.getMessage(), "Fout", JOptionPane.ERROR_MESSAGE);
		}
	}
	
}
