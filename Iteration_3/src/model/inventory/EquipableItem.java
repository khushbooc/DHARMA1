
package model.inventory;

import model.entity.Entity;
import model.gameMap.Location;

public abstract class EquipableItem extends TakeableItem{
	
	public EquipableItem(Location location, String name){
        super(location, name);
    }

    @Override
    public boolean isCollidable(){
        return true;
    }

    @Override
    public void onTouch(Entity e){
        //TODO:
    }

    @Override
    public abstract void use(Entity e);

}
