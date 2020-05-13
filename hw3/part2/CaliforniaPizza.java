package hw3;

public class CaliforniaPizza extends Pizza{

    @Override
    public void makeCrust() {
        System.out.println("This method makes the crust for the California Pizza");
        
    }

    @Override
    public void addToppings() {
        System.out.println("This method adds the toppings for the California Pizza");
        
    }

    @Override
    public void preHeatOven() {
        System.out.println("This method preheats the Oven for the California Pizza");
        
    }

    @Override
    public void cook() {
        System.out.println("This method cooks the California Pizza in the Oven");
        
    }

}
