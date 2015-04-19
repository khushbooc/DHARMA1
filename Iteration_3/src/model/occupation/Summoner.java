package model.occupation;

import model.ability.AbilityLibrary;
import model.statistics.Stats;
import utilities.SpriteSheetUtility;

public class Summoner extends Occupation {
	private AbilityLibrary abl;
	private Stats stat;
	
	public Summoner(){
		
	}


    public Summoner(AbilityLibrary abilitylibrary, Stats stat) {
        super(abilitylibrary, stat);
        // TODO
    }
		
	
	public SpriteSheetUtility getSpriteSheet() {
		return new SpriteSheetUtility(this);
}

}
