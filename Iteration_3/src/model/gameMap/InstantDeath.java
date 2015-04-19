package model.gameMap;

import model.entity.Entity;

public class InstantDeath extends AreaEffect{

    public InstantDeath(String name){
        super(name);
    }

    @Override
    public void applyEffect(Entity e){
        //TOD0: wait for entity to be created
    }
    public String getName(){
        return name;
    }

}
