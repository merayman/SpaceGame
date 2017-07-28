package game;

import java.awt.Color;
import java.awt.Toolkit;

import engine.Actor;
import engine.Drawable.DrawingLayout;
import engine.Level;
import engine.Rectangle;

public class Bullet extends Rectangle{
	private Character character;
	private Level level;
	private int pixelsPerFrame;
	
	Bullet(Level level, Character character){
		super(20, 4);
		this.character = character;
		this.level = level;
		pixelsPerFrame = 15;
		setDrawingLayout(DrawingLayout.BACKGROUND);
		setColor(Color.RED);
		setRotateDegrees(character.getCenterActor().getRotateDegrees());
		setX(character.getX()+character.getWidth()/2-getWidth()/2);
		setY(character.getY()+character.getHeight()/2-getHeight()/2);
	}
	
	private void moveForward(){
		double displacementX;
		displacementX = pixelsPerFrame*Math.sin(Math.toRadians(getRotateDegrees()));
		setX(getX() + (int)displacementX);
		double displacementY;
		displacementY = pixelsPerFrame*Math.cos(Math.toRadians(getRotateDegrees()));
		setY(getY() - (int)displacementY);
	}
	
	public void tick(){
		super.tick();
		moveForward();
		for(Actor actor : this.getOverlappingActors(level)){
			if(!actor.equals(character) && actor instanceof Character){
				if(!(character instanceof Enemy && actor instanceof Enemy)){
					((Character)actor).hit(character.getHitPoints());
					destroyActor();
				}
			}
		}
		if(getX()<0 || getX()>Background.WIDTH || getY()<0 || getY()>Background.HEIGHT)
			destroyActor();
	}
}
