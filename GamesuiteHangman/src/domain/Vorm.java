package domain;


public abstract class Vorm  {
	private boolean zichtbaar = true;
	
	public boolean isZichtbaar() {
		return zichtbaar;
	}
	
	public void setZichtbaar(boolean zichtbaar) {
		this.zichtbaar = zichtbaar;
	}

	@Override
	public boolean equals(Object o) {
		if(o instanceof Vorm) {
			Vorm other = (Vorm) o;
			
			return getOmhullende().equals(other.getOmhullende());
		}

		return false;
	}
	
	public abstract Omhullende getOmhullende();

}
