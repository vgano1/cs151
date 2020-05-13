package hw3;

public class Employee implements Hospital{
    private int idNum;
    private String name;
    private String role;
    
    public Employee(String name, int idNum) {
        this.name = name;
        this.idNum = idNum;
        role = "Employee";
    }

    @Override
    public String getRole() {
        return role;
    }

    @Override
    public Boolean isAWorker() {
        if(role == "Employee") {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getID() {
        return idNum;
    }

}
