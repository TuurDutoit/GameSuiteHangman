package domain;

public class Punt {
	private int x, y;
	
	public Punt(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	@Override
	public boolean equals(Object o){
		boolean res = false;
		
		if(o instanceof Punt){
			Punt newO = (Punt) o;
			if(newO.getX() == this.x && newO.getY() == this.y){
				res = true;
			}
		}
		
		return res;
	}
	
	@Override
	public String toString(){
		return "(" + this.x + ", " + this.y + ")";
	}
	
	

}
