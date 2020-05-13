package hw3;

import java.util.ArrayList;
import java.util.Scanner;

public class DeepCopy implements Cloneable{
    
    private ArrayList<Employee> employeeList;
    
    public DeepCopy(ArrayList<Employee> employeeList) {
        this.employeeList = employeeList;
    }
    
    public void addToArray() {
        Scanner scanner = new Scanner(System.in);
        String name;
        int id;
        
        for(int i=0;i<3;i++) {
            System.out.println("Enter Employee Name:");
            name = scanner.nextLine();
            System.out.println("Enter Employee ID:");
            id = Integer.parseInt(scanner.nextLine());
            employeeList.add(new Employee(name,id));
        }
        

    }
    
    public ArrayList<Employee> clone() throws CloneNotSupportedException{
        ArrayList<Employee> clone1 = new ArrayList<Employee>();
        for(int i=0;i<employeeList.size();i++) {
            clone1.add(employeeList.get(i));
        }
        return clone1;
    }
}
