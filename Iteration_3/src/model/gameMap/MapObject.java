package model.gameMap;


import java.util.Observable;

public abstract class MapObject extends Observable{
    protected Location location;

    public MapObject(Location location){
        this.location = location;
    }

    public Location getLocation(){
        return this.location;
    }
    public void setLocation(Location location){
        this.location = location;
    }

    public void setLocation(int x, int y){
        this.location = new Location(x,y);
    }


}
