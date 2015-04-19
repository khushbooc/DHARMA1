package model.ability;
public abstract class AngularAbility extends RadiusAbility
{
	private int degree;

	public AngularAbility()
	{
		super();
		degree = 90;
		setRadius(1);
	}

	public AngularAbility(String name, int cost, int levelRequirement, int degree, int radius)
	{
		super(name, cost, levelRequirement, radius);
		this.degree = degree;
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