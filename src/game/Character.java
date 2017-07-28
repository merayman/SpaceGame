package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import engine.Actor;
import engine.ActorCollection;
import engine.Rectangle;

public class Character extends ActorCollection{
	Actor player;
	Rectangle bar;
	
	public Character(int x, int y, int rotateDegrees) {
		super();
		setDrawType(DrawType.COLLECTION);
		setDrawingLayout(DrawingLayout.FRONT);
		setX(300);
		setY(300);
		
		player = new Actor(){
			public void atStart(){
				super.atStart();
				setImage(Toolkit.getDefaultToolkit().getImage("Images\\spaceship.gif"));
				setX(0);
				setY(0);
				setRotateDegrees(rotateDegrees);
				setDrawType(DrawType.IMAGE);
				setDrawingLayout(DrawingLayout.FRONT);
				setHeight(103);
				setWidth(100);
			}
		};
		
		addCenterActor(player);
		
		Actor text = new Actor(){
			public void atStart(){
				super.atStart();
				setText("Player");
				setFont(new Font("TimesRoman", Font.PLAIN, 14));
				setColor(Color.GREEN);
				setDrawType(DrawType.TEXT);
				setDrawingLayout(DrawingLayout.MENU);
				setX(10);
				setY(100);
			}
		};
		
		addActor(text);
		
		bar = new Rectangle(5, 100);
		bar.setColor(Color.GREEN);
		bar.setX(0);
		bar.setY(-10);
		addActor(bar);
	}
	
	public void hit(int hitPoint){
		bar.setPercent(bar.getPercent()-hitPoint);
		if(bar.getPercent()<0)
			destroyActor();
	}
	
}
