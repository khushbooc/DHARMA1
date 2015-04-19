package model.ability;
public class Frostbolt extends LinearAbility
{
	private int damage;
	// private String type;

	public Frostbolt()
	{
		this.damage = 90;
		this.setCost(1);
		this.setLevelRequirement(1);
		this.setName("Frostbolt");
		this.setRadius(100);

		// this.type = "bane";

//		this.type = "bane";

	}

	public Frostbolt(String name, int cost, int levelRequirement, int radius, int damage)
	{
        super(name, cost, levelRequirement, radius);
        setName(name);
        setCost(cost);
        setLevelRequirement(levelRequirement);
        setRadius(radius);
        setDamage(damage);
		this.damage = damage;
	}

	public int getDamage()
	{
		return damage;
	}

	public void setDamage(int damage)
	{
		this.damage = damage;
	}



	/*
	public String getType()
	{
		return type;
	}
	*/
    @Override
	public boolean use(){
        return true; //temporary
    }
    @Override
    public boolean inRadius(){
        return true; //temporary
    }


}