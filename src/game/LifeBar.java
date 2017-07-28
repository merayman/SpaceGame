package game;

import java.awt.Color;

import engine.Rectangle;

public class LifeBar extends Rectangle{

	public LifeBar() {
		super(5, 100);
		setX(0);
		setY(0);
		setColor(Color.GREEN);
	}
	
	public void setPercent(int percent){
		super.setPercent(percent);
		if(percent>65){
			setColor(Color.GREEN);
		}
		else if(percent>55){
			setColor(Color.YELLOW);
		}
		else if(percent>35){
			setColor(Color.ORANGE);
		}
		else{
			setColor(Color.RED);
		}
	}

}
