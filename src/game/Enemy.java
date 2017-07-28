package game;

import java.awt.Color;
import java.util.Random;

import engine.Level;

public class Enemy extends Character{
	private int count;
	private Random randomGenerator;
	private int attackSpeed;
	private int randomTime;
	private int rotation;
	private int actionChooseTime;
	
	private enum State{
		WAIT,
		MOVE,
		ROTATE,
		ROTATEANDMOVE,
		ATTACK
	}
	private State state;
	
	public Enemy(Level level, int x, int y, int rotateDegrees) {
		super(level, Color.RED, "Enemy", x, y, rotateDegrees);
		state = State.WAIT;
		setDrawingLayout(DrawingLayout.BACK);
		count = 0;
		attackSpeed = 97;
		randomTime = 31;
		rotation = 0;
		actionChooseTime = 181;
		randomGenerator = new Random();
		setBoundry(0, 0, Background.WIDTH - getWidth(), Background.HEIGHT - getHeight());
	}
	
	public void setAttackSpeed(int attackSpeed) { this.attackSpeed = attackSpeed; }
	
	public void hit(int hitPoints){
		super.hit(hitPoints);
		state = State.ATTACK;
	}
	
	public void tick(){
		super.tick();
		if(count==Integer.MAX_VALUE)
			count = 0;
		else
			count++;
		if(count%actionChooseTime==0 && state != State.ATTACK){
			int random = randomGenerator.nextInt(4);
			if(random==0){
				state = State.WAIT;
				randomTime = randomGenerator.nextInt(113)+1;
			}
			else if(random==1){
				state = State.MOVE;
				randomTime = randomGenerator.nextInt(23)+1;
			}
			else if(random==2){
				state = State.ROTATE;
				randomTime = randomGenerator.nextInt(71)+1;
			}
			else{
				state = State.ROTATEANDMOVE;
				randomTime = randomGenerator.nextInt(71)+1;
			}
			rotation = randomGenerator.nextInt(2);
		}
		switch(state){
		case MOVE:
			moveForward();
			if(count%randomTime==0)
				state = State.WAIT;
			break;
		case ROTATE:
			if(rotation==0)
				rotateLeft();
			else
				rotateRight();
			if(count%randomTime==0)
				state = State.WAIT;
			break;
		case ROTATEANDMOVE:
			if(rotation==0)
				rotateLeft();
			else
				rotateRight();
			moveForward();
			if(count%randomTime==0)
				state = State.WAIT;
			break;
		case ATTACK:
			focus(getLevel().getCenterActor().getX() + getLevel().getCenterActor().getWidth()/2,
					getLevel().getCenterActor().getY() + getLevel().getCenterActor().getHeight()/2);
			if(getDistance(getLevel().getCenterActor())>1000)
				state = State.WAIT;
			else if(getDistance(getLevel().getCenterActor())>200)
				moveForward();
			if(count%attackSpeed==0){
				attack();
			}
			break;
		default:
			break;
		}
	}

}
