package model.inventory;

import model.gameMap.TakeDamage;

/**
 * Created by giangnguyen on 4/17/15.
 */
public class Inventory {
    private TakeableItem[] takeableItems;
    private int firstFreeSlot;
    int count;

    public Inventory(){
        takeableItems = new TakeableItem[15];
        firstFreeSlot = 0;
        count = 0;
    }

    public int getFirstFreeSlot(){
        return firstFreeSlot;
    }

    public int getCount(){
        return count;

    }
    public int getSize(){
        return takeableItems.length;
    }
    public boolean add(TakeableItem ti){
        if(firstFreeSlot == takeableItems.length){ // the inventory is full
            return false;
        }
        takeableItems[firstFreeSlot] = ti;
        ++count;
        //updating firstFreeSlot
        for (int i = firstFreeSlot + 1; i < takeableItems.length; ++i){
            if(takeableItems[i] == null) {
                firstFreeSlot = i;
                return true;
            }
        }
        firstFreeSlot = takeableItems.length;
        return true;
    }

    public TakeableItem getItem(int index){
        return takeableItems[index];
    }

    public boolean remove(TakeableItem ti){
        for(int i = 0; i < takeableItems.length; ++i){
            if(takeableItems[i] == ti){
                takeableItems[i] = null;
                --count;
                if(i < firstFreeSlot) {
                    firstFreeSlot = i;
                }
                return true;
            }
        }
        return false;
    }

    public boolean remove(int index){
        if(index == firstFreeSlot) {
            return false;
        }
        takeableItems[index] = null;
            --count;

        if (index < firstFreeSlot){
            firstFreeSlot = index;
        }
        return true;
    }
}
