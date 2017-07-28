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
		int maxHeight = Integer.MIN_VALUE, maxWidth = Integer.MIN_VALUE;
		for(Actor a : getActorCollection()){
			if(a.getHeight()>maxHeight)
				maxHeight = a.getHeight();
			if(a.getWidth()>maxWidth)
				maxWidth = a.getWidth();
		}
		setHeight(maxHeight);
		setWidth(maxWidth);
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
	}
	
	public Actor getCenterActor(){
		return centerActor;
	}
	
	public void tick(){
		super.tick();
		for(Actor actor : getActorCollection()){
			actor.tick();
		}
	}
}
