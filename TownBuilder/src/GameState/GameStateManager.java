package GameState;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class GameStateManager {

	private GameState[] gameStates;
	private int currentState;

	public static final int NUMGAMESTATES = 2;
	public static final int MENUSTATE = 0;
	public static final int ACTUALLEVELSTATE = 1;

	public GameStateManager() {

		gameStates = new GameState[NUMGAMESTATES];

		currentState = MENUSTATE;
		loadState(currentState);

	}

	private void loadState(int state) {
		if (state == MENUSTATE) {
			gameStates[state] = new MenuState(this);
		}
		if (state == ACTUALLEVELSTATE) {
			gameStates[state] = new MainGameState(this);
		}
	}

	private void unloadState(int state) {

	}

	public void setState(int state) {
		unloadState(currentState);
		currentState = state;
		loadState(currentState);

	}

	public void update() {
		try {
			gameStates[currentState].update();

		} catch (Exception e) {
			System.out.println(e);
			loadState(currentState);
		}
	}

	public void draw(java.awt.Graphics2D g) {
		try {
			gameStates[currentState].draw(g);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void keyPressed(int k) {
		if (currentState != 0 && k == KeyEvent.VK_ESCAPE) {
			if (k == KeyEvent.VK_ESCAPE) {
				setState(0);
			}
		} else {
			gameStates[currentState].keyPressed(k);
		}
	}

	public void keyReleased(int k) {
		try {
		gameStates[currentState].keyReleased(k);
		}
		catch(Exception e) {
			
		}
	}

	public void mouseClicked(MouseEvent e) {
		gameStates[currentState].mouseClicked(e);
	}

	public void mousePressed(MouseEvent e) {
		gameStates[currentState].mousePressed(e);
	}

	public void mouseReleased(MouseEvent e) {
		gameStates[currentState].mouseReleased(e);
	}

}
