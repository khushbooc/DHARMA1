package model.ability;
import model.entity.Entity;

public abstract class RadialAbility extends RadiusAbility
{
	private int degree;

	public RadialAbility()
	{
		super();
		degree = 360;
//		radius = 1;
	}

	public RadialAbility(String name, int cost, int levelRequirement, int degree, int radius)
	{
		super(name, cost, levelRequirement, radius);
		this.degree = degree;
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

	public abstract void use();

	public abstract void scaleEffect(Entity entity);
	
	@Override
	public boolean inRadius(Entity avatar, Entity entity)
	{
//		Location aLx = avatar.getLocation().getX();
//		Location eLx = entity.getLocation().getX();
//
//		Location aLy = avatar.getLocation().getY();
//		Location eLy = entity.getLocation().getY();
//
//		boolean inRadius = Math.pow(eLx - aLx,2) + Math.pow(eLy - aLy, 2) <= Math.pow(radius,2);

//		if(inRadius)
//			return true;
//		else
//			return false;
        return true; //temporarily only
	}
}