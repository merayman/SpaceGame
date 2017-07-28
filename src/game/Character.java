package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import engine.Actor;
import engine.ActorCollection;
import engine.Level;
import engine.Rectangle;

public class Character extends ActorCollection{
	private Level level;
	private SpaceShip spaceship;
	private Actor text;
	private LifeBar lifeBar;
	private int pixelsPerFrame;
	private int minX, minY, maxX, maxY;
	private int maxLife;
	private int life;
	private int hitPoints;
	
	public Character(Level level, Color textColor,
			String str, int x, int y, int rotateDegrees) {
		super();
		this.level = level;
		setX(x);
		setY(y);
		setHeight(140);
		setWidth(100);
		setRotateDegrees(0);
		
		pixelsPerFrame = 5;
		minX = 0;
		minY = 0;
		maxX = 1000;
		maxY = 1000;
		maxLife = 100;
		life = 100;
		hitPoints = 5;
		
		spaceship = new SpaceShip();
		lifeBar = new LifeBar();
		
		spaceship.setRotateDegrees(rotateDegrees);
		
		text =  new Actor();
		text.setDrawType(DrawType.TEXT);
		text.setText(str);
		text.setX(30);
		text.setY(125);
		text.setFont(new Font("TimesRoman", Font.PLAIN, 14));
		text.setColor(textColor);
		addCenterActor(spaceship);
		addActor(text);
		addActor(lifeBar);
	}

	public int getMaxLife(){ return maxLife; }
	public int getLife(){ return life; }
	public int getHitPoints(){ return hitPoints; }
	private int getPercent(){ return 100*life/maxLife; }
	public int getSpeed() { return pixelsPerFrame; };
	public Level getLevel() { return level; };
	
	public void setHitPoints(int hitPoints){ this.hitPoints = hitPoints; }
	public void setMaxLife(int maxLife){ this.maxLife = maxLife; }
	public void setSpeed(int pixelsPerFrame){ this.pixelsPerFrame = pixelsPerFrame; }
	
	public void setLife(int life){
		this.life = life;
		if(life==0)
			destroyActor();
	}
	
	public void setBoundry(int minX, int minY, int maxX, int maxY){
		this.minX = minX;
		this.minY = minY;
		this.maxX = maxX;
		this.maxY = maxY;
	}
	
	public void moveForward(){
		double displacementX;
		displacementX = pixelsPerFrame*Math.sin(Math.toRadians(spaceship.getRotateDegrees()));
		if(getX() + displacementX < maxX && getX() + displacementX > minX)
			setX(getX() + (int)displacementX);
		double displacementY;
		displacementY = pixelsPerFrame*Math.cos(Math.toRadians(spaceship.getRotateDegrees()));
		if(getY() - displacementY < maxY && getY() - displacementY > minY)
			setY(getY() - (int)displacementY);
	}
	
	public void rotateLeft(){
		spaceship.setRotateDegrees(spaceship.getRotateDegrees()-2);
	}
	
	public void rotateRight(){
		spaceship.setRotateDegrees(spaceship.getRotateDegrees()+2);
	}
	
	public void attack(){
		level.addActor(new Bullet(level, this));
	}
	
	public void focus(int x, int y){
		double vectorX = (x-getX()-(double)getWidth()/2);
		double vectorY = (y-getY()-(double)getHeight()/2);
		double division = vectorX/vectorY;
		spaceship.setRotateDegrees((int) -Math.toDegrees(Math.atan(division)));
		if(vectorY>0)
			spaceship.setRotateDegrees(getRotateDegrees()-180);
	}
	
	public void hit(int hitPoints){
		if(life-hitPoints>=0)
			life -= hitPoints;
		else
			life = 0;
		lifeBar.setPercent(getPercent());
		if(life==0)
			destroyActor();
	}
	
	public void heal(int healPoints){
		if(life+healPoints<=maxLife)
			life += healPoints;
		lifeBar.setPercent(getPercent());
	}
}