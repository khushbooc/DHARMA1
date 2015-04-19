package view;

import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import model.gameMap.GameMap;
import model.Location;
import model.entity.Avatar;

public class GameView extends JPanel{
	GameMap map;
	Avatar avatar;
	EntityView entityView;
	BufferedImage image;
	MapView mapView;
	
	public GameView(GameMap map, Avatar avatar, Location location){
		if (location == null) location = new Location(3, 3);
		this.map = map;
		this.avatar = avatar;
		entityView=new EntityView(avatar);
		 this.mapView= new MapView(this.map,entityView,avatar);
		add(this.mapView);
		setView();
		this.map.updateEntityLocation(avatar, location);// NOT NEEDED ANYMORE
		image=avatar.getImage();
	}

}
