package model.gameMap;

import model.entity.Avatar;
import model.occupation.Occupation;
import model.occupation.Summoner;



public class Game {

	Avatar avatar;

	public Game() {
		avatar = new Avatar(new Summoner());
		//Map<String, GameMap> maps = world.getMaps();
		//Set<String> mapNames = maps.keySet();
	}
	
	public Game(Avatar avatar) {
		this.avatar = avatar;
	}
	
	public Game(Occupation occupation, String name) {
		avatar = new Avatar(occupation);
		//build the Avatar equipment
		//avatar.setName(name);
	}
	public Avatar getAvatar() {
		return avatar;
	}
	public void setAvatar(Avatar avatar) {
		this.avatar = avatar;
	}
	
}

