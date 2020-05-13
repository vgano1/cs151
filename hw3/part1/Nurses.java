package hw3;

public class Nurses extends Employee{
    
    private int nurseID;
    private String name;
    private boolean nurseStatus;
    
    public Nurses(String name, int nurseID, boolean nurseStatus) {
        super(name,nurseID);
        this.name = name;
        this.nurseID = nurseID;
        this.nurseStatus = nurseStatus;
    }
    
    public boolean isANurse() {
        return nurseStatus;
    }
}
