package model.entity;

import model.ability.Ability;
import model.inventory.EquipableItem;
import model.inventory.EquipmentContainer;
import model.inventory.Inventory;
import model.inventory.TakeableItem;
import model.occupation.Occupation;

public class Avatar extends Entity {
	
	public Avatar(Occupation occupation){
		super(occupation);
	}

	public Avatar(Occupation occupation, Inventory inventory,
			EquipmentContainer equicontainer) {
		super(occupation, inventory, equicontainer);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Occupation getOccupation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Inventory getInventory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EquipmentContainer getEquipmentContainer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addToInventory(TakeableItem takeableitem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void equipItem(EquipableItem equiItem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeItem(TakeableItem ti) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unequipItem(EquipableItem eqi) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void useAbility(Ability ability) {
		// TODO Auto-generated method stub
		
	}
	

}
