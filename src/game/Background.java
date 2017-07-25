package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import engine.Actor;
import engine.ActorCollection;

public class Background extends ActorCollection{

	public Background() {
		super();
		addActor(new Actor(){
			public void atStart(){
				setDrawType(DrawType.IMAGE);
				setDrawingLayout(DrawingLayout.BACKGROUND);
				setWidth(3840);
				setHeight(2160);
				setImage(Toolkit.getDefaultToolkit().getImage("Images\\background.png"));
			}
		});
		addActor(new Actor(){
			public void atStart(){
				setDrawType(DrawType.TEXT);
				setDrawingLayout(DrawingLayout.BACKGROUND);
				setX(500);
				setY(500);
				setFont(new Font("TimesRoman", Font.BOLD, 20));
				setColor(Color.WHITE);
				setText("STATION");
				//setImage(Toolkit.getDefaultToolkit().getImage("Images\\background.png"));
			}
		});
	}
	
}
