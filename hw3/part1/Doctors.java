package hw3;

public class Doctors extends Employee{
    
    private int doctorID;
    private String name;
    private boolean doctorStatus;
    
    public Doctors(String name, int doctorID, boolean doctorStatus) {
        super(name,doctorID);
        this.name = name;
        this.doctorID = doctorID;
        this.doctorStatus = doctorStatus;
    }
    
    public boolean isADoctor() {
        return doctorStatus;
    }
}
