package hw1v2;
import java.util.Map;
import java.io.File;
import java.util.HashMap;
import java.util.Scanner;


public class TheaterReservationSystem {
    private final static String prompt1 = "Welcome to the Theater Reservation System. Please select the following options to get started:";
    private final static String menu1= "Sign [U]p   Sign [I]n   E[X]it";
    private final static String menu2 = "[R]eserve  [V]iew  [C]ancel    [O]ut  ";
    private final static String prompt2 = "User ID or Password invalid, please try again!";
    private final static String prompt3 = "Please enter your User ID and Password:";
    private final static String prompt4 = "Please enter a unique User ID and password:";
    private final static String prompt5 = "The User ID that you entered is already taken! Please try again:";
    private static Scanner scanner;
    
    public static Map<String,String> userData = new HashMap<String,String>();
    public static String user = "";
    public static String pass = "";
    public static Users user1 = new Users(user,pass,userData);
    
    
    public static File f = new File("C:\\Users\\vitog\\OneDrive\\Documents\\Eclipse Workspace\\hw1v2\\reservation.txt");
            
    
    public static void main(String[]args) {
        
        try {
            File f = new File("C:\\Users\\vitog\\OneDrive\\Documents\\Eclipse Workspace\\hw1v2\\reservation.txt");
            if(!f.isFile()) {
                f.createNewFile();
            }
            loginMenu();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public static void loginMenu() {
        boolean menuLoop = true;
        boolean optionLoop = false;
        while(menuLoop) {
            scanner = new Scanner(System.in);
            System.out.println(prompt1);
            System.out.println(menu1);
            
            char c = scanner.next().charAt(0);
            do {
            switch(c) {
            case 'u':
            case 'U':
                    System.out.println(prompt4);
                    System.out.println("User ID:");
                    user = scanner.next();
                    System.out.println("Password:");
                    pass = scanner.next();
                    if(user1.checkUsers(user,pass) == false) {
                        user1.addUsers(user, pass, userData);
                        System.out.println("Account Successfully Created!");
                        optionLoop = true;
                    }
                    else {
                        System.out.println(prompt5);
                        optionLoop = false;
                    }
                    break;
            case 'i':
            case 'I':
                System.out.println(prompt3);
                System.out.println("User ID:");
                user = scanner.next();
                System.out.println("Password:");
                pass = scanner.next();
                if(user1.checkUsers(user, pass) == true) {
                    System.out.println("Login Success!");
                    optionLoop = true;
                    mainMenu();
                    menuLoop = false;
                }
                else {
                    System.out.println(prompt2);
                    optionLoop = false;
                }
                break;
            case 'X':
            case 'x':
                System.exit(0);
            default:
                System.out.println("Input character, please try again!");
                optionLoop = true;
        }
            }while(!optionLoop);
    }
    
    }
    
    public static void mainMenu() {
        boolean menuLoop = true;
        boolean optionLoop = false;
        while(menuLoop) {
        System.out.println("Welcome "+user+", Please select the following options to get started:");
        System.out.println(menu2);
        
        char c = scanner.next().charAt(0);
        do {
            switch(c) {
            case 'r':
            case 'R':
                ReservationProgram.run(user);
                optionLoop = true;
                break;
            case 'v':
            case 'V':
                optionLoop = false;
                break;
            case 'c':
            case 'C':
                ReservationProgram.cancelReservation();
                optionLoop = true;
                break;
            case 'O':
            case 'o':
                System.out.println("Thank you for using our ticket reservation system! Have a wonderful day!");
                optionLoop = true;
                loginMenu();
                menuLoop = false;
            }
            
        }while(!optionLoop);
        
    }
    }
}
