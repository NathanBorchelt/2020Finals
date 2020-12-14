package GDRMenuItems;

public abstract class MenuItem implements Upcharge {
    private double cost;
    private String itemName;
    private boolean combo;
    private double upchargeCost;
    private String upDesciption;

    public MenuItem(String name, double cost){
        this.combo=false;
        this.cost = cost;
        this.itemName=name;
    }


    public boolean isCombo() {
        return combo;
    }
    public double getCost() {
        return cost;
    }
    public String getItemName() {
        return itemName;
    }
    public void setUpcharge(double upcharge){
        this.upchargeCost = upcharge;
    }
    public void setUpDesc(String upDesc){
        this.upDesciption = upDesc;
    }
    public double upchargeCost() {
        return upchargeCost;
    }
    public String upchargeDescription() {
        return upDesciption;
    }
}