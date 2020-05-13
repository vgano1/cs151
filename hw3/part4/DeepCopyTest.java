package hw3;

import java.util.ArrayList;
import java.util.Collections;

public class DeepCopyTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        ArrayList<Employee> list = new ArrayList<Employee>();
        DeepCopy copyTest = new DeepCopy(list);
        
        copyTest.addToArray();
        
        ArrayList<Employee> listCopy = copyTest.clone();
        Collections.sort(list, new compareName());
        
        System.out.println("Employee ArrayList Cloned:" );
        for(int i=0;i<listCopy.size();i++) {
            System.out.println("Name: " + listCopy.get(i).getName());
            System.out.println("ID Number: " + listCopy.get(i).getId());
        }
        
        System.out.println("\nEmployee ArrayList After Sorted:" );
        for(int i=0;i<list.size();i++) {
            System.out.println("Name: " + list.get(i).getName());
            System.out.println("ID Number: " + list.get(i).getId());
        }
        
    }
}
