package ui;

import javax.swing.JOptionPane;

import domain.Cirkel;
import domain.Punt;
import domain.Rechthoek;
import domain.Speler;

public class Launcher {

	public static void main(String[] args) {
		try {
			// Speler
			String naam = JOptionPane.showInputDialog("Welkom! \nHoe heet je?");
			Speler speler = new Speler(naam);
			
			JOptionPane.showMessageDialog(null, "... heeft als score: "+speler.getScore(), speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);
			
			// Punt
			int x = Integer.parseInt(JOptionPane.showInputDialog("x coordinaat van het punt:"));
			int y = Integer.parseInt(JOptionPane.showInputDialog("y coordinaat van het punt:"));
			Punt punt = new Punt(x, y);
			
			JOptionPane.showMessageDialog(null, "U heeft een correct punt aangemaakt: " + punt.toString() ,speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);
			
			// Keuze
			Object[] shapes = {"Cirkel", "Rechthoek","LijnStuk", "Driehoek"};
			Object keuze = JOptionPane.showInputDialog(null, "Wat wilt u tekenen", "input", JOptionPane.INFORMATION_MESSAGE, null, shapes, null);
			
			if(keuze == "Rechthoek") {
				int breedte = Integer.parseInt(JOptionPane.showInputDialog("Breedte van de Rechtoek"));
				int hoogte = Integer.parseInt(JOptionPane.showInputDialog("Hoogte van de Rechthoek"));
				Rechthoek rechthoek = new Rechthoek(punt, breedte, hoogte);
				JOptionPane.showMessageDialog(null, "U heeft een correcte rechthoek aangemaakt: " + rechthoek.toString(), speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);
			}
			else if(keuze == "Cirkel") {
				int r = Integer.parseInt(JOptionPane.showInputDialog("Radius van de cirkel:"));
				Cirkel cirkel = new Cirkel(punt, r);
				JOptionPane.showMessageDialog(null, "U heeft een correcte cirkel aangemaakt: " + cirkel.toString(), speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);
			}
			else if(keuze == "LijnStuk") {	
				int eindex = Integer.parseInt(JOptionPane.showInputDialog("x coordinaat van het eind punt:"));
				int eindey = Integer.parseInt(JOptionPane.showInputDialog("y coordinaat van het eind punt:"));
				Punt einde = new Punt(eindex, eindey);
				JOptionPane.showMessageDialog(null, "U heeft een correcte lijn aangemaakt: " + punt.toString() +einde.toString(),speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);
	
				
				
			}
			else if(keuze == "Driehoek") {
				int x1 = Integer.parseInt(JOptionPane.showInputDialog("x coordinaat van het punt 1:"));
				int y1 = Integer.parseInt(JOptionPane.showInputDialog("y coordinaat van het punt 1:"));		
				int x2 = Integer.parseInt(JOptionPane.showInputDialog("x coordinaat van het punt 2:"));
				int y2 = Integer.parseInt(JOptionPane.showInputDialog("y coordinaat van het punt 2:"));	
				Punt punt1 = new Punt(x1,y1);
				Punt punt2 = new Punt(x2,y2);
				JOptionPane.showMessageDialog(null, "U heeft een correcte driehoek aangemaakt: " + punt.toString()+ punt1.toString() +punt2.toString() ,speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);
	
			}
		}
		catch(Exception exc) {
			JOptionPane.showMessageDialog(null,  "Er is een fout opgetreden: " + exc.getMessage(), "Fout", JOptionPane.ERROR_MESSAGE);
		}
	}
	
}
