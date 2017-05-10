package domain;

import java.awt.Graphics;


public abstract class Vorm  {

	@Override
	public boolean equals(Object o) {
		if(o instanceof Vorm) {
			return true;
		}

		return false;
	}
	
	public abstract Omhullende getOmhullende();

}
