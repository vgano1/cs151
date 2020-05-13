package hw3;

public class Patient implements Hospital{
    
    private int patientID;
    private String name;
    private int age;
    private String address;
    private String role;
    private Receptionist receptioner;
    private Nurses nurse;
    private Doctors doctor;
    private boolean sickStatus;
    
    public Patient(String name, int patientID, int age, String address, Receptionist receptioner, Nurses nurse, Doctors doctor, boolean sickStatus) {
        this.name = name;
        this.patientID = patientID;
        this.age = age;
        this.address = address; 
        this.receptioner = receptioner;
        this.nurse = nurse;
        this.doctor = doctor;
        this.sickStatus = sickStatus;
        role = "Patient";
    }

    @Override
    public String getRole() {
        return role;
    }

    @Override
    public Boolean isAWorker() {
        if(role == "Patient") {
            return false;
        }
        else {
            return true;
        }
    
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getID() {
        return patientID;
    }
    
    public boolean isSick() {
       return sickStatus;
    }
    
    public int getAge() {
        return age;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void checkDoctor() {
        System.out.println("Doctor: " + doctor.getName());
    }
    
    public void checkReceptionist() {
        System.out.println("Receptionist: " + receptioner.getName());
    }
    
    public void checkNurse() {
        System.out.println("Nurse: " + nurse.getName());
    }    
    
}
