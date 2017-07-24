package engine;

public class Game extends GameObject{
	private Level level;
	
	public Game(Level level){
		this.level = level;
	}
	
	public Level getLevel(){
		return level;
	}

	public void atStart() {
		level.atStart();
	}

	public void tick() {
		if(level.isLevelFinished()){
			level = level.getNextLevel();
			level.atStart();
		}
		level.tick();
	}
}
