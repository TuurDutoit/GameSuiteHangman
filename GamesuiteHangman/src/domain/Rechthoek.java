package domain;

import java.awt.Graphics;

public class Rechthoek extends Vorm implements Drawable {
	private Punt linkerBovenhoek;
	private int breedte;
	private int hoogte;
	
	public Rechthoek(Punt linkerbovenhoek, int breedte, int hoogte) {
		super();
		setBreedte(breedte);
		setHoogte(hoogte);
		setLinkerBovenhoek(linkerbovenhoek);
	}
	
	public Punt getLinkerBovenhoek() {
		return this.linkerBovenhoek;
		
	}
	
	public void setLinkerBovenhoek(Punt hoek) {
		if(hoek == null) {
			throw new DomainException("Linkerbovenhoek mag niet null zijn");
		}
		
		this.linkerBovenhoek = hoek;
	}
	
	public int getBreedte() {
		return this.breedte;
	}
	
	public void setBreedte(int breedte) {
		if(breedte <= 0) {
			throw new DomainException("breedte moet groter dan 0 zijn");
		}
		
		this.breedte = breedte;
	}
	
	public int getHoogte() {
		return this.hoogte;
	}
	
	public void setHoogte(int hoogte) {
		if(hoogte <= 0) {
			throw new DomainException("Hoogte moet groter dan 0 zijn");
		}
		
		this.hoogte = hoogte;
	}
	
	public Omhullende getOmhullende() {
		return new Omhullende(linkerBovenhoek, breedte, hoogte);
	}
	
	public void teken(Graphics g) {
		if(isZichtbaar()) {
			g.drawRect(getLinkerBovenhoek().getX(), getLinkerBovenhoek().getY(), breedte, hoogte);
		}
	}
	
	@Override
	public boolean equals(Object object) {
		boolean resultaat = false;
		
		if(object instanceof Rechthoek) {
			Rechthoek gelijk = (Rechthoek) object;
			
			if(this.getBreedte() == gelijk.getBreedte() && this.getHoogte()==gelijk.getHoogte() &&
					this.getLinkerBovenhoek().equals(gelijk.getLinkerBovenhoek()))
			{
				resultaat = true;
			}
			
		}
		
		return resultaat;
	}
	
	@Override
	public String toString() {
		return "Rechthoek: positie: " + linkerBovenhoek + " - breedte: " + breedte + " - hoogte: " + hoogte + "\n" + getOmhullende(); 
	}

}
