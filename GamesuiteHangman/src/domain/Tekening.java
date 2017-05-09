package domain;

import java.util.ArrayList;

public class Tekening {
	private static final int MIN_X = 0;
	private static final int MIN_Y = 0;
	private static final int MAX_X = 399;
	private static final int MAX_Y = 399;
	private String naam;
	private ArrayList<Vorm> vormen;
	
	public Tekening(String naam) {
		if(naam == null || naam.trim().isEmpty()) {
			throw new IllegalArgumentException("Naam mag niet leeg zijn");
		}
		
		this.naam = naam;
		this.vormen = new ArrayList<Vorm>();
	}
	
	public String getNaam() {
		return naam;
	}
	
	public void voegToe(Vorm vorm) {
		if(vorm == null) {
			throw new DomainException("Vorm mag niet null zijn");
		}
		if(bevat(vorm)) {
			throw new DomainException("Tekening bevat vorm al");
		}
		if(vorm.getOmhullende().getMinimumX()<MIN_X || vorm.getOmhullende().getMaximumX()>MAX_X || vorm.getOmhullende().getMinimumY()<MIN_Y||vorm.getOmhullende().getMaximumY()>MAX_Y)
		{
			throw new IllegalArgumentException("Vorm past niet op de tekening!");
		}
		
		vormen.add(vorm);
	}
	
	public Vorm getVorm(int index) {
		return vormen.get(index);
	}
	
	public int getAantalVormen() {
		return vormen.size();
	}
	
	public void verwijder(Vorm vorm) {
		vormen.remove(vorm);
	}
	
	public boolean bevat(Vorm vorm) {
		return vormen.contains(vorm);
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Tekening) {
			Tekening other = (Tekening) o;
			
			if(other.getAantalVormen() != getAantalVormen()) {
				return false;
			}
			
			for(Vorm vorm : vormen) {
				if(!other.bevat(vorm)) {
					return false;
				}
			}
			
			return true;
		}
		
		return false;
	}
	
	@Override
	public String toString() {
		String res = "Tekening met naam " + naam + " bestaat uit " + getAantalVormen() + " vormen:";
		
		for(Vorm vorm : vormen) {
			res += "\n" + vorm.toString();
		}
		
		return res;
	}

}
