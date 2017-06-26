package game;

import java.awt.Color;

public class FillBar extends Actor{
	private int percent;
	
	FillBar(int height, int width){
		super();
		passiveActor();
		setHeight(height);
		setWidth(width);
		percent = 100;
		setColor(Color.RED);
		setDrawType(DrawType.BAR);
	}
	
	public int getPercent(){
		return percent;
	}
	
	public void setPercent(int percent){
		this.percent = percent;
	}
}
