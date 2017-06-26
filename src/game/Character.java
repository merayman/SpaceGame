package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

public class Character extends ActorCollection{
	Actor player;
	
	public Character(int x, int y, int rotateDegrees) {
		super();
		setDrawType(DrawType.COLLECTION);
		setDrawingLayout(DrawingLayout.FRONT);
		
		player = new Actor(){
			public void atStart(){
				setImage(Toolkit.getDefaultToolkit().getImage("Images\\spaceship.gif"));
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
				setText("Player");
				setFont(new Font("TimesRoman", Font.PLAIN, 14));
				setColor(Color.GREEN);
				passiveActor();
				setDrawType(DrawType.TEXT);
				setDrawingLayout(DrawingLayout.MENU);
				setRelativeX(30);
				setRelativeY(120);
			}
			
			public void tick(){
				/*setX(player.getX());
				setY(player.getY());*/
			}
		};
		addActor(text);
		
		FillBar bar = new FillBar(5, 100);
		bar.setRelativeX(0);
		bar.setRelativeY(-10);
		addActor(bar);
	}
	
}
