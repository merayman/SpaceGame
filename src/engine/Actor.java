package engine;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;

public class Actor extends GameObject implements Drawable{
	private Image img;
	private String text;
	
	private DrawType drawType;
	private DrawingLayout drawingLayout;
	
	private Color color;
	private Font font;
	
	private int x, y, height, width, rotateDegrees;
	
	private boolean isDestroyed;
	
	public Actor(){
		isDestroyed = false;
		img = null;
		text = "";
		drawType = DrawType.EMPTY_PAWN;
		drawingLayout = DrawingLayout.BACKGROUND;
		color = Color.BLACK;
		font = new Font("TimesRoman", Font.PLAIN, 14);
		x = 0;
		y = 0;
		height = 0;
		width = 0;
		rotateDegrees = 0;
	}
	
	public ArrayList<Actor> getOverlappingActors(Level level){
		ArrayList<Actor> overlappingActors = new ArrayList<Actor>();
		ArrayList<Actor> actorsInLevel = level.getActorCollection();
		for(Actor actor : actorsInLevel){
			if(actor.isOverlapping(this)){
				overlappingActors.add(actor);
			}
		}
		return overlappingActors;
	}
	
	public void destroyActor(){
		isDestroyed = true;
	}
	
	public boolean isDestroyed(){
		return isDestroyed;
	}
	
	public int getDistance(Actor actor){
		return (int) Math.sqrt(Math.pow(actor.getY()-y, 2)+Math.pow(actor.getX()-x, 2));
	}
	
	public boolean isOverlapping(Actor actor){
		boolean isOverlapping;
		isOverlapping = (this.x + this.width) > actor.getX() && (this.y + this.height) > actor.getY() &&
				this.x < (actor.getX() + actor.getWidth()) && this.y < (actor.getY() + actor.getHeight());
		return isOverlapping;
	}
	
	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public double getTheta() {
		return Math.toRadians(rotateDegrees);
	}

	public Image getImage() {
		return img;
	}

	public String getText() {
		return text;
	}

	public Color getColor() {
		return color;
	}

	public DrawType getDrawType() {
		return drawType;
	}

	public DrawingLayout getDrawingLayout() {
		return drawingLayout;
	}
	
	public Font getFont() {
		return font;
	}
	
	public int getRotateDegrees(){
		return rotateDegrees;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void setRotateDegrees(int rotateDegrees){
		this.rotateDegrees = rotateDegrees;
	}

	public void setImage(Image img) {
		this.img = img;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void setDrawType(DrawType drawType) {
		this.drawType = drawType;
	}

	public void setDrawingLayout(DrawingLayout drawingLayout) {
		this.drawingLayout = drawingLayout;
	}
	
	public void setFont(Font font) {
		this.font = font;
	}

	public void atStart() {
		
	}

	public void tick() {
		
	}

}
