package model.gameMap;

import model.entity.Entity;

/**
 * Created by giangnguyen on 4/16/15.
 */
public abstract class Item extends MapObject{
    protected String name;

    public Item(Location location, String name){
        super(location);
        this.name = name;
    }

    public abstract boolean isCollidable();

    public abstract void onTouch(Entity e);

}
