package game;

import java.awt.Color;
import java.awt.Font;

import engine.Actor;
import engine.Level;

public class End extends Level{
	
	End(){
		super();
		Actor text = new Actor();
		text.setColor(Color.WHITE);
		text.setFont(new Font("TimesRoman", Font.BOLD, 50));
		text.setDrawType(DrawType.TEXT);
		text.setText("END");
		text.setHeight(50);
		text.setWidth(60);
		addCenterActor(text);
	}

	@Override
	public void upPressed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void downPressed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void leftPressed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rightPressed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void spacePressed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterPressed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void escapePressed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseCode code, int x, int y) {
		// TODO Auto-generated method stub
		
	}

}
