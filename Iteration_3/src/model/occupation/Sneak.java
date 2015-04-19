package model.occupation;

import model.ability.*;
import model.statistics.Stats;
import utilities.SpriteSheetUtility;

public class Sneak extends Occupation {
	private AbilityLibrary abl;
	private Stats stat;
	public Sneak(){
		
	}

    public Sneak(AbilityLibrary abilityLibrary, Stats stats) {
        //TODO
        super(abilityLibrary, stats);
    }
	public SpriteSheetUtility getSpriteSheet() {
		return new SpriteSheetUtility(this);
	}

}
