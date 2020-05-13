package hw3;

public class Receptionist extends Employee{
    
    private String name;
    private int receptionID;
    private boolean receptionistStatus;
    
    public Receptionist(String name, int receptionID, boolean receptionistStatus) {
        super(name, receptionID);
        this.name = name;
        this.receptionID = receptionID;
        this.receptionistStatus = receptionistStatus;
    }
    
    public boolean isAReceptionist() {
        return receptionistStatus;
    }
    
}
