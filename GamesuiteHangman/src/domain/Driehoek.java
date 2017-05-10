package domain;

public class Driehoek extends Vorm {

	private Punt hoekpunt1, hoekpunt2, hoekpunt3;

	public Driehoek(Punt hoekPunt1, Punt hoekPunt2, Punt hoekPunt3) {
		setHoekPunten(hoekPunt1, hoekPunt2, hoekPunt3);
	}

	private void setHoekPunten(Punt punt1, Punt punt2, Punt punt3) {
		if (punt1 == null || punt2 == null || punt3 == null) {
			throw new DomainException("Hoekpunten mogen niet null zijn");
		}
		else if ((punt2.getX() - punt1.getX()) * (punt3.getY() - punt1.getY()) == (punt3.getX() - punt1.getX())
				* (punt2.getY() - punt1.getY())) {
			throw new DomainException("Hoekpunten mogen niet op 1 lijn liggen");
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
		
		int yKlein = Math.min(Math.min(hoekpunt1.getY(), hoekpunt2.getY()), Math.min(hoekpunt2.getY(), hoekpunt3.getY()));
		int yGroot = Math.max(Math.max(hoekpunt1.getY(), hoekpunt2.getY()), Math.max(hoekpunt2.getY(), hoekpunt3.getY()));
		int xKlein = Math.min(Math.min(hoekpunt1.getX(), hoekpunt2.getX()), Math.min(hoekpunt2.getX(), hoekpunt3.getY()));
		int xGroot = Math.max(Math.max(hoekpunt1.getX(), hoekpunt2.getX()), Math.max(hoekpunt2.getX(), hoekpunt3.getY()));
		Punt linksBoven = new Punt(xKlein,yGroot);
		 
		int breedte = xGroot - xKlein;
		int hoogte = yGroot - yKlein;
		
		return new Omhullende(linksBoven, breedte, hoogte);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Driehoek))
			return false;

		Driehoek driehoek = (Driehoek) obj;
		
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

	@Override
	public String toString() {
		return "Driehoek: hoekpunt1: " + hoekpunt1 + " - hoekpunt2: " + hoekpunt2 + " - hoekpunt3: " + hoekpunt3;
	}

}
