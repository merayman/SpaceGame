package game;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.util.Timer;

public class Character extends GameObject implements Drawable{
	protected Image img;
	protected int rotateDegrees;
	protected int x, y;
	protected int height = 103, width = 100;
	protected int displacement = 7;
	
	Character(int x, int y, int rotateDegrees){
		img = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Furkan\\workspace\\MVCTest\\bin\\Images\\AirObjects\\Aircraft.gif");
		this.x = x;
		this.y = y;
		this.rotateDegrees = rotateDegrees;
	}
	
	public void moveForward(){
		double displacementX = displacement*Math.sin(Math.toRadians(rotateDegrees));
		x += displacementX;
		double displacementY = displacement*Math.cos(Math.toRadians(rotateDegrees));
		y -= displacementY;
	}
	
	public void rotateRight(){
		rotateDegrees += 2;
	}
	
	public void rotateLeft(){
		rotateDegrees -= 2;
	}
	
	public void rotate(int x, int y){
		double vectorX = (x-this.x-(double)width/2);
		double vectorY = (y-this.y-(double)height/2);
		double division = vectorX/vectorY;
		rotateDegrees = (int) -Math.toDegrees(Math.atan(division));
		if(vectorY>0)
			rotateDegrees = rotateDegrees-180;
	}
	
	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public double getTheta() {
		return Math.toRadians(rotateDegrees);
	}

	@Override
	public Image getImage() {
		return img;
	}

	@Override
	public String getString() {
		return "";
	}

	@Override
	public Color getColor() {
		return Color.BLACK;
	}

	@Override
	public DrawType getDrawType() {
		return DrawType.IMAGE;
	}

	@Override
	public DrawingLayout getDrawingLayout() {
		return DrawingLayout.BACKGROUND;
	}

	@Override
	public boolean isRenderedAtSight() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void atStart() {
		// TODO Auto-generated method stub
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

}
