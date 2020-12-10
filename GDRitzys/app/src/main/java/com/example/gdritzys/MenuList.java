package main.java.com.example.gdritzys;

import java.awt.MenuItem;
import java.util.ArrayList;

public class MenuList{
    private ArrayList<MenuItem> allSelectedMenuItems;
    public MenuList(){
        this.allSelectedMenuItems = new ArrayList<>();
    }
    public void addItem(MenuItem menuItem){
        allSelectedMenuItems.add(menuItem);
    }
    public MenuItem getSingleItem(int index){
        return allSelectedMenuItems.get(index);
    }
    public ArrayList<MenuItem> getTotalList(){
        return allSelectedMenuItems;
    }
    public void removeItem(MenuItem menuItem){
        allSelectedMenuItems.remove(menuItem);
    }
    public void removeItem(int index){
        allSelectedMenuItems.remove(index);
    }
    public double totalCost(){
        double itemTotal;
        for(MenuItem menuItem : allSelectedMenuItems){
            itemTotal += menuItem.getCost();
        }
        return itemTotal;
    }
    public ArrayList<String> getAllItemNames(){
        ArrayList<String> allItemNames = new ArrayList<>();
        for(MenuItem menuItem : allItemNames){
            allItemNames.add(menuItem.getItemName());
        }
        return allItemNames;
    }


}