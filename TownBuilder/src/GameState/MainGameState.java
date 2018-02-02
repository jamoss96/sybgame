package GameState;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import Entity.Human;
import Main.GamePanel;
import TileMap.Background;
import TileMap.TileMap;

public class MainGameState extends GameState {

	private Background bg;
	private TileMap tileMap;
	private Human a;

	public MainGameState(GameStateManager gsm) {

		this.gsm = gsm;
		init();

	}

	public void init() {

		tileMap = new TileMap(30);
		tileMap.loadTiles("/Resources/TileMaps/GrassyTileMap.gif");
		tileMap.loadMap("/Resources/Maps/grassy.map");
		tileMap.setPosition(0, 0);
		tileMap.setTween(0.07);

		a = new Human(tileMap);
		a.setPosition(285, 285);

	}

	@Override
	public void update() {

		tileMap.setPosition(GamePanel.WIDTH / 2, GamePanel.HEIGHT / 2);
	}

	@Override
	public void draw(Graphics2D g) {

		// draw tilemap
		tileMap.draw(g);
		a.draw(g);

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
