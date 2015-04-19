package controller;
//this class shouldn't exist


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import utilities.Directions;
import view.View;
import model.entity.Avatar;
import model.gameMap.GameMap;

public class MapViewController {
	private GameMap map;
	private Avatar avatar;
	private boolean active;
	
	public MapViewController(Avatar avatar,GameMap map,JFrame frame){
		this.avatar=avatar;
		map=new GameMap(avatar,frame);
		active=true;
		frame.addKeyListener(new CharacterKeyboardController(avatar,map));
	}
	
	public View getView(){
		return map;
	}
	
public class CharacterKeyboardController implements KeyListener{

		private MovementController movement;
		
		public CharacterKeyboardController(Avatar avatar,GameMap map){
			this.movement = new AvatarMovementController(avatar,map);
			
		}
		
		
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			if(!active){
				return;
			}
			if(key == KeyEvent.VK_NUMPAD1){
				
				this.movement.move(MovementController.SOUTHWEST, Directions.SOUTHWEST);
			}
			else if(key == KeyEvent.VK_NUMPAD2){
				this.movement.move(MovementController.SOUTH, Directions.SOUTH);
			}
			else if(key==KeyEvent.VK_NUMPAD3){
				this.movement.move(MovementController.SOUTHEAST, Directions.SOUTHEAST);
			}
			//else if(key==KeyEvent.VK_NUMPAD6){
			//	this.movement.move(MovementController.EAST, Directions.EAST);
			//}
			else if(key==KeyEvent.VK_NUMPAD9){
				this.movement.move(MovementController.NORTHEAST, Directions.NORTHEAST);
			}
			else if(key==KeyEvent.VK_NUMPAD8){
				this.movement.move(MovementController.NORTH, Directions.NORTH);
			}
			else if(key==KeyEvent.VK_NUMPAD7){
				this.movement.move(MovementController.NORTHWEST, Directions.NORTHWEST);
			}
			//else if(key==KeyEvent.VK_NUMPAD4 ){
			//	this.movement.move(MovementController.WEST, Directions.WEST);
			//}
		}

		public void keyReleased(KeyEvent e) {}
		public void keyTyped(KeyEvent arg0) {}
		
	}

}

