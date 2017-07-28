package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import engine.Actor;
import engine.ActorCollection;

public class Character extends ActorCollection{
	Actor player;
	Rectangle bar;
	
	public Character(int x, int y, int rotateDegrees) {
		super();
		setDrawType(DrawType.COLLECTION);
		setDrawingLayout(DrawingLayout.FRONT);
		
		player = new Actor(){
			public void atStart(){
				super.atStart();
				setImage(Toolkit.getDefaultToolkit().getImage("Images\\spaceship.gif"));
				activeActor();
				setX(x);
				setY(y);
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
				passiveActor();
				setDrawType(DrawType.TEXT);
				setDrawingLayout(DrawingLayout.MENU);
				setRelativeX(30);
				setRelativeY(120);
			}
		};
		
		addActor(text);
		
		bar = new Rectangle(5, 100);
		bar.setColor(Color.GREEN);
		bar.setRelativeX(0);
		bar.setRelativeY(-10);
		addActor(bar);
	}
	
	public void hit(int hitPoint){
		bar.setPercent(bar.getPercent()-hitPoint);
		if(bar.getPercent()<0)
			destroyActor();
	}
	
}
