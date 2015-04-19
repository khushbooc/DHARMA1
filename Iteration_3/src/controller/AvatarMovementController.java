package controller;

import java.awt.Point;



import model.entity.Avatar;
import model.gameMap.GameMap;

public class AvatarMovementController extends MovementController {
	private Avatar avatar;
	public AvatarMovementController(Avatar avatar,GameMap mapView){
		this.avatar=avatar;
		this.mapView = mapView;
	}
	public void move(Point step, int direction) {
		avatar.setDirection(direction);
		mapView.update(step);

	}

}
