package engine;

import java.util.ArrayList;

public class ActorCollection extends Actor{
	private ArrayList<Actor> backgroundActors;
	private ArrayList<Actor> backActors;
	private ArrayList<Actor> middleActors;
	private ArrayList<Actor> frontActors;
	private ArrayList<Actor> menuActors;
	private Actor centerActor;
	
	public ActorCollection(){
		super();
		passiveActor();
		setDrawType(DrawType.COLLECTION);
		backgroundActors = new ArrayList<>();
		backActors = new ArrayList<>();
		middleActors = new ArrayList<>();
		frontActors = new ArrayList<>();
		menuActors = new ArrayList<>();
		centerActor = new Actor();
	}
	
	public void addActor(Actor actor){
		switch(actor.getDrawingLayout()){
		case BACKGROUND:
			backgroundActors.add(actor);
			break;
		case BACK:
			backActors.add(actor);
			break;
		case MIDDLE:
			middleActors.add(actor);
			break;
		case FRONT:
			frontActors.add(actor);
			break;
		case MENU:
			menuActors.add(actor);
			break;
		}
		actor.atStart();
	}
	
	public void removeActor(Actor removeObject){
		backgroundActors.remove(removeObject);
		backActors.remove(removeObject);
		middleActors.remove(removeObject);
		frontActors.remove(removeObject);
		menuActors.remove(removeObject);
	}
	
	public ArrayList<Actor> getActorCollection(){
		ArrayList<Actor> collection = new ArrayList<>();
		collection.addAll(backgroundActors);
		collection.addAll(backActors);
		collection.addAll(middleActors);
		collection.addAll(frontActors);
		collection.addAll(menuActors);
		return collection;
	}
	
	public void addCenterActor(Actor object){
		removeActor(centerActor);
		centerActor = object;
		addActor(centerActor);
		setWidth(centerActor.getWidth());
		setHeight(centerActor.getHeight());
	}
	
	public Actor getCenterActor(){
		return centerActor;
	}
	
	public void tick(){
		super.tick();
		if(isActorPassive()){
			setX(centerActor.getX());
			setY(centerActor.getY());
		}
		for(Actor actor : getActorCollection()){
			if(actor.isActorPassive()){
				actor.setX(centerActor.getX()+actor.getRelativeX());
				actor.setY(centerActor.getY()+actor.getRelativeY());
			}
			actor.tick();
		}
	}
	
	public void moveForward(){
		super.moveForward();
		for(Actor actor : getActorCollection()){
			actor.moveForward();
		}
	}
	
	public void moveBackward(){
		super.moveBackward();
		for(Actor actor : getActorCollection()){
			actor.moveBackward();
		}
	}
	
	public void moveRight(){
		super.moveRight();
		for(Actor actor : getActorCollection()){
			actor.moveRight();
		}
	}
	
	public void moveLeft(){
		super.moveLeft();
		for(Actor actor : getActorCollection()){
			actor.moveLeft();
		}
	}
	
	public void focus(int x, int y){
		super.focus(x, y);
		for(Actor actor : getActorCollection()){
			actor.focus(x, y);
		}
	}
	
	public void followActor(Actor focusActor){
		super.followActor(focusActor);
		for(Actor actor : getActorCollection()){
			actor.followActor(focusActor);
		}
	}
	
	public void unfollowActor(){
		super.unfollowActor();
		for(Actor actor : getActorCollection()){
			actor.unfollowActor();
		}
	}
}
