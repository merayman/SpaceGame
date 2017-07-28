package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import engine.Actor;
import engine.ActorCollection;

public class Background extends Actor{
	public static final int WIDTH = 6000;
	public static final int HEIGHT = 4000;
	
	public Background() {
		setDrawType(DrawType.IMAGE);
		setDrawingLayout(DrawingLayout.BACKGROUND);
		setWidth(WIDTH);
		setHeight(HEIGHT);
		Image img = Toolkit.getDefaultToolkit().getImage("Images\\background.png");
		img = img.getScaledInstance(6000, 4000, Image.SCALE_REPLICATE);
		setImage(img);
	}
	
}
