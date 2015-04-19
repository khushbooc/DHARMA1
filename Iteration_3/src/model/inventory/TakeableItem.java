
package model.inventory;


import model.entity.Entity;
import model.gameMap.Item;
import model.gameMap.Location;

//created by ashish aggarwal

public abstract class TakeableItem extends Item {

    public TakeableItem(Location location, String name){
	        super(location, name);
    }

    public boolean isCollidable()
    {
	    	return true;
    }
    @Override
    public void onTouch(Entity e)
    {
	  //TODO
    }
    public abstract void use (Entity e);
}
