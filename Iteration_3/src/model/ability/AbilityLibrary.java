package model.ability;

import java.util.ArrayList;
import java.util.List;

import model.ability.Ability;
import model.entity.Entity;

/*
 * @author Aaron Iglesias
 */
public abstract class AbilityLibrary {
    private ArrayList<Ability> learnedAbilities;
    private ArrayList<Ability> unlearnedAbilities;

    private Entity avatar;

    public AbilityLibrary(Entity myEntity){
        learnedAbilities = new ArrayList<Ability>();
        unlearnedAbilities = new ArrayList<Ability>();
        owner = myEntity;
        this.addToLibrary(new BasicAttack());
        this.addToLibrary(new HealAbility());
    }

    protected void addAbility(Ability ability){
        learnedAbilities.add(ability);
        unlearnedAbilities.remove(ability);
    }

    protected void addToLibrary(Ability ability){
        learnedAbilities.add(ability);
    }

    protected boolean removeFromLibrary(Ability ability){
        return (learnedAbilities.remove(ability) || unlearnedAbilities.remove(ability));
    }

    public boolean hasAbility(String abilityName){
        for(Ability s : learnedAbilities) {
            if (abilityName.equals(s.getName())) {
                return true;
            }
        }
        return false;
    }
    
    public boolean performActiveAbility(String abilityName, Entity callingEntity){
        for(Ability a : learnedAbilities) {
            if (a.getName().equals(abilityName)) {
                a.performAbility(callingEntity);
                return true;
            }
        }
        return false;
    }

    public void update(){
        for (Ability ability : unlearnedAbilities){
            if (ability.meetsStatRequirements(owner)){
                addAbility(ability);
            }
        }
    }

    public boolean performActiveAbility(int position, Entity callingEntity){
        position = position -1;
        if(position >= learnedAbilities.size())
            return false;
        learnedAbilities.get(position).performAbility(callingEntity);
        return true;
    }

    public List<Ability> getAbilities() {
        return this.learnedAbilities;
    }
}
