package game;

import java.awt.Image;
import java.awt.Toolkit;

import engine.Actor;
import engine.Drawable.DrawType;

public class SpaceShip extends Actor{
	
	SpaceShip(){
		super();
		setDrawType(DrawType.IMAGE);
		Image img = Toolkit.getDefaultToolkit().getImage("Images\\spaceship.png");
		img = img.getScaledInstance(100, 100, img.SCALE_DEFAULT);
		setImage(img);
		setHeight(100);
		setWidth(100);
		setX(0);
		setY(10);
	}
}
