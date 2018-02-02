package Entity;

import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import TileMap.TileMap;

public class Player extends Enemy {

	private BufferedImage[] spritesfeet;
	private BufferedImage[] spritesbody;
	BufferedImage[] spritesfeetidle;
	private Point mousePosition;
	private PointerInfo p;
	boolean idle = true;
	private int soundStep;
	private int bulletsFired = 0;

	public int getBulletsFired() {
		return bulletsFired;
	}

	public Player(TileMap tm) {

		super(tm);
		facing = facingUp;

		width = 30;
		height = 30;
		cwidth = 25;
		cheight = 25;

		moveSpeed = 2;
		maxSpeed = 2;
		stopSpeed = 0.4;
		fallSpeed = 0.15;
		maxFallSpeed = 4.0;
		jumpStart = -4.8;
		stopJumpSpeed = 0.3;

		// sounds
		soundStep = 0;
		// load sprites
		try {
			BufferedImage spritesheetfeet;
			spritesheetfeet = ImageIO.read(getClass().getResourceAsStream("/Resources/Human.gif"));

			spritesfeet = new BufferedImage[20];
			for (int i = 0; i < spritesfeet.length; i++) {
				spritesfeet[i] = spritesheetfeet.getSubimage(i * getWidth(), 0, getWidth(), getHeight());
			}

			BufferedImage spritesheetbody;

			spritesheetbody = ImageIO.read(getClass().getResourceAsStream("/Resources/Soldier/Riflemove30.gif"));

			spritesbody = new BufferedImage[20];
			for (int i = 0; i < spritesbody.length; i++) {
				spritesbody[i] = spritesheetbody.getSubimage(i * getWidth(), 0, getWidth(), getHeight());
			}
			BufferedImage spritesheetfeetidle;

			spritesheetfeetidle = ImageIO.read(getClass().getResourceAsStream("/Resources/Soldier/idle30.gif"));

			spritesfeetidle = new BufferedImage[1];
			for (int i = 0; i < spritesfeetidle.length; i++) {
				spritesfeetidle[i] = spritesheetfeetidle.getSubimage(i * getWidth(), 0, getWidth(), getHeight());
			}

		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		animation = new Animation();
		animation.setFrames(spritesfeetidle);
		animation.setDelay(0);

		animation2 = new Animation();
		animation2.setFrames(spritesbody);
		animation2.setDelay(60);

	}

	void getNextPosition() {

		// movement
		if (left || right || up || down) {
			if (soundStep >= 15) {
				soundStep = 0;
			}
			soundStep++;
		}

		if (left) {
			dx -= moveSpeed;
			if (dx < -maxSpeed) {
				dx = -maxSpeed;
			}
		} else if (right) {
			dx += moveSpeed;
			if (dx > maxSpeed) {
				dx = maxSpeed;
			}
		}

		if (up) {
			dy -= moveSpeed;
			if (dy < -maxSpeed) {
				dy = -maxSpeed;
			}
		} else if (down) {
			dy += moveSpeed;
			if (dy > maxSpeed) {
				dy = maxSpeed;
			}
		}
		/*
		 * if(up ){ dx = -moveSpeed/2 *
		 * StrictMath.cos(Math.toRadians(getRelationToMouse())); dy = -moveSpeed/2 *
		 * StrictMath.sin(Math.toRadians(getRelationToMouse()));
		 * 
		 * } if(down ){ dx = moveSpeed/2 *
		 * StrictMath.cos(Math.toRadians(getRelationToMouse())); dy = moveSpeed/2 *
		 * StrictMath.sin(Math.toRadians(getRelationToMouse()));
		 * 
		 * } if(left && up||down){ dx += moveSpeed/2 *
		 * StrictMath.cos(Math.toRadians(getRelationToMouse() + 90)); dy += moveSpeed/2
		 * * StrictMath.sin(Math.toRadians(getRelationToMouse() + 90)); } else if(left){
		 * dx = moveSpeed/2 * StrictMath.cos(Math.toRadians(getRelationToMouse() + 90));
		 * dy = moveSpeed/2 * StrictMath.sin(Math.toRadians(getRelationToMouse() + 90));
		 * }
		 * 
		 * if(right && up||down){ dx += moveSpeed/2 *
		 * StrictMath.cos(Math.toRadians(getRelationToMouse() - 90)); dy += moveSpeed/2
		 * * StrictMath.sin(Math.toRadians(getRelationToMouse() - 90));
		 * 
		 * } else if(right){ dx += moveSpeed/2 *
		 * StrictMath.cos(Math.toRadians(getRelationToMouse() - 90)); dy += moveSpeed/2
		 * * StrictMath.sin(Math.toRadians(getRelationToMouse() - 90));
		 * 
		 * }
		 */
	}

	public void update() {

		animation.update();
		animation2.update();
		// update position
		if (dy == 0 && dx == 0 && idle == false) {
			animation = new Animation();
			animation.setFrames(spritesfeetidle);
			idle = true;
		}

		if (idle == true && (dy != 0 || dx != 0)) {
			animation = new Animation();
			animation.setFrames(spritesfeet);
			animation.setDelay(30);
			idle = false;
		}
		p = MouseInfo.getPointerInfo();
		mousePosition = p.getLocation();
		getNextPosition();
		checkTileMapCollision();
		setPosition(xtemp, ytemp);

		// set direction
	}

	@Override
	public void draw(Graphics2D g) {
		/*
		 * for(Sound s:sounds){ s.draw(g); }
		 */
		setMapPosition();
		super.draw(g, getRelationToMouse());

	}

	public void keyPressed(int k) {

		if (k == KeyEvent.VK_W) {
			up = true;
		}
		if (k == KeyEvent.VK_S) {
			down = true;
		}
		if (k == KeyEvent.VK_A) {
			left = true;
		}
		if (k == KeyEvent.VK_D) {
			setRight(true);

		}

		if (k == KeyEvent.VK_Q) {
			bulletsFired++;
		}
	}

	public void keyReleased(int k) {
		if (k == KeyEvent.VK_W) {
			up = false;

			dy = 0;

		}
		if (k == KeyEvent.VK_S) {
			down = false;

			dy = 0;

		}
		if (k == KeyEvent.VK_A) {
			left = false;

			dx = 0;

		}
		if (k == KeyEvent.VK_D) {
			right = false;
			dx = 0;

		}

	}

	private double getRelationToMouse() {
		try {
			if (mousePosition != null) {

				return Math.toDegrees(StrictMath.atan2(y - (mousePosition.y - 25), x - mousePosition.x));

			} else {
				return 90;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 90;
		}

	}

	public void mouseClicked(MouseEvent e) {

	}

	public void mousePressed(MouseEvent e) {

	}

	public void mouseReleased(MouseEvent e) {

	}

}
