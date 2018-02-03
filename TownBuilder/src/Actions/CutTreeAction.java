package Actions;

import Entity.MapObject;

public class CutTreeAction extends Action {
	

	public CutTreeAction(double time, int noWorkers, MapObject obj) {
		super(time, noWorkers, obj);
	}
	
	public CutTreeAction(MapObject obj) {
		super(12, 1, obj);
	}

}
