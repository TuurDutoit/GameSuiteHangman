package domain;

import java.awt.Graphics;


public abstract class Vorm  {

   
  

	@Override
	public abstract String toString();


	@Override
	public boolean equals(Object o){
		if(o!=null){
			if(o instanceof Vorm){
				return true;
			}
		}
		return false;
	}

}
