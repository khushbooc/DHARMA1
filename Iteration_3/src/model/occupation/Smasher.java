package model.occupation;

import model.ability.AbilityLibrary;
import model.statistics.Stats;
import utilities.SpriteSheetUtility;

public class Smasher extends Occupation {
	private AbilityLibrary abl;
	private Stats stat;

	public Smasher() {
		//super(this.abilitylibrary, this.stat);
		// TODO Auto-generated constructor stub
	}

	@Override
	public SpriteSheetUtility getSpriteSheet() {
		return new SpriteSheetUtility(this);
}
	
}
