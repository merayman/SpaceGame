package engine;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JComponent;

import engine.Actor;
import engine.ActorCollection;
import engine.Drawable;
import engine.Rectangle;

public class GameScreen extends JComponent{
	private ActorCollection actorCollection;
	
	public GameScreen(){
		super();
		actorCollection = new ActorCollection();
	}
	
	public void addActor(Actor actor){
		actorCollection.addActor(actor);
	}
	
	public void removeActor(Actor actor){
		actorCollection.removeActor(actor);
	}
	
	public void setActorCollection(ActorCollection actorCollection){
		this.actorCollection = actorCollection;
	}
	
	public void paintGameScreen(int initialX, int initialY,
			Actor centerActor, Graphics2D g2, ActorCollection collection){
		for(Actor actor : collection.getActorCollection()){
			int x, y, height, width;
			double theta;
			x = getWidth()/2-centerActor.getWidth()/2;
			y = getHeight()/2-centerActor.getHeight()/2;
			height = actor.getHeight();
			width = actor.getWidth();
			theta = actor.getTheta();
			
			if(!actor.equals(centerActor)){
				x = centerActor.getX() - x;
				y = centerActor.getY() - y;
				x = (initialX + actor.getX())-x;
				y = (initialY + actor.getY())-y;
			}
			
			g2.setColor(actor.getColor());
			g2.setFont(actor.getFont());
			g2.rotate(theta, x + (double)width/2, y + (double)height/2);
			Drawable.DrawType drawType = actor.getDrawType();
			
			switch(drawType){
			case IMAGE:
				g2.drawImage(actor.getImage(), x, y, this);
				break;
			case TEXT:
				g2.drawString(actor.getText(), x, y);
				break;
			case RECTANGLE:
				g2.fillRect(x, y, (int)((double)actor.getWidth()*((Rectangle)actor).getPercent()/100),
					actor.getHeight());
				break;
			case COLLECTION:
				paintGameScreen(actor.getX() + initialX, actor.getY() + initialY,
					centerActor, g2, (ActorCollection)actor);
				break;
			case EMPTY_PAWN:
				break;
			}
			g2.rotate(-theta, x + (double)width/2, y + (double)height/2);
		}
	}
		
	public void paint(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		paintGameScreen(0, 0, actorCollection.getCenterActor(), g2, actorCollection);
	}
}
