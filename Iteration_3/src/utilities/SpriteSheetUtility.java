package utilities;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import model.occupation.Summoner;
import model.occupation.Smasher;
import model.occupation.Sneak;

public class SpriteSheetUtility {
	private String imagePath="";
	private BufferedImage image;
	private BufferedImage[] spriteArray = new BufferedImage[10];
	private final int width = 32;
	private final int height = 32;
	private int offsetX, offsetY;

	public SpriteSheetUtility() {
		//DEFAULT WILL JUST BE A Summoner FOR SAFETY REASONS
		imagePath = "src/res/summoner.gif";
		initialize();
	}
	
	public SpriteSheetUtility(Summoner s) {
		imagePath = "src/res/summoner.gif";
		initialize();
	}
	
	public SpriteSheetUtility(Sneak sn) {
		imagePath = "src/res/summoner.gif";
		initialize();
	}
	public SpriteSheetUtility(Smasher s) {
		imagePath = "src/res/summoner.gif";
		initialize();
	}
	protected void initialize() {
		try {
		 image = ImageIO.read(new File(imagePath));
		} 
		
		catch(IOException e) {
			System.err.println(" 404 IMAGE NOT FOUND");
		}
		initializeSpriteArray();
	}
	public BufferedImage[] getSpriteArray() {
		return spriteArray;
	}
	
	public String getPath() {
		return imagePath;
	}
	
	protected void initializeSpriteArray() {
		for (int i=0; i<10; i++) {
			spriteArray[i] = getSpriteDirection(i);
		}
	}
	private BufferedImage getSpriteDirection(int direction) {
		System.out.println("Working"+direction);
		switch (direction) {
		
		
		case 0: { //DANCING PART 1
			return getSprite(0,64);
		}
		case 1: { //SOUTH_WEST
			return getSprite(0,64);
		}
		case 2: { //SOUTH
			return getSprite(0,64);
		}
		case 3: { //SOUTH_EAST
			return getSprite(0,64);
		}
		case 4: { //WEST
			return getSprite(0,96);
		}
		case 5: { //DANCING PART 2
			return getSprite(0,64);
		}
		case 6: { //EAST
			return getSprite(0,160);
		}
		case 7: { //NORTH_WEST
			BufferedImage temp = getSprite(0,128);
			
			AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
		    tx.translate(-temp.getWidth(null), 0);
		    AffineTransformOp op = new AffineTransformOp(tx,
		        AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
		    return op.filter(temp, null);
		}
		case 8: { //NORTH
			return getSprite(0,128);
		}
		case 9: { //NORTH_EAST
			return getSprite(0,128);
		}
		default: {//south??
			System.out.println("Working");
			return getSprite(0,64);
		}
		}
	}
	
	private BufferedImage getSprite(int offsetX, int offsetY) {
		BufferedImage subSprite = image.getSubimage(offsetX , offsetY , width, height);
		return subSprite;
	}
	
}
