package engine;

public abstract class Level extends ActorCollection{
	private Level next;
	private boolean isLevelFinished = false;
	
	public enum MouseCode{
		RIGHT,
		LEFT
	}
	public abstract void upPressed();
	public abstract void downPressed();
	public abstract void leftPressed();
	public abstract void rightPressed();
	public abstract void spacePressed();
	public abstract void enterPressed();
	public abstract void escapePressed();
	public abstract void mousePressed(MouseCode code, int x, int y);
	
	public void setNextLevel(Level next){
		this.next = next;
	}
	
	public Level getNextLevel(){
		return next;
	}
	
	public boolean isLevelFinished(){
		return isLevelFinished;
	}
	
	public void finishLevel(){
		isLevelFinished = true;
	}
	
	public void tick(){
		super.tick();
		for(Actor actor : getActorCollection()){
			if(actor.isDestroyed())
				removeActor(actor);
		}
	}
}
