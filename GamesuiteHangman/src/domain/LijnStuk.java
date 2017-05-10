package domain;

public class LijnStuk extends Vorm {
		
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
	
	public Omhullende getOmhullende(){
		Punt linksBoven = new Punt(Math.min(startPunt.getX(), eindPunt.getX()), Math.max(startPunt.getY(), eindPunt.getY()));
		int breedte = Math.max(startPunt.getX(), eindPunt.getX()) - Math.min(startPunt.getX(), eindPunt.getX());
		int hoogte = Math.max(startPunt.getY(), eindPunt.getY()) - Math.min(startPunt.getY(), eindPunt.getY());
		
		return new Omhullende(linksBoven, breedte, hoogte);
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

