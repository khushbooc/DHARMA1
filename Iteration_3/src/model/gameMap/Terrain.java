package model.gameMap;

import java.awt.image.BufferedImage;


public abstract class Terrain {
    protected String name;
    protected BufferedImage img;
    public Terrain(String name,BufferedImage img){
        this.name  = name;
        this.img   = img;
    }
    public abstract boolean isPassable();
    protected BufferedImage getImage(){
    	return this.img;
    }

}
