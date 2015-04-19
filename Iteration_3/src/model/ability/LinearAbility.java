package model.ability;
public abstract class LinearAbility extends RadiusAbility
{
	private int radius;
    //add to avoid error
    private int degree;

	public LinearAbility()
	{
		super();
		radius = 1;
	}

	public LinearAbility(String name, int cost, int levelRequirement, int radius)
	{
		super(name, cost, levelRequirement, radius);
//		this.radius = radius;
	}

	public int getDegree()
	{
		return degree;
	}

	public void setDegree(int degree)
	{
		this.degree = degree;
	}

	public abstract boolean use();
}