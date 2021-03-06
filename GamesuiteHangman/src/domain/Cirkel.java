package domain;

import java.awt.Graphics;

public class Cirkel extends Vorm implements Drawable {
	private int radius;
	private Punt middelpunt;
	
	public Cirkel(Punt middelpunt, int radius) {
		super();
		setMiddelpunt(middelpunt);
		setRadius(radius);
	}
	
	public void setMiddelpunt(Punt middelpunt) {
		if(middelpunt == null) {
			throw new DomainException("Middelpunt mag niet null zijn");
		}
		
		this.middelpunt = middelpunt;
	}
	
	public Punt getMiddelpunt() {
		return middelpunt;
	}
	
	public void setRadius(int radius) {
		if(radius <= 0) {
			throw new DomainException("Straal moet strict positief zijn");
		}
		
		this.radius = radius;
	}
	
	public int getRadius() {
		return radius;
	}
	
	public Omhullende getOmhullende(){
		int x = middelpunt.getX() - radius;
		int y = middelpunt.getY() - radius;
		
		Punt linksBoven = new Punt(x, y);
		
		return new Omhullende(linksBoven, radius*2, radius*2);
	}
	
	public void teken(Graphics g) {
		if(isZichtbaar()) {
			Omhullende omhullende = getOmhullende();
			g.drawOval(omhullende.getMinimumX(),
					   omhullende.getMinimumY(),
					   omhullende.getBreedte(),
					   omhullende.getHoogte());
		}
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Cirkel) {
			Cirkel other = (Cirkel) o;
			
			return other.getMiddelpunt().equals(middelpunt) && other.getRadius() == radius;
		}
		
		return false;
	}
	
	@Override
	public String toString() {
		return "Cirkel: middelpunt: " + middelpunt.toString() + " - straal: " + radius;
	}
}
