package game;

import java.awt.Color;

import engine.Actor;
import engine.ActorCollection;
import engine.Rectangle;

public class InformationWindow extends ActorCollection{
	InformationWindow(){
		super();
		setDrawingLayout(DrawingLayout.MENU);
		Rectangle back = new Rectangle(300, 300){
			public void tick(){
				
			}
		};
		back.setPercent(100);
		back.setColor(new Color(255, 255, 255, 70));
		back.setDrawingLayout(DrawingLayout.BACKGROUND);
		back.setX(100);
		back.setY(100);
		
		Actor text = new Actor();
		text.setText("INFO");
		text.setColor(Color.BLACK);
		text.setDrawType(DrawType.TEXT);
		text.setX(50);
		text.setY(50);
		text.setDrawingLayout(DrawingLayout.MENU);
		
		addCenterActor(back);
		addActor(text);
	}
}
