package Entity;


import TileMap.TileMap;
import java.awt.Polygon;
import java.util.ArrayList;

public class Enemy extends MapObject {
	

	protected boolean dead;
	protected int damage;
        protected boolean canSee;
        protected boolean canFire = false;
        protected Polygon poly;
        protected ArrayList<Enemy> canSeeEnemies;
        public boolean hit;

        
	
	
	public Enemy(TileMap tm) {
		super(tm);
	}
	
	public boolean isDead() { return dead; }
	
	public int getDamage() { return damage; }
	
	public void hit(int damage) {
		
	}
         public boolean getHit() {
        return hit;
    }

    public void setHit(boolean hit) {
        this.hit = hit;
    }
	
	public void update(ArrayList<Enemy> enemies) {}
        
        
        public void keyPressed(int k){}
        public void keyReleased(int k){}
        
        

	
}














