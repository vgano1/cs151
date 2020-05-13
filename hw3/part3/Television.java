import java.util.Scanner;

public class Television{
    private static Scanner scanner;

    public static void changeChannel(Channels c) {
        
        switch(c) {
        case ABC:
            System.out.println("Changed to "+c+ " Channel "+ c.getChannel()+ "! The Best of the Best!");
            break;
        case FOX:
            System.out.println("Changed to "+c+ " Channel "+ c.getChannel()+ "! Where the FOX Goes!");
            break;
        case KQED:
            System.out.println("Changed to "+c+ " Channel "+ c.getChannel()+ "! Very Informational!");
            break;
        case KRON:
            System.out.println("Changed to "+c+ " Channel "+ c.getChannel()+ "! The Prime Time of the Bay!");
            break;
        case NBC:
            System.out.println("Changed to "+c+ " Channel "+ c.getChannel()+ "! The National Prime Time!");
            break;
        }
    }
    
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        String ch;
        boolean status=true;
        System.out.println("Please enter your desired channel:");
        while(status==true) {
            ch = scanner.nextLine().toUpperCase();
            try {
            Channels c =  Channels.valueOf(ch);
            status = false;
            changeChannel(c);
            }
            catch(IllegalArgumentException e) {
                System.err.println("Sorry, this channel doesn't exist! Please try again:");
            }
        
    }
    }
}