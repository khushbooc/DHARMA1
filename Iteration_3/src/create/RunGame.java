package create;

import javax.swing.*;

import controller.ViewController;

public class RunGame {
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //new GameMap();
            	new ViewController();
            }
        });
//        Summoner summoner = new Summoner();
//        SpriteSheetUtility image = summoner.getSpritz
    }

}
