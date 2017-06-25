package gui;

import game.Drawable;
import game.GameObject;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JComponent;

public class GameScreen extends JComponent{
	private ArrayList<Drawable> backgroundComponents;
	private ArrayList<Drawable> backComponents;
	private ArrayList<Drawable> middleComponents;
	private ArrayList<Drawable> frontComponents;
	private ArrayList<Drawable> menuComponents;
	private Drawable centerObject;
	
	GameScreen(){
		super();
		backgroundComponents = new ArrayList<>();
		backComponents = new ArrayList<>();
		middleComponents = new ArrayList<>();
		frontComponents = new ArrayList<>();
		menuComponents = new ArrayList<>();
	}
	
	public void addGameComponent(Drawable object){
		switch(object.getDrawingLayout()){
		case BACKGROUND:
			backgroundComponents.add(object);
			break;
		case BACK:
			backComponents.add(object);
			break;
		case MIDDLE:
			middleComponents.add(object);
			break;
		case FRONT:
			frontComponents.add(object);
			break;
		case MENU:
			menuComponents.add(object);
			break;
		}
	}
	
	public void addCenterObject(Drawable object){
		centerObject = object;
		addGameComponent(object);
	}
		
	public void paint(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		ArrayList<Drawable> components = new ArrayList<>();
		components.addAll(backgroundComponents);
		components.addAll(backComponents);
		components.addAll(middleComponents);
		components.addAll(frontComponents);
		components.addAll(menuComponents);
		for(Drawable object : components){
			int centerX, centerY, x, y, height, width;
			double theta;
			centerX = getWidth()/2-centerObject.getWidth()/2;
			centerY = getHeight()/2-centerObject.getHeight()/2;
			height = object.getHeight();
			width = object.getWidth();
			theta = object.getTheta();
			if(object instanceof GameObject && object.equals(centerObject)){
				x = centerX;
				y = centerY;
			}
			else{
				x = centerObject.getX()-centerX;
				y = centerObject.getY()-centerY;
				x = object.getX()-x;
				y = object.getY()-y;
			}
			g2.setColor(object.getColor());
			g2.rotate(theta, x + (double)width/2, y + (double)height/2);
			Drawable.DrawType drawType = object.getDrawType();
			switch(drawType){
			case IMAGE:
				g2.drawImage(object.getImage(), x, y, this);
				break;
			case TEXT:
				g2.drawString(object.getString(), x, y);
				break;
			case FILLOVAL:
				break;
			}
			g2.rotate(-theta, x + (double)width/2, y + (double)height/2);
		}
	}
}
