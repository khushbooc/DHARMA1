package model.gameMap;

import model.entity.Entity;

/**
 * Created by giangnguyen on 4/16/15.
 */
public class Obstable extends Item {

    public Obstable(Location location, String name){
        super(location, name);
    }

    @Override
    public boolean isCollidable(){
        return false;
    }

    @Override
    public void onTouch(Entity e){
        //TODO
    }

}
