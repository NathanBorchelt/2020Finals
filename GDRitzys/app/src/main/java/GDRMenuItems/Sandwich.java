package GDRMenuItems;

import java.util.ArrayList;

public class Sandwich extends GDRMenuItems.MenuItem {
    private ArrayList<String> toppings;
    public Sandwich(String name,double cost){
        super(name,cost);
    }
    public Sandwich(String name, double cost, boolean combo){
        super(name,cost);
        this.setCombo(combo);
    }
    public Sandwich(String name, double cost, ArrayList<String> toppings){
        super(name,cost);
        this.toppings = toppings;
    }
}
