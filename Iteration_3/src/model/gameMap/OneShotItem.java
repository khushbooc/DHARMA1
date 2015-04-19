package model.gameMap;

import model.entity.Entity;

/**
 * Created by giangnguyen on 4/16/15.
 */
public class OneShotItem extends Item {
    public OneShotItem( Location location, String name){
        super(location, name);
    }

    @Override
    public void onTouch(Entity e){
        //TODO
    }
    @Override
    public boolean isCollidable(){
        return true;
    }
}
