package game;

import java.awt.Color;

import engine.Level;

public class Player extends Character{
	private int startX, startY, startRotateDegrees;
	
	public Player(Level level, int x, int y, int rotateDegrees) {
		super(level, Color.GREEN, "Player", x, y, rotateDegrees);
		setDrawingLayout(DrawingLayout.FRONT);
		startX = x;
		startY = y;
		startRotateDegrees = rotateDegrees;
		setSpeed(7);
		setBoundry(0, 0, Background.WIDTH - getWidth(), Background.HEIGHT - getHeight());
	}
	
	public void destroyActor(){
		setX(startX);
		setY(startY);
		setLife(getMaxLife()/2);
		setRotateDegrees(startRotateDegrees);
	}
}
