package game;

import java.awt.Toolkit;
import java.util.ArrayList;

import game.Drawable.DrawType;
import game.Drawable.DrawingLayout;
import gui.GameScreen;

public class Level extends ActorCollection{
	Character player;
	
	public Level() {
		super();
		player = new Character(0, 0, -90);
		addCenterActor(player);
		addActor(new InformationWindow());
	}
	
	public void upPressed(){
		player.moveForward();
	}
	
	public void leftPressed(){
		player.moveLeft();
	}
	
	public void rightPressed(){
		player.moveRight();
	}
	
	public void mousePressed(int x, int y){
		Actor actor = new Actor();
		actor.setX(x);
		actor.setY(y);
		//character.followActor(actor);
	}
	
	public void downPressed() {
		player.moveBackward();
	}
	
}
