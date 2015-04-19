package model.gameMap;


import model.entity.Entity;

public class Trap extends AreaEffect{

    public Trap(String name){
        super(name);
    }

    @Override
    public void applyEffect(Entity e){
        //TODO
    }
    public String getName(){
        return name;
    }
}
