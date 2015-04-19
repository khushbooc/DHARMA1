package model.entity;

import java.awt.image.BufferedImage;

import utilities.ImageProcessing;
import utilities.ShapeAdjust;
import utilities.SpriteSheetUtility;
import model.ability.Ability;
import model.ability.AbilityLibrary;
import model.inventory.EquipableItem;
import model.inventory.EquipmentContainer;
import model.inventory.Inventory;
import model.inventory.TakeableItem;
import model.occupation.Occupation;

/**
 * Created by giangnguyen on 4/16/15.
 */
public abstract class Entity {
	protected Occupation occupation;
	protected Inventory inventory ;
	protected EquipmentContainer equicontainer;
	protected SpriteSheetUtility util;
	private BufferedImage[] spriteSheet;
	protected int direction=0;
	private BufferedImage image;

	
	public Entity(Occupation occupation){
		this.occupation = occupation;
		SpriteSheetUtility util = occupation.getSpriteSheet();
		this.spriteSheet = (util.getSpriteArray());
	}
	
	
	public Entity(Occupation occupation, Inventory inventory , EquipmentContainer equicontainer) {
		this.occupation = occupation;
		this.inventory = inventory;
		this.equicontainer= equicontainer;
	}
	public BufferedImage getImage(){
		BufferedImage imageToDisplay = spriteSheet[direction];
		image= ImageProcessing.scaleImage(ShapeAdjust.AVATAR_WIDTH, ShapeAdjust.AVATAR_HEIGHT, imageToDisplay);
		return image;
}
	public abstract Occupation getOccupation();
	public abstract Inventory getInventory();
	public abstract EquipmentContainer getEquipmentContainer();
	public void setDirection(int direction){
		this.direction=direction;
	}
	
	public abstract void addToInventory(TakeableItem takeableitem);
	
	public abstract void equipItem(EquipableItem equiItem);
    public abstract void removeItem(TakeableItem ti);
    public abstract void unequipItem(EquipableItem eqi);
    public abstract void useAbility(Ability ability);
}

