package model.gameMap;


import model.entity.Entity;

public class LevelUp extends AreaEffect {

    public LevelUp(String name){
        super(name);
    }
    @Override
    public void applyEffect(Entity e){
        //TODO:
    }
    public String getName(){
        return name;
    }
}
