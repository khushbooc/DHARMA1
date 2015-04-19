package model.gameMap;

import java.awt.image.BufferedImage;

/**
 * Created by giangnguyen on 4/16/15.
 */
public class Water extends Terrain {

    public Water(String name,BufferedImage img){
        super(name,img);
    }
    @Override
    public boolean isPassable(){
        return false;
    }

    String getName(){
        return name;
    }
}
