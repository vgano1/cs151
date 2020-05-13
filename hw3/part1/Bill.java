package hw3;

public class Bill {
    private int billNum;
    private Patient patient;
    
    public Bill(Patient patient, int billNum) {
        this.patient = patient;
        this.billNum = billNum;
    }
    
    public String checkBillOwner(Patient patient, int billNum) {
        return patient.getName();
    }
    public void setBill(Patient patient, int billNum){
        this.billNum = billNum;
    }
    public int getBill() {
        return billNum;
    }
}
