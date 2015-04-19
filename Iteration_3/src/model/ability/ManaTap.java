package model.ability;

import model.entity.Entity;

/**
 *
 * @author Aaron_Iglesias
 */
public class ManaTap extends SelfAbility
{
    public ManaTap()
    {
        setName("Mana Tap");
        setBase(0);
        setCost(0);
        setLevelRequirement(2);
        setEffect(0);
    }

    public ManaTap(String name, int cost, int levelRequirement, int effect)
    {
        super(name, cost, levelRequirement, effect);
    }

    @Override
    private void scaleEffect(Entity avatar)
    {
        int randNum;
        int damage;
        double base, avatarCrit, criticalBonus, modifier, skill;

        skill = avatar.getBoon();
        avatarCrit = (int) Math.pow(2,avatar.getCritical());

        randNum = (int) random(1,16 / avatarCrit);

        if(randNum == 1)
            criticalBonus = 1.5;
        else
            criticalBonus = 1;

        modifier = criticalBonus * (1 + 0.5 * skill / 125);
        damage = (int) Math.floor((avatar.getMaxMana() / 2) * modifier);

        setEffect(damage);
    }

    @Override
    public void use(Entity avatar)
    {
        int cost = getCost();
        cost = avatar.getMaxMana / 2;

        if(avatar.getCurrentMana() < cost)
            return;

        else
        {
            scaleEffect(avatar);
            setCost((int) avatar.getMaxMana() / 2);
            avatar.modCurrentMana(-cost);
            avatar.modCurrentHealth(effect);
        }
    }

}