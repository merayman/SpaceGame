package engine;

import java.awt.Color;

import engine.Actor;

public class Rectangle extends Actor{
	private int percent;
	
	public Rectangle(int height, int width){
		super();
		setHeight(height);
		setWidth(width);
		percent = 100;
		setColor(Color.BLACK);
		setDrawType(DrawType.RECTANGLE);
	}
	
	public int getPercent(){
		return percent;
	}
	
	public void setPercent(int percent){
		this.percent = percent;
	}
}
