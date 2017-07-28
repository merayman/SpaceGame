package game;

import java.awt.Toolkit;

import engine.Actor;
import engine.Level;

public class Entrance extends Level{
	
	public Entrance(){
		Actor img = new Actor();
		img.setImage(Toolkit.getDefaultToolkit().getImage("Images\\introPic.png"));
		img.setDrawType(DrawType.IMAGE);
		img.setWidth(733);
		img.setHeight(294);
		addCenterActor(img);
		setNextLevel(new SpaceLevel());
	}
	
	@Override
	public void upPressed() {
		finishLevel();
	}

	@Override
	public void leftPressed() {
		finishLevel();
	}

	@Override
	public void rightPressed() {
		// TODO Auto-generated method stub
		finishLevel();
	}

	@Override
	public void mousePressed(MouseCode code, int x, int y) {
		// TODO Auto-generated method stub
		finishLevel();
	}

	@Override
	public void downPressed() {
		finishLevel();
	}

	@Override
	public void spacePressed() {
		finishLevel();
	}

	@Override
	public void enterPressed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void escapePressed() {
		// TODO Auto-generated method stub
		
	}

}
