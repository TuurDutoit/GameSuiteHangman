package domain;

public class Rechthoek extends Vorm {
	private Punt linkerBovenhoek;
	private int breedte;
	private int hoogte;
	
	public Rechthoek(Punt linkerbovenhoek, int breedte, int hoogte) throws DomainException
	{
		super();
		setBreedte(breedte);
		setHoogte(hoogte);
		setLinkerBovenhoek(linkerbovenhoek);
		
	}
	
	public Punt getLinkerBovenhoek()
	{
		return this.linkerBovenhoek;
		
	}
	public void setLinkerBovenhoek(Punt hoek)
	{
		if(hoek == null)
		{
			throw new DomainException("Linkerbovenhoek mag niet null zijn");
		}
		else
		{
			this.linkerBovenhoek=hoek;
		}
	}
	
	public int getBreedte() {
		return this.breedte;
	}
	public void setBreedte(int breedte) throws DomainException {
		if(breedte<=0)
		{
			throw new DomainException("breedte moet groter als 0 zijn");
		}
		this.breedte = breedte;
	}
	public int getHoogte() {
		return this.hoogte;
	}
	public void setHoogte(int hoogte) throws DomainException {
		if(hoogte<=0)
		{
			throw new DomainException("hoogte moet groter als 0 zijn");
		}
		this.hoogte = hoogte;
	}
	
	public Omhullende getOmhullende(){
		return new Omhullende(linkerBovenhoek, breedte, hoogte);
	}
	@Override
	public boolean equals(Object object){
		boolean resultaat = false;
		if(object instanceof Rechthoek)
		{
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
	public String toString()
	{
		return "Rechthoek: positie: " + getLinkerBovenhoek() + " - breedte: "+getBreedte()+" - hoogte: "+getHoogte(); 
	}

}
