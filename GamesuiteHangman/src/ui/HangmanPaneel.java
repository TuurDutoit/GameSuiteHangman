package ui;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import domain.HangMan;

public class HangmanPaneel extends JPanel {
	private static final long serialVersionUID = 1L;
	private static final String[] keuzes = {"Ja", "Nee"};
	
	private JTextField letter;	
	private JLabel woord;
	private TekenVenster tekenVenster;
	private HangMan spel;
	
	public HangmanPaneel(HangMan spel){
		super();
		setSpel(spel);
		init();
	}

	private void init(){
		letter = new JTextField("",5);
		woord = new JLabel("");
		
		this.setLayout(new BorderLayout());
		this.add(letter, BorderLayout.EAST);
		this.add(woord, BorderLayout.CENTER);
		
		letter.addKeyListener(new RaadLuisteraar());
	}
	
	private void reset() {
		woord.setText(getSpel().getHint());
		getTekenVenster().teken();
	}
	
	public class RaadLuisteraar implements KeyListener {

		@Override
		public void keyPressed(KeyEvent arg0) {
			if(arg0.getKeyCode() == KeyEvent.VK_ENTER){
				String input = letter.getText();
				char guess = '\u0000';
				
				if(input.length() > 0){
					guess = input.charAt(0);
				}

				spel.raad(guess);
				woord.setText(getSpel().getHint());
				letter.setText("");
				getTekenVenster().teken();
				
				if(spel.isGameOver()) {
					gedaan("U heeft verloren...", "VERLOREN");
				}
				else if(spel.isGewonnen()) {
					gedaan("U heeft gewonnen!", "GEWONNEN!");
				}
			}
		}

		@Override
		public void keyReleased(KeyEvent arg0) {/* Niet nodig*/}
		@Override
		public void keyTyped(KeyEvent arg0) {/* Niet nodig*/}
	}
	
	private void gedaan(String message, String title) {
		message += "\n\nWilt u opnieuw spelen?";
		String keuze = (String) JOptionPane.showInputDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE, null, keuzes, null);
		
		if(keuze.equals("Ja")) {
			spel.reset();
			reset();
		}
		else {
			System.exit(0);
		}
	}
	
	private void setSpel(HangMan spel){
		this.spel = spel;
	}

	private HangMan getSpel() {
		return spel;
	}
	

	private TekenVenster getTekenVenster() {
		return tekenVenster;
	}

	 public void setTekenVenster(TekenVenster tekenVenster) {
		this.tekenVenster = tekenVenster;

		reset();
	}
}