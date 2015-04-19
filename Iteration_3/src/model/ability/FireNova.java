package model.ability;

import model.entity.Entity;

public class FireNova extends RadialAbility {
    private int base;
    // private String type;

    public FireNova()
    {
        this.base = 90;
        this.setCost(1);
        this.setLevelRequirement(2);
        this.setName("Fire Nova");
        this.setRadius(3);
    }

    public FireNova(String name, int cost, int levelRequirement, int radius, int damage)
    {
        super(name, cost, levelRequirement, radius);
        setName(name);
        setCost(cost);
        setLevelRequirement(levelRequirement);
        setRadius(radius);
        setBase(damage);
    }

    public int getBase();
    {
        return base;
    }

    public void setBase(int damage)
    {
        this.base = damage;
    }

    @Override
    public void use(Entity avatar, Entity entity)
    {
        if(avatar.getMana() - this.cost < 0)
            return;

        // for(all entities on map)
        if(!inRadius(avatar, entity) || avatar == entity)
            continue; // do nothing
        else // do damage
        {
            scaleEffect(avatar, entity);
            entity.modHealth(-effect);
            entity.modMana(-cost);
        }
    }

    @Override
    private void scaleEffect(Entity avatar, Entity entity)
    {
        int critical;
        int damage;
        double base, avatarCrit, random, criticalBonus, modifier, offense, defense, level, skill;

        Stats stats = avatar.getSummonerStats();

        level = stats.getLevel();
        offense = stats.getBoon();
        defense = stats.getArmor();
        skill = stats.getBoon();
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
