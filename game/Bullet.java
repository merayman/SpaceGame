package game;

import java.awt.Toolkit;

import engine.Actor;

public class Bullet extends Actor{
	Character character;
	
	Bullet(Character character, int x, int y, int rotateDegrees){
		this.character = character;
		setDrawType(DrawType.IMAGE);
		setImage(Toolkit.getDefaultToolkit().getImage("Images\\bullet.png"));
		setRotateDegrees(rotateDegrees);
		setSpeed(15);
		setX(x);
		setY(y);
		setHeight(20);
		setWidth(20);
	}
	
	public Character getCharacter(){
		return character;
	}
	
	public void tick(){
		super.tick();
		moveForward();
	}
}
