package game;

import java.awt.Color;
import java.awt.Image;

public interface Drawable {
	public enum DrawType{
		IMAGE,
		TEXT,
		FILLOVAL
	}
	public enum DrawingLayout{
		BACKGROUND,
		BACK,
		MIDDLE,
		FRONT,
		MENU
	}
	public abstract int getHeight();
	public abstract int getWidth();
	public abstract int getX();
	public abstract int getY();
	public abstract double getTheta();
	public abstract Image getImage();
	public abstract String getString();
	public abstract Color getColor();
	public abstract DrawType getDrawType();
	public abstract DrawingLayout getDrawingLayout();
	public abstract boolean isRenderedAtSight();
}
