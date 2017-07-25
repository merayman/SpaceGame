package game;

import java.awt.Color;
import java.util.ArrayList;

import engine.Actor;
import engine.Level;

public class FirstMap extends Level{
	Character player, enemy;
	
	public FirstMap(){
		player = new Character(40, 40, -90);
		enemy = new Character(100, 100, 90);
		addActor(new Background());
		//addActor(enemy);
		addCenterActor(player);
		addActor(new InformationWindow());
	}
	
	@Override
	public void upPressed() {
		// TODO Auto-generated method stub
	}

	@Override
	public void leftPressed() {
		// TODO Auto-generated method stub
	}

	@Override
	public void rightPressed() {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseCode code, int x, int y) {
		// TODO Auto-generated method stub
	}

	@Override
	public void downPressed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void spacePressed() {
		Bullet bullet = new Bullet(player,
				player.getX()+player.getWidth()/2,
				player.getY()+player.getHeight()/2,
				player.getCenterActor().getRotateDegrees());
		addActor(bullet);
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
	
	public void tick(){
		super.tick();
		for(Actor bullet : getActorCollection()){
			if(bullet instanceof Bullet){
				if(bullet.getDistance(player)>700){
					bullet.destroyActor();
				}
				else{
					ArrayList<Actor> overlappingActors = bullet.getOverlappingActors(this);
					for(Actor actor : overlappingActors){
						if(actor instanceof Character && !actor.equals(((Bullet) bullet).getCharacter())){
							((Character) actor).hit(5);
							bullet.destroyActor();
						}
					}
				}
			}
		}
	}
}
