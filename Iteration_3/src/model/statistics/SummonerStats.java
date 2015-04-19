package model.statistics;
public class SummonerStats extends Stats
{
	private int enchantment;
	private int boon;
	private int bane;
	private int staff;

	public SummonerStats()
	{
		super();
		enchantment = 1;
		boon = 1;
		bane = 1;
		staff = 1;
	}

	@Override
	public void levelUp()
	{
		modLives(1);
		modStrength(3);
		modAgility(3);
		modIntellect(4);
		modHardiness(3);
		modMovement(3);
		modSkillPoints(5);
	}

	public void modEnchantment()
	{
//		if(skillPoints <= 0)
//			return;
//		--skillPoints;
//		++enchantment;
	}

	public void modBoon()
	{
//		if(skillPoints <= 0)
//			return;
//		--skillPoints;
//		++boon;
	}

	public void modBane()
	{
//		if(skillPoints <= 0)
//			return;
//		--skillPoints;
//		++bane;
	}

	public void modStaff()
	{
//		if(skillPoints <= 0)
//			return;
//		--skillPoints;
//		++staff;
	}
}