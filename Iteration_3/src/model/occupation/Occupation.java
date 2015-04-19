package model.occupation;


import utilities.SpriteSheetUtility;
import model.ability.AbilityLibrary;
import model.statistics.Stats;
import utilities.SpriteSheetUtility;

public abstract class Occupation {
	 private AbilityLibrary abilitylibrary ;
	 protected Stats stat;
	 protected SpriteSheetUtility spritesheet;
	 public Occupation()
	 {
		 //To do Nothing will remove later when ability library is created
	 }
	 public Occupation (AbilityLibrary abilitylibrary, Stats stat)
	 {
		 this.abilitylibrary = abilitylibrary;
		 this.stat = stat;
	 }
	 
	 public AbilityLibrary getAbilityLibrary(){
		 return abilitylibrary;
	 }
	 public Stats getStats(){
		 return stat;
	 }
		public abstract SpriteSheetUtility getSpriteSheet();
}
