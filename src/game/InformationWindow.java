package game;

import java.awt.Color;

public class InformationWindow extends ActorCollection{
	InformationWindow(){
		super();
		setDrawingLayout(DrawingLayout.MENU);
		FillBar back = new FillBar(300, 300);
		back.setPercent(100);
		back.setColor(new Color(255, 255, 255, 70));
		back.setDrawingLayout(DrawingLayout.BACKGROUND);
		back.setX(100);
		back.setY(100);
		
		Actor text = new Actor();
		text.setText("INFO");
		text.setColor(Color.BLACK);
		text.setDrawType(DrawType.TEXT);
		text.setRelativeX(50);
		text.setRelativeY(50);
		text.setDrawingLayout(DrawingLayout.MENU);
		text.passiveActor();
		
		addCenterActor(back);
		addActor(text);
	}
}
