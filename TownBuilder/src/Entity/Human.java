package Entity;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import TileMap.TileMap;

public class Human extends MapObject {

	public BufferedImage sprite;
	public Animation animation;

	public Human(TileMap tm) {
		super(tm);

		width = 16;
		height = 16;
		cwidth = 16;
		cheight = 16;

		moveSpeed = 2;
		maxSpeed = 2;

		// load Sprite

		try {
			sprite = ImageIO.read(getClass().getResourceAsStream("/Resources/Sprites/Human.gif"));

		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		animation = new Animation();
		BufferedImage[] b = new BufferedImage[1];
		b[0] = sprite;
		animation.setFrames(b);
		animation.setDelay(0);
	}

	void update() {

		getNextPosition();
		checkTileMapCollision();
		setPosition(xtemp, ytemp);

	}

	public void draw(Graphics2D g) {

		AffineTransform at = AffineTransform.getTranslateInstance((x + xmap - width / 2) + 30, (y + ymap - height / 2));
		at.rotate(Math.toRadians(90));
		g.drawImage(sprite, at, null);

	}

	void getNextPosition() {

		// movement
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
	}

}
