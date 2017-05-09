package domain;

public class Cirkel extends Vorm {
	private int radius;
	private Punt middelpunt;
	
	public Cirkel(Punt middelpunt, int radius) {
		super();
		setMiddelpunt(middelpunt);
		setRadius(radius);
	}
	
	public void setMiddelpunt(Punt middelpunt) {
		if(middelpunt == null) {
			throw new DomainException("Center cannot be null");
		}
		
		this.middelpunt = middelpunt;
	}
	
	public Punt getMiddelpunt() {
		return middelpunt;
	}
	
	public void setRadius(int radius) {
		if(radius <= 0) {
			throw new DomainException("Radius must be bigger than 0");
		}
		
		this.radius = radius;
	}
	
	public int getRadius() {
		return radius;
	}
	
	public Omhullende getOmhullende(){
		int x = middelpunt.getX() - radius;
		int y = middelpunt.getY() + radius;
		
		Punt linksBoven = new Punt(x, y);
		
		return new Omhullende(linksBoven, radius*2, radius*2);
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
