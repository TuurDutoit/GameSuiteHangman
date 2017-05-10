package ui;

import javax.swing.JOptionPane;

import domain.Cirkel;
import domain.DomainException;
import domain.Driehoek;
import domain.LijnStuk;
import domain.Punt;
import domain.Rechthoek;
import domain.Speler;
import domain.Tekening;

public class PictionaryUi {
	private static final String[] shapes = {"Cirkel", "Rechthoek", "Lijnstuk", "Driehoek"};
	private static final String[] actions = {"Vorm maken", "Tekening tonen", "Stoppen"};
	private Speler speler;
	private Tekening tekening;
	
	public PictionaryUi(Speler speler) {
		if(speler == null) {
			throw new DomainException("Speler mag niet null zijn");
		}
		
		this.speler = speler;
	}
	
	
	public void showMenu() {
		try {
			// Tekening
			String naamTekening = JOptionPane.showInputDialog("Geef de naam van je tekening:");
			tekening = new Tekening(naamTekening);
			
			boolean keepGoing = true;
			
			while(keepGoing) {
				String keuze = (String) JOptionPane.showInputDialog(null, "Wat wilt u tekenen?", "Input", JOptionPane.INFORMATION_MESSAGE, null, actions, null);
				
				switch(keuze) {
					case "Vorm maken":
						maakVorm();
						break;
						
					case "Tekening tonen":
						toonTekening();
						break;
						
					case "Stoppen":
						keepGoing = false;
						break;
					
					default:
						JOptionPane.showMessageDialog(null, "Ongeldige actie", null, JOptionPane.WARNING_MESSAGE);
				}
			}
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Er is een fout opgetreden: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void toonTekening() {
		GameHoofdScherm view = new GameHoofdScherm(speler.getNaam(), tekening);
		view.setVisible(true);
		view.teken();
	}
	
	public void maakVorm() {
		// Punt
		int x = Integer.parseInt(JOptionPane.showInputDialog("x coordinaat van het punt:"));
		int y = Integer.parseInt(JOptionPane.showInputDialog("y coordinaat van het punt:"));
		Punt punt = new Punt(x, y);
		
		String keuze = (String) JOptionPane.showInputDialog(null, "Wat wilt u tekenen?", "Input", JOptionPane.INFORMATION_MESSAGE, null, shapes, null);
		int x2, y2;
		
		switch(keuze) {
			case "Cirkel":
				int radius = Integer.parseInt(JOptionPane.showInputDialog("Radius van de cirkel:"));
				Cirkel cirkel = new Cirkel(punt, radius);
				tekening.voegToe(cirkel);
				JOptionPane.showMessageDialog(null, "U heeft een correcte cirkel aangemaakt: " + cirkel, speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);
				break;
			
			case "Rechthoek":
				int breedte = Integer.parseInt(JOptionPane.showInputDialog("Breedte van de rechthoek:"));
				int hoogte = Integer.parseInt(JOptionPane.showInputDialog("Hoogte van de rechthoek:"));
				Rechthoek rechthoek = new Rechthoek(punt, breedte, hoogte);
				tekening.voegToe(rechthoek);
				JOptionPane.showMessageDialog(null, "U heeft een correcte rechthoek aangemaakt: " + rechthoek, speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);
				break;
			
			case "Lijnstuk":
				x2 = Integer.parseInt(JOptionPane.showInputDialog("x coordinaat van het eindpunt:"));
				y2 = Integer.parseInt(JOptionPane.showInputDialog("y coordinaat van het eindpunt:"));
				Punt eindPunt = new Punt(x2, y2);
				LijnStuk lijn = new LijnStuk(punt, eindPunt);
				tekening.voegToe(lijn);
				JOptionPane.showMessageDialog(null, "U heeft een correct lijnstuk gemaakt: " + lijn, speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);
				break;
				
			case "Driehoek":
				x2 = Integer.parseInt(JOptionPane.showInputDialog("x coordinaat van het tweede punt:"));
				y2 = Integer.parseInt(JOptionPane.showInputDialog("y coordinaat van het tweede punt:"));
				int x3 = Integer.parseInt(JOptionPane.showInputDialog("x coordinaat van het derde punt:"));
				int y3 = Integer.parseInt(JOptionPane.showInputDialog("y coordinaat van het derde punt:"));
				Punt punt2 = new Punt(x2, y2);
				Punt punt3 = new Punt(x3, y3);
				Driehoek driehoek = new Driehoek(punt, punt2, punt3);
				tekening.voegToe(driehoek);
				JOptionPane.showMessageDialog(null, "U heeft een correcte driehoek gemaakt: " + driehoek, speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);
				break;
		}
	}
}
