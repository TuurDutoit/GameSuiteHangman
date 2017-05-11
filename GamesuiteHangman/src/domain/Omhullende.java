package domain;

public class Omhullende {
	private int breedte;
	private int hoogte;
	private Punt linkerBovenhoek;
	
	public Omhullende(Punt linksBoven, int breedte, int hoogte){
		if(breedte < 0){
			throw new DomainException("breedte mag niet negatief zijn!");
		}
		if(hoogte < 0){
			throw new DomainException("hoogte mag niet negatief zijn!");
		}
		if(linksBoven == null){
			throw new DomainException("geen geldige linkerbovenhoek");
		}
		
		this.breedte = breedte;
		this.hoogte = hoogte;
		this.linkerBovenhoek = linksBoven;
	}
	
	public Punt getLinkerBovenhoek(){
		return this.linkerBovenhoek;
	}
	
	public int getHoogte(){
		return this.hoogte;
	}
	
	public int getBreedte(){
		return this.breedte;
	}
	
	public int getMinimumX(){
		return this.linkerBovenhoek.getX();
	}
	
	public int getMinimumY(){
		return this.linkerBovenhoek.getY();
	}
	
	public int getMaximumX(){
		return this.linkerBovenhoek.getX() + this.breedte;
	}
	
	public int getMaximumY(){
		return this.linkerBovenhoek.getY() + this.hoogte;
	}
	
	@Override
	public boolean equals(Object o){
		if(o instanceof Omhullende){
			Omhullende other = (Omhullende) o;
			
			if(linkerBovenhoek.equals(other.getLinkerBovenhoek()) && other.getBreedte() == breedte && other.getHoogte() == hoogte){
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public String toString(){
		return "Omhullende: " + linkerBovenhoek.toString() + " - " + breedte + " - " + hoogte;
	}
}
