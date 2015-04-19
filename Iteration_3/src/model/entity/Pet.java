package model.entity;

import model.entity.NPC;
import model.inventory.EquipmentContainer;
import model.inventory.Inventory;
import model.occupation.Occupation;

public abstract class Pet extends NPC {

    public Pet(Occupation oc, Inventory inv, EquipmentContainer eq) {
        super(oc, inv, eq);
    }

}
