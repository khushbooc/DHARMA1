package model.inventory;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by giangnguyen on 4/17/15.
 */
public class EquipmentContainer extends Observable {
    EquipableItem[] equipmentList;
    int count;
    int firstFreeSlot;

    public EquipmentContainer(){
        equipmentList = new EquipableItem[16];
        firstFreeSlot = 0;
        count = 0;
    }

    public int getCount(){
        return count;
    }

    public int getSize(){
        return equipmentList.length;
    }

    public int getFirstFreeSlot(){
        return firstFreeSlot;
    }

    public EquipableItem getItem(int index){
        return equipmentList[index];
    }

    public boolean add(EquipableItem eqItem){
        if(firstFreeSlot == equipmentList.length)
            return false;
        equipmentList[firstFreeSlot] = eqItem;
        ++count;
        for (int i = firstFreeSlot + 1; i < equipmentList.length; ++i){
            if(equipmentList[i] == null){
                firstFreeSlot = i;
                return true;
            }
        }
        firstFreeSlot = equipmentList.length;
        return true;

    }

    public boolean remove(EquipableItem eqItem){
        for(int i = 0; i < equipmentList.length; ++i){
            if(equipmentList[i] == eqItem){
                equipmentList[i] = null;
                --count;
                if(i < firstFreeSlot){
                    firstFreeSlot = i;
                }
                return true;
            }
        }
        return false;
    }

    public boolean remove(int index){
        if(equipmentList[index] == null){
            return false;
        }
        equipmentList[index] = null;
        if(index == firstFreeSlot){
            firstFreeSlot = index;
        }
        return true;
    }


}

