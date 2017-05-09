package domain;

public class Lijnstuk {
		
	private Punt startPunt;
	private Punt eindPunt;
	
	
	public Lijnstuk(Punt startPunt, Punt eindPunt){
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
	
	@Override
	public boolean equals(Object o){
		if(o != null){
			if(o instanceof Lijnstuk){
				Lijnstuk l = (Lijnstuk) o;
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