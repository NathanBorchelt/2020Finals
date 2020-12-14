package GDRMenuItems;

public class Sandwich extends MenuItem{
    public Sandwich(String name,double cost){
        super(name,cost);
    }
    public Sandwich(String name, double cost, boolean combo){
        super(name,cost);
        this.setCombo(combo);
    }
}
