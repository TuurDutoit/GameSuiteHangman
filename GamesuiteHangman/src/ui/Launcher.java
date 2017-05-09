package ui;

import javax.swing.JOptionPane;

import domain.Punt;
import domain.Speler;

public class Launcher {

	public static void main(String[] args) {
		String naam = JOptionPane.showInputDialog("Welkom! \nHoe heet je?");
		Speler speler = new Speler(naam);
		
		JOptionPane.showMessageDialog(null, "... heeft als score: "+speler.getScore(), speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);
	
		int x = Integer.parseInt(JOptionPane.showInputDialog("x coordinaat van het punt:"));
		int y = Integer.parseInt(JOptionPane.showInputDialog("y coordinaat van het punt:"));
		
		Punt punt = new Punt(x, y);
		
		JOptionPane.showMessageDialog(null, "U heeft een correct punt aangemaakt: " + punt.toString() ,speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);
		
		Object[] shapes = {"Cirkel", "Rechthoek"};
		Object keuze = JOptionPane.showInputDialog(null, "Wat wilt u tekenen", "input", JOptionPane.INFORMATION_MESSAGE, null, shapes, null);
		if(keuze=="Cirkel")
		{
			
		}
		else if(keuze == "Rechthoek")
		{
			JOptionPane.showInputDialog("Wat moet u weten");

		}
		
		
		
		
				
		
	}

}
