package engine;

public abstract class GameObject{
	private static int numOfObject = 0;
	private int ID;
	public abstract void atStart();
	public abstract void tick();
	
	GameObject(){
		numOfObject++;
		ID = numOfObject;
	}
	
	public int getID(){
		return ID;
	}
	
	public boolean equals(Object o){
		if(o instanceof GameObject){
			GameObject object = (GameObject)o;
			return object.getID()==ID;
		}
		return false;
	}
}
