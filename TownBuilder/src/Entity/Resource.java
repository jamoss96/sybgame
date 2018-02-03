package Entity;

import Actions.Action;
import Actions.CutTreeAction;
import TileMap.TileMap;

public abstract class Resource extends MapObject {
	
	protected Action action;

	public Resource(TileMap tm) {
		super(tm);
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

}
