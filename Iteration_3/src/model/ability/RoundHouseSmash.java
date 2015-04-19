package model.ability;

import model.entity.Entity;

public class RoundHouseSmash extends RadialAbility
{
    private int damage;
    // private String type;

    public RoundHouseSmash()
    {
        this.damage = 90;
        this.setCost(1);
        this.setLevelRequirement(10);
        this.setName("Round House Smash");
        this.setRadius(2);
    }

    public RoundHouseSmash(String name, int cost, int levelRequirement, int radius, int damage)
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

    @Override
    public void use(Entity avatar, Entity entity)
    {
        // for(all entities on map)
        if(!inRadius(avatar, entity) || avatar == entity)
            continue; // do nothing
        else // do damage
        {
            scaleEffect(avatar, entity);
            entity.modHealth(-effect);
        }
    }

    @Override
    private void scaleEffect(Entity avatar, Entity entity)
    {
        int critical;
        int damage;
        double base, avatarCrit, random, criticalBonus, modifier, offense, defense, level, skill;

        level = avatar.getLevel();
        offense = avatar.getBoon();
        defense = entity.getArmor();
        skill = avatar.getBoon();
        avatarCrit = (int) Math.pow(2,avatar.getCritical());

        random = (double) random(85,100) / 100;
        critical = (int) random(1,16 / avatarCrit);

        if(critical == 1)
            criticalBonus = 1.5;
        else
            criticalBonus = 1;

        modifier = random * criticalBonus * (1 + 0.5 * skill / 125);

        damage = (int) Math.floor(((2 * level + 10) / 250 * offense / defense * base + 2) * modifier);

        setEffect(damage);
    }

}