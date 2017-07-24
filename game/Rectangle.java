package game;

import java.awt.Color;

import engine.Actor;

public class Rectangle extends Actor{
	private int percent;
	
	Rectangle(int height, int width){
		super();
		passiveActor();
		setHeight(height);
		setWidth(width);
		percent = 100;
		setColor(Color.RED);
		setDrawType(DrawType.RECTANGLE);
	}
	
	public int getPercent(){
		return percent;
	}
	
	public void setPercent(int percent){
		this.percent = percent;
	}
	
	public void tick(){
		super.tick();
		
	}
}
