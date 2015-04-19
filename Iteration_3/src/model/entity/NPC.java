package model.entity;

import model.ability.Ability;
import model.inventory.EquipableItem;
import model.inventory.EquipmentContainer;
import model.inventory.Inventory;
import model.inventory.TakeableItem;
import model.occupation.Occupation;

public abstract class NPC extends Entity {
	public NPC(Occupation occupation, Inventory inventory, EquipmentContainer equicontainer) {
        super(occupation, inventory, equicontainer);

    }
    @Override
    public abstract Occupation getOccupation();

    @Override
    public abstract Inventory getInventory();

    @Override
    public abstract EquipmentContainer getEquipmentContainer();
    @Override
    public abstract void addToInventory(TakeableItem takeableitem);
    @Override
    public abstract void equipItem(EquipableItem equiItem);
    @Override
    public abstract void removeItem(TakeableItem ti);
    @Override
    public abstract void unequipItem(EquipableItem eqi);
    @Override
    public abstract void useAbility(Ability ability);


}

