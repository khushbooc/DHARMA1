package model.statistics;
public class SneakStats extends Stats
{
	private int pickPocket;
	private int detectRemoveTrap;
	private int creep;
	private int rangedWeapon;

	public SneakStats()
	{
		super();
		pickPocket = 1;
		detectRemoveTrap = 1;
		creep = 1;
		rangedWeapon = 1;
	}

	@Override
	public void levelUp()
	{
		modLevel(1);
		modStrength(3);
		modAgility(4);
		modIntellect(3);
		modHardiness(3);
		modMovement(3);
		modSkillPoints(5);
	}

	public void modPickPocket()
	{
//		if(skillPoints <= 0)
//			return;
//		--skillPoints;
//		++oneHandedWeapon;
	}

	public void modDetectRemoveTrap()
	{
//		if(skillPoints <= 0)
//			return;
//		--skillPoints;
//		++twoHandedWeapon;
	}

	public void modCreep()
    {
//		if(skillPoints <= 0)
//			return;
//		--skillPoints;
//		++brawling;
	}

	public void modRangedWeapon()
	{
//		if(skillPoints <= 0)
//			return;
//		--skillPoints;
//		++rangedWeapon;
	}
}