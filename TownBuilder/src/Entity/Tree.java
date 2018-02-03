package Entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Actions.CutTreeAction;
import TileMap.TileMap;

public class Tree extends Resource {
	public BufferedImage sprite;

	public Tree(TileMap tm) {
		super(tm);
		action  = new CutTreeAction(this);
		
		width = 32;
		height = 32;
		cwidth = 32;
		cheight = 32;
		
		try {
			sprite = ImageIO.read(getClass().getResourceAsStream("/Resources/Sprites/tree.png"));

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
	
	public void update() {
	}
	
	public void draw(Graphics2D g) {
		g.drawImage(sprite, getx(), gety(), getWidth(), getHeight(), null);
	}
	

}
