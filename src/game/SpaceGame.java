package game;

import java.util.ArrayList;

import gui.GameScreen;

public class SpaceGame extends GameObject{
	private ArrayList<GameObject> gameObjects;
	GameScreen gameScreen;
	Character character;
	GameObject centerObject;
	
	public SpaceGame(GameScreen gameScreen){
		this.gameScreen = gameScreen;
		gameObjects = new ArrayList<>();
		character = new Character(60, 60, 0);
		Character enemy = new Character(200, 200, 10);
		gameObjects.add(character);
		gameObjects.add(enemy);
		centerObject = character;
		gameScreen.addCenterObject(character);
		gameScreen.addGameComponent(enemy);
	}
	
	public GameObject getCenterObject(){
		return centerObject;
	}

	@Override
	public void atStart() {
		for(GameObject object : gameObjects){
			object.atStart();
		}
	}

	@Override
	public void tick() {
		for(GameObject object : gameObjects){
			object.tick();
		}
	}
	
	public void upPressed(){
		character.moveForward();
	}
	
	public void leftPressed(){
		character.rotateLeft();
	}
	
	public void rightPressed(){
		character.rotateRight();
	}
	
	public void mousePressed(int x, int y){
		character.rotate(x, y);
	}
	
}
