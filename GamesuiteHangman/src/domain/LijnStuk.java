package domain;

public class LijnStuk extends Vorm {
		
	private Punt startPunt;
	private Punt eindPunt;
	
	
	public LijnStuk(Punt startPunt, Punt eindPunt){
		super();
		this.setStartPunt(startPunt);
		this.setEindPunt(eindPunt);
	}


	public Punt getStartPunt() {
		return startPunt;
	}


	private void setStartPunt(Punt startPunt) {
		if(startPunt == null){
			throw new DomainException("Startpunt mag niet null zijn");
		}
		this.startPunt = startPunt;
	}


	public Punt getEindPunt() {
		return eindPunt;
	}

	private void setEindPunt(Punt eindPunt) {
		if(eindPunt == null){
			throw new DomainException("Eindpunt mag niet null zijn");
		}
		this.eindPunt = eindPunt;
	}
	
	public Omhullende getOmhullende(){
		Punt linksBoven = new Punt(Math.min(startPunt.getX(), eindPunt.getX()), Math.max(startPunt.getY(), eindPunt.getY()));
		int breedte = Math.max(startPunt.getX(), eindPunt.getX()) - Math.min(startPunt.getX(), eindPunt.getX());
		int hoogte = Math.max(startPunt.getY(), eindPunt.getY()) - Math.min(startPunt.getY(), eindPunt.getY());
		
		return new Omhullende(linksBoven, breedte, hoogte);
	}
	
	@Override
	public boolean equals(Object o){
		if(o != null){
			if(o instanceof LijnStuk){
				LijnStuk l = (LijnStuk) o;
				return this.getStartPunt().equals(l.getStartPunt()) && this.getEindPunt().equals(l.getEindPunt());
			}
		}
		return false;
	}
	
	@Override
	public String toString(){
		return "Punt X:" + this.getStartPunt().toString() + "Punt Y:" + this.getEindPunt().toString();
	}
}

