
package model.inventory;
import model.entity.Entity;
import model.gameMap.Location;



public abstract class NonEquipableItem extends TakeableItem {
	
	public NonEquipableItem(Location location, String name){
        super(location, name);
    }

    @Override
    public boolean isCollidable(){
        return true;
    }

    @Override
    public void onTouch(Entity e){
        //TODO
    }

    @Override
    public void use(Entity e){
        //TODO: affect entity stats
    }



}
