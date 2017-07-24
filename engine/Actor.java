package engine;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;

public class Actor extends GameObject implements Drawable{
	private Actor focusActor;
	private Image img;
	private String text;
	
	private DrawType drawType;
	private DrawingLayout drawingLayout;
	
	private Color color;
	private Font font;
	
	private int minX, minY, maxHeight, maxWidth,
		x, y, height, width, displacement, rotateDegrees,
		relativeX, relativeY;
	
	private boolean isActorRestricted, isActorPassive, isFollowingActor, isDestroyed;
	
	public Actor(){
		isDestroyed = false;
		focusActor = null;
		img = null;
		text = "";
		drawType = DrawType.EMPTY_PAWN;
		drawingLayout = DrawingLayout.BACKGROUND;
		color = Color.BLACK;
		font = new Font("TimesRoman", Font.PLAIN, 14);
		x = 0;
		y = 0;
		relativeX = 0;
		relativeY = 0;
		height = 0;
		width = 0;
		displacement = 7;
		rotateDegrees = 0;
		minX = 0;
		minY = 0;
		maxHeight = 0;
		maxWidth = 0;
		isActorRestricted = false;
		isActorPassive = false;
		isFollowingActor = false;
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
	
	public boolean isFollowingActor(){
		return isFollowingActor;
	}
	
	public void destroyActor(){
		isDestroyed = true;
	}
	
	public boolean isDestroyed(){
		return isDestroyed;
	}
	
	public void setRelativeX(int x){
		relativeX = x;
	}
	
	public void setRelativeY(int y){
		relativeY = y;
	}
	
	public int getRelativeX(){
		return relativeX;
	}
	
	public int getRelativeY(){
		return relativeY;
	}
	
	public void moveForward(){
		if(!isActorPassive){
			double displacementX = displacement*Math.sin(Math.toRadians(rotateDegrees));
			if(!isActorRestricted || x + displacementX < maxWidth && x + displacementX > minX)
				x += displacementX;
			double displacementY = displacement*Math.cos(Math.toRadians(rotateDegrees));
			if(!isActorRestricted || y - displacementY < maxHeight && y - displacementY > minY)
				y -= displacementY;
		}
	}
	
	public void moveBackward(){
		if(!isActorPassive){
			double displacementX = displacement*Math.sin(Math.toRadians(rotateDegrees));
			if(!isActorRestricted || x - displacementX < maxWidth && x - displacementX > minX)
				x -= displacementX;
			double displacementY = displacement*Math.cos(Math.toRadians(rotateDegrees));
			if(!isActorRestricted || y + displacementY < maxHeight && y + displacementY > minY)
				y += displacementY;
		}
	}
	
	public void moveRight(){
		if(!isActorPassive){
			rotateDegrees += 2;
		}
	}
	
	public void moveLeft(){
		if(!isActorPassive){
			rotateDegrees -= 2;
		}
	}
	
	public void focus(int x, int y){
		if(!isActorPassive){
			double vectorX = (x-this.x-(double)width/2);
			double vectorY = (y-this.y-(double)height/2);
			double division = vectorX/vectorY;
			rotateDegrees = (int) -Math.toDegrees(Math.atan(division));
			if(vectorY>0)
				rotateDegrees = rotateDegrees-180;
		}
	}
	
	public void followActor(Actor actor){
		if(!isActorPassive){
			focusActor = actor;
			isFollowingActor = true;
		}
	}
	
	public void unfollowActor(){
		focusActor = null;
		isFollowingActor = false;
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
	
	public void setSpeed(int pixelsPerFrame){
		displacement = pixelsPerFrame;
	}
	
	public void restrictedActor(int minX, int minY, int maxWidth, int maxHeight){
		isActorRestricted = true;
		this.minX = minX;
		this.minY = minY;
		this.maxHeight = maxHeight;
		this.maxWidth = maxWidth;
	}
	
	public void nonRestrictedActor(){
		isActorRestricted = false;
	}
	
	public void passiveActor(){
		isActorPassive = true;
	}
	
	public void activeActor(){
		isActorPassive = false;
	}
	
	public boolean isActorPassive(){
		return isActorPassive;
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
		if(isFollowingActor){
			focus(focusActor.getX(), focusActor.getY());
			if(getDistance(focusActor)>50)
				moveForward();
		}
	}

}
