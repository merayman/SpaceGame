package game;

import java.awt.Image;
import java.awt.Toolkit;

import engine.Actor;
import engine.Drawable.DrawType;
import engine.Drawable.DrawingLayout;
import engine.Level;

public class Station extends Actor{
	private Level level;
	private int count;
	private int healTime;
	
	Station(Level level){
		super();
		this.level = level;
		count = 0;
		setDrawType(DrawType.IMAGE);
		setDrawingLayout(DrawingLayout.BACKGROUND);
		setWidth(1000);
		setHeight(837);
		healTime = 223;
		Image img = Toolkit.getDefaultToolkit().getImage("Images\\station.png");
		setImage(img);
	}
	
	public void tick(){
		super.tick();
		if(count==Integer.MAX_VALUE)
			count = 0;
		else
			count++;
		if(count%healTime==0 && isOverlapping(level.getCenterActor()))
			((Character)level.getCenterActor()).heal(5);
	}
}
