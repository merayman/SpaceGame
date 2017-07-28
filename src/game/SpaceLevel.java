package game;

import java.util.ArrayList;
import java.util.Random;

import engine.Actor;
import engine.Level;

public class SpaceLevel extends Level{
	private Player player;
	private Station station;
	private ArrayList<Enemy> enemies;
	public static final int WIDTH = 1356;
	public static final int HEIGHT = 758;
	
	public SpaceLevel(){
		enemies = new ArrayList<Enemy>();
		player = new Player(this, 1000, 1000, 0);
		player.setDrawingLayout(DrawingLayout.FRONT);
		Random randomGenerator = new Random();
		for(int i=0; i<50; i++){
			Enemy enemy = new Enemy(this, randomGenerator.nextInt(3000),
					randomGenerator.nextInt(3000), randomGenerator.nextInt(360));
			addActor(enemy);
		}
		station = new Station(this);
		station.setX(300);
		station.setY(300);
		addCenterActor(player);
		addActor(new Background());
		addActor(station);
		setNextLevel(new End());
	}
	
	@Override
	public void upPressed() {
		player.moveForward();
	}

	@Override
	public void leftPressed() {
		player.rotateLeft();
	}

	@Override
	public void rightPressed() {
		player.rotateRight();
	}

	@Override
	public void mousePressed(MouseCode code, int x, int y) {
		
	}

	@Override
	public void downPressed() {
		// TODO Auto-generated method stub
	}

	@Override
	public void spacePressed() {
		player.attack();
	}

	@Override
	public void enterPressed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void escapePressed() {
		// TODO Auto-generated method stub
		
	}
	
	public void atStart(){
		super.atStart();
	}
	
	private boolean isEnemyLeft(){
		for(Actor actor : getActorCollection())
			if(actor instanceof Enemy)
				return true;
		return false;
	}
	
	public void tick(){
		super.tick();
		if(!isEnemyLeft()){
			finishLevel();
		}
	}
}
