package domain;

import java.awt.Graphics;

import ui.Drawable;

public abstract class Vorm implements Drawable {

    private boolean zichtbaar = true;

  

	@Override
	public abstract String toString();



    public void setZichtbaar(boolean zichtbaar) {
        this.zichtbaar = zichtbaar;
    }

    public boolean isZichtbaar() {
        return zichtbaar;
    }

}
