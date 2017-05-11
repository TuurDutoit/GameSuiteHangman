package domain;

import java.awt.Graphics;

public class LijnStuk extends Vorm implements Drawable {
	private Punt startPunt;
	private Punt eindPunt;
	
	
	public LijnStuk(Punt startPunt, Punt eindPunt){
		super();
		this.setStartEnEindPunt(startPunt, eindPunt);
	}

	public Punt getStartPunt() {
		return startPunt;
	}

	public Punt getEindPunt() {
		return eindPunt;
	}
	
	public void setStartEnEindPunt(Punt start, Punt eind) {
		if(start == null) {
			throw new DomainException("Startpunt mag niet null zijn");
		}
		if(eind == null) {
			throw new DomainException("Eindpunt mag niet null zijn");
		}
		if(start.equals(eind)) {
			throw new DomainException("Start- en eindpunt mogen niet gelijk zijn");
		}
		
		startPunt = start;
		eindPunt = eind;
	}
	
	public Omhullende getOmhullende() {
		int minX = Math.min(startPunt.getX(), eindPunt.getX());
		int minY = Math.min(startPunt.getY(), eindPunt.getY());
		int maxX = Math.max(startPunt.getX(), eindPunt.getX());
		int maxY = Math.max(startPunt.getY(), eindPunt.getY());
		
		Punt linksBoven = new Punt(minX, minY);
		int breedte = maxX - minX;
		int hoogte = maxY - minY;
		
		return new Omhullende(linksBoven, breedte, hoogte);
	}
	
	public void teken(Graphics g) {
		if(isZichtbaar()) {
			g.drawLine(getStartPunt().getX(), getStartPunt().getY(), getEindPunt().getX(), getEindPunt().getY());
	
		}
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof LijnStuk) {
			LijnStuk l = (LijnStuk) o;
			return (this.getStartPunt().equals(l.getStartPunt()) && this.getEindPunt().equals(l.getEindPunt())) ||
				   (this.getStartPunt().equals(l.getEindPunt()) && this.getEindPunt().equals(l.getStartPunt()));
		}
		
		return false;
	}
	
	@Override
	public String toString(){
		return "Lijn: startpunt: " + this.getStartPunt().toString() + " - eindpunt: " + this.getEindPunt().toString();
	}
}

