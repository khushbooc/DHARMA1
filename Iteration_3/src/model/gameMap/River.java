package model.gameMap;

import java.awt.image.BufferedImage;

/**
 * Created by giangnguyen on 4/16/15.
 */
public class River extends Terrain {

    public River(String name,BufferedImage img){
        super(name,img);
    }
    @Override
    public boolean isPassable(){
        return true;
    }

    String getName(){
        return name;
    }

    public void affectEntity(){
        //TODO
    }

}
