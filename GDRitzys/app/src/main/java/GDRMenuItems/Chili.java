package GDRMenuItems;

public class Chili extends MenuItem{
    public Chili(String name,double cost){
        super(name, cost);
    }
    public Chili(String name, double cost, boolean combo){
        super(name, cost);
        this.setCombo(combo);
    }
}
