package hw3;

public abstract class Pizza {
    
    public final void makeFromScratch() {
        makeCrust();
        addToppings();
        preHeatOven();
        cook();
    }
    
    public abstract void makeCrust();
    public abstract void addToppings();
    public abstract void preHeatOven();
    public abstract void cook();
}
