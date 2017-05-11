package domain;

import java.awt.Graphics;

public class Driehoek extends Vorm implements Drawable {
	private Punt hoekpunt1, hoekpunt2, hoekpunt3;

	public Driehoek(Punt hoekPunt1, Punt hoekPunt2, Punt hoekPunt3) {
		setHoekPunten(hoekPunt1, hoekPunt2, hoekPunt3);
	}
	
	public static int min(int a, int b, int c) {
		return Math.min(Math.min(a, b), Math.min(b, c));
	}
	
	public static int max(int a, int b, int c) {
		return Math.max(Math.max(a,  b), Math.max(b, c));
	}

	private void setHoekPunten(Punt punt1, Punt punt2, Punt punt3) {
		if (punt1 == null || punt2 == null || punt3 == null) {
			throw new DomainException("Hoekpunten mogen niet null zijn");
		}
		else {
			int left = (punt2.getX() - punt1.getX()) * (punt3.getY() - punt1.getY());
			int right = (punt3.getX() - punt1.getX()) * (punt2.getY() - punt1.getY());
			
			if(left == right) {
				throw new DomainException("Hoekpunten mogen niet op 1 lijn liggen");
			}
		}
		
		this.hoekpunt1 = punt1;
		this.hoekpunt2 = punt2;
		this.hoekpunt3 = punt3;
	}

	public Punt getHoekPunt1() {
		return hoekpunt1;
	}

	public Punt getHoekPunt2() {
		return hoekpunt2;
	}

	public Punt getHoekPunt3() {
		return hoekpunt3;
	}

	public Omhullende getOmhullende(){
		int yKlein = min(hoekpunt1.getY(), hoekpunt2.getY(), hoekpunt3.getY());
		int yGroot = max(hoekpunt1.getY(), hoekpunt2.getY(), hoekpunt3.getY());
		int xKlein = min(hoekpunt1.getX(), hoekpunt2.getX(), hoekpunt3.getX());
		int xGroot = max(hoekpunt1.getX(), hoekpunt2.getX(), hoekpunt3.getX());
		int breedte = xGroot - xKlein;
		int hoogte = yGroot - yKlein;
		
		return new Omhullende(new Punt(xKlein, yKlein), breedte, hoogte);
	}
	
	public void teken(Graphics g) {
		if(isZichtbaar()) {
			int[] xPoints = { getHoekPunt1().getX(), getHoekPunt2().getX(), getHoekPunt3().getX() };
			int[] yPoints = { getHoekPunt1().getY(), getHoekPunt2().getY(), getHoekPunt3().getY() };
			g.drawPolygon(xPoints, yPoints, 3);
		}
	}

	@Override
	public boolean equals(Object o) {
		if(o instanceof Driehoek) {
			Driehoek driehoek = (Driehoek) o;
			
			return (hoekpunt1.equals(driehoek.getHoekPunt1())
					|| hoekpunt1.equals(driehoek.getHoekPunt2())
					|| hoekpunt1.equals(driehoek.getHoekPunt3())) &&
				   (hoekpunt2.equals(driehoek.getHoekPunt1())
				    || hoekpunt2.equals(driehoek.getHoekPunt2())
				    || hoekpunt2.equals(driehoek.getHoekPunt3())) &&
				   (hoekpunt3.equals(driehoek.getHoekPunt1())
					|| hoekpunt3.equals(driehoek.getHoekPunt2())
					|| hoekpunt3.equals(driehoek.getHoekPunt3()));
		}
		
		return false;
	}

	@Override
	public String toString() {
		return "Driehoek: hoekpunt1: " + hoekpunt1 + " - hoekpunt2: " + hoekpunt2 + " - hoekpunt3: " + hoekpunt3;
	}

}
