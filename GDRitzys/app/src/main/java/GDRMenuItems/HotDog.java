package GDRMenuItems;

public class HotDog extends MenuItem{
    public HotDog(String name,double cost){
        super(name,cost)
    }
    public HotDog(String name, double cost, boolean combo){
        super(name, cost);
        this.setCombo(combo);
    }
}
