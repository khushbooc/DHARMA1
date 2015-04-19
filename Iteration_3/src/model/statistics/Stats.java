package model.statistics;

public abstract class Stats
{
	// primary stats
	private int lives;
	private int strength;
	private int agility;
	private int intellect;
	private int hardiness;
	private int movement;
    private int experience; // Giang added to avoid compile error
    private int critical;

	// derived stats
	private int level;
	private int maxHealth;
	private int currentHealth;
	private int maxMana;
	private int currentMana;
	private int maxExp;
	// private int currentExp;
	// private int remainderExp;
	private int offense;
	private int defense;
	private int armor;
    private int maxmana; //Giang: added to avoid compile error

	// general skills
	protected int bindWounds;
	protected int bargain;
	protected int observation;

	// skill points to spend on level up
	private int skillPoints;

	public Stats()
	{
		lives = 3;
		strength = 1;
		agility = 1;
		intellect = 1;
		hardiness = 1;
		movement = 1;

		level = 1;

		maxHealth = 5;
		currentHealth = 5;

		maxMana = 5;
		currentMana = 5;

		maxExp = 1250000;
		currentExp = 0;

		offense = 1; // derived from strength and equipment
		defense = 1; // derived from agility
		armor = 1; // derived from hardiness and equipment
	}

	public void modLives(int n)
	{
		lives = adjust(lives + n);
	}

	public int getLives()
	{
		return lives;
	}

	public void setLives(int lives)
	{
		this.lives = adjust(lives);
	}

	public void modStrength(int n)
	{
		strength = adjust(strength + n);
		offense = offense + n;
	}

	public int getStrength()
	{
		return strength;
	}

	public void setStrength(int strength)
	{
		this.strength = adjust(strength);
	}

	public void modAgility(int n)
	{
		agility = adjust(agility + n);
		defense = defense + n;
	}

	public int getAgility()
	{
		return agility;
	}

	public void setAgility(int agility)
	{
		this.agility = adjust(agility);
	}

	public void modIntellect(int n)
	{
		intellect = adjust(intellect + n);
	}

	public int getIntellect()
	{
		return intellect;
	}

	public void setIntellect(int intellect)
	{
		this.intellect = adjust(intellect);
	}

	public void modHardiness(int n)
	{
		hardiness = adjust(hardiness + n);
		armor = armor + n;
	}

	public int getHardiness()
	{
		return hardiness;
	}

	public void setHardiness(int hardiness)
	{
		this.hardiness = adjust(hardiness);
	}

	public void modExperience(int n)
	{
		if(level == 100)
			return;
		else
		{
			experience = experience + n;
			if(experience > 999)
			{
				int levelCount = experience / 999;
				experience = experience % 999;
				for(int i = 0; i < levelCount; ++i)
				{
					levelUp();
					if(level == 100)
						return;
				}
			}
		}
	}

	public int getExperience()
	{
		return experience;
	}

	public void setExperience(int experience)
	{
		this.experience = experience;
	}

	public int getCritical()
	{
		return critical;
	}

	public void setCritical(int critical)
	{
		if(critical < 0 || critical > 3)
			return;
		else
			this.critical = critical;
	}

	public void modCritical(int n)
	{
		boolean tooLow = critical + n < 0;
		boolean tooHigh = critical + n > 3;

		if(tooLow || tooHigh)
			return;
		else
			critical = critical + n;
	}

	public void modMovement(int n)
	{
		movement = adjust(movement + n);
	}

	public int getMovement()
	{
		return movement;
	}

	public void setMovement(int movement)
	{
		this.movement = adjust(movement);
	}

	public void modLevel(int n)
	{
		level = adjust(level + n);
	}

	public int getLevel()
	{
		return level;
	}

	public void setLevel(int level)
	{
		this.level = adjust(level);
	}

	public void modMaxHealth(int n)
	{
		maxHealth = adjust(maxHealth + n);
	}

	public int getMaxHealth()
	{
		return maxHealth;
	}

	public void setMaxHealth(int maxHealth)
	{
		this.maxHealth = adjust(maxHealth);
	}

	public void modCurrentHealth(int n)
	{
		currentHealth = adjust(currentHealth + n);
	}

	public int getCurrentHealth()
	{
		return currentHealth;
	}

	public void setCurrentHealth(int currentHealth)
	{
		this.currentHealth = adjust(currentHealth);
		if(this.currentHealth > this.maxHealth)
			this.currentHealth = this.maxHealth;
	}

	public void modMaxMana(int n)
	{
		maxMana = adjust(maxMana + n);
	}

	public int getMaxMana()
	{
		return maxMana;
	}

	public void setMaxMana(int maxMana)
	{
		this.maxmana = adjust(maxMana);
	}

	public void currentMana(int n)
	{
		currentMana = adjust(currentMana + n);
	}

	public int getCurrentMana()
	{
		return currentMana;
	}

	public void setCurrentMana(int currentMana)
	{
		this.currentMana = adjust(currentMana);
		if(this.currentMana > this.maxMana)
			this.currentMana = this.maxMana;
	}

	public void modCurrentMana(int n)
	{
		boolean tooLow, tooHigh;

		tooLow = currentMana + n < 0;
		tooHigh = currentMana + n > maxMana;

		if(tooLow)
		{
			currentMana = 0;
			return;
		}
		if(tooHigh)
		{
			currentMana = maxMana;
			return;
		}
		
	}

	public void modSkillPoints(int n)
	{
		skillPoints = adjust(skillPoints + n);
	}

	public int getSkillPoints()
	{
		return skillPoints;
	}

	public void setSkillPoints(int skillPoints)
	{
		this.skillPoints = adjust(skillPoints);
	}

	public void modBindWounds()
	{
		if(skillPoints <= 0 || bindWounds >= 999)
			return;
		++bindWounds;
		--skillPoints;
	}

	public int getBindWounds()
	{
		return bindWounds;
	}

	public void setBindWounds(int bindWounds)
	{
		this.bindWounds = adjust(bindWounds);
	}

	public void modBargain()
	{
		if(skillPoints <= 0 || bargain >= 999)
			return;
		++bargain;
		--skillPoints;
	}

	public int getBargain()
	{
		return bargain;
	}

	public void setBargain(int bargain)
	{
		this.bargain = adjust(bargain);
	}

	public void modObservation()
	{
		if(skillPoints <= 0 || observation >= 999)
			return;
		++observation;
		--skillPoints;
	}

	public int getObservation()
	{
		return observation;
	}

	public void setObservation(int observation)
	{
		this.observation = adjust(observation);
	}

	// helper method to ensure no stat is below 0 or above 999
	public int adjust(int n)
	{
		if(n < 0)
			return 0;
		else if(n > 999)
			return 999;
		else
			return n;
	}

	// to be overwritten
	public abstract void levelUp();
}