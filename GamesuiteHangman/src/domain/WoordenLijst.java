package domain;

import java.util.ArrayList;

public class WoordenLijst {
	private ArrayList<String> woordenLijst = new ArrayList<>();

	public WoordenLijst() {

	}

	public int getAantalWoorden() {
		return this.woordenLijst.size();
	}

	public void voegToe(String woord) {
		if (woordenLijst.contains(woord)) {
			throw new DomainException("Het woord staat al in de lijst!");
		}
		if (woord == null || woord.trim().isEmpty()) {
			throw new DomainException("Woord is leeg");
		}
		
		this.woordenLijst.add(woord);
	}

	public String getRandomWoord() {
		int random = (int) (Math.random() * (this.woordenLijst.size() - 1));

		if (woordenLijst.size() == 0) {
			return null;
		}
		
		return woordenLijst.get(random);
	}

}