package view;

import java.util.Observer;

import javax.swing.JComponent;

import model.gameMap.GameMap;
import model.Location;
import model.entity.Avatar;

public class MapView extends JComponent implements Observer{
	private Avatar avatar;
	 private GameMap map;
	private EntityView entityView;
	private TileView[][] tiles;
	 public void setMap(GameMap map){
     	this.map=map;
     	this.setTileComponents();
     	this.repaint();
     }
	 public MapView(GameMap map, EntityView entityView, Avatar avatar) {
         this.map = map;
         this.entityView = entityView;
         this.avatar = avatar;
         this.setTileComponents();
 }
	 void setTileComponents(){
         
         this.tiles = new TileView[map.getMapLength().getY()][map.getMapLength().getX()];
         for(int i = 0;i < this.map.getMapLength().getY();i++){
                 for(int j = 0; j < this.map.getMapLength().getX();j++){
                         this.tiles[i][j] = new TileView(map.getTile(new Location(j,i)));
                 }
         }
 }
	 public GameMap getMap(){
     	return this.map;
     }
}
