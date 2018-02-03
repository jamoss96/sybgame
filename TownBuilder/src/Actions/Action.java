package Actions;

import java.util.ArrayList;

import Entity.MapObject;

public abstract class Action {
	private double timeTaken;
	private double ticks;
	private int numberOfWorkers;
	private MapObject obj;
	private boolean destroyed = false;
	private ArrayList<MapObject> workers;
	
	

	public Action(double time, int noWorkers, MapObject mapObject){
		timeTaken = time;
		ticks = time;
		setNumberOfWorkers(noWorkers);
		obj = mapObject;
	}
	
	public void update() {
		for(MapObject mapObj : workers) {
			if(mapObj.isWorking()) {
				ticks--;
			}
		}
		if(ticks <= 0) {
			destroyed = true;
		}
	}
	
	public void addWorker(MapObject obj) {
		workers.add(obj);
	}
	
	public boolean isDestroyed() {
		return destroyed;
	}

	public int getNumberOfWorkers() {
		return numberOfWorkers;
	}

	public void setNumberOfWorkers(int numberOfWorkers) {
		this.numberOfWorkers = numberOfWorkers;
	}
	
	public ArrayList<MapObject> getWorkers() {
		return workers;
	}

	public void setWorkers(ArrayList<MapObject> workers) {
		this.workers = workers;
	}
	
	public boolean spaceOnAction() {
		if(workers.size() < numberOfWorkers) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	

}
