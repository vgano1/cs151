package hw3;

public class ChicagoPizza extends Pizza{

    @Override
    public void makeCrust() {
        System.out.println("This method makes the crust for the Chicago Pizza");
        
    }

    @Override
    public void addToppings() {
        System.out.println("This method adds the toppings for the Chicago Pizza");
        
    }

    @Override
    public void preHeatOven() {
        System.out.println("This method preheats the Oven for the Chicago Pizza");
        
    }

    @Override
    public void cook() {
        System.out.println("This method cooks the Chicago Pizza in the Oven");
        
    }


}
