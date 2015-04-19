package model.ability;

import model.entity.Entity;

public class ConeOfCold extends AngularAbility
{
    private int damage;
    // private String type;

    public ConeOfCold()
    {
        this.damage = 90;
        this.setCost(1);
        this.setLevelRequirement(5);
        this.setName("Frostbolt");
        this.setRadius(3);
    }

    public ConeOfCold(String name, int cost, int levelRequirement, int radius, int damage)
    {
        super(name, cost, levelRequirement, radius);
        setName(name);
        setCost(cost);
        setLevelRequirement(levelRequirement);
        setRadius(radius);
        setDamage(damage);
    }

    public int getDamage()
    {
        return damage;
    }

    public void setDamage(int damage)
    {
        this.damage = damage;
    }

    public String getType()
    {
        return type;
    }

    @Override
    public boolean use(Entity caster, Entity)
    {
        return true; //temporary
    }
    @Override
    public boolean inRadius(){
        return true; //temporary
    }


}
