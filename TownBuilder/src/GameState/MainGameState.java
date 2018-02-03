package GameState;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import Actions.Action;
import Entity.Human;
import Entity.MapObject;
import Entity.Resource;
import Entity.Tree;
import Main.GamePanel;
import TileMap.Background;
import TileMap.TileMap;

public class MainGameState extends GameState {

	private Background bg;
	private TileMap tileMap;
	private Human a;
	private Tree tree1;
	private ArrayList<Human> humans;
	private ArrayList<Resource> resources;

	public MainGameState(GameStateManager gsm) {

		this.gsm = gsm;
		init();

	}

	public void init() {

		tileMap = new TileMap(30);
		tileMap.loadTiles("/Resources/TileMaps/GrassyTileMap.gif");
		tileMap.loadMap("/Resources/Map/grassy.map");
		tileMap.setPosition(0, 0);
		tileMap.setTween(0.07);
		humans = new ArrayList<Human>();
		resources = new ArrayList<Resource>();

		a = new Human(tileMap);
		a.setPosition(285, 285);
		humans.add(a);
		
		tree1 = new Tree(tileMap);
		tree1.setPosition(220, 220);
		resources.add(tree1);
		
		

	}

	@Override
	public void update() {

		tileMap.setPosition(GamePanel.WIDTH / 2, GamePanel.HEIGHT / 2);
		for(Human human : humans) {
			human.update();
			if(human.getAction() == null) {
				for(Resource resource : resources) {
					if(resource.getAction().spaceOnAction()) {
						resource.getAction().addWorker(human);
						human.setAction(resource.getAction());
					}
				}
			}
		}
		for(Resource resource : resources) {
			resource.update();
		}
	}

	@Override
	public void draw(Graphics2D g) {

		// draw tilemap
		tileMap.draw(g);
		for(Human human : humans) {
			human.draw(g);
		}
		for(Resource resource : resources) {
			resource.draw(g);
		}


	}

	public void keyPressed(int k) {
		if (k == KeyEvent.VK_ENTER) {

		}
		if (k == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}
		if (k == KeyEvent.VK_UP) {

		}
		if (k == KeyEvent.VK_DOWN) {

		}
	}

	public void keyReleased(int k) {
	}

}
