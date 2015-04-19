package controller;

import java.awt.Point;

import model.gameMap.GameMap;

public abstract class MovementController {
	public static final Point NORTH = new Point(0,-1);
	public static final Point SOUTH = new Point(0,1);
	public static final Point SOUTHWEST = new Point(-1,1);
	public static final Point NORTHWEST = new Point(-1,-1);
	public static final Point WEST = new Point(-1,0);
	public static final Point NORTHEAST = new Point(1,-1);
	public static final Point SOUTHEAST = new Point(1,1);
	public static final Point EAST = new Point(1,0);
	protected GameMap mapView;
	
	public abstract void move(Point step, int direction);

}