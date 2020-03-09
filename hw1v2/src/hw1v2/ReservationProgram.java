package hw1v2;

import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.HashMap;
import java.time.LocalDate;
import java.util.List;

public class ReservationProgram {
    public static String[] sec = { "m", "sb", "wb", "eb" };
    public static String[] main = new String[150];
    public static String[] southBalcony = new String[50];
    public static String[] westBalcony = new String[100];
    public static String[] eastBalcony = new String[100];

    public static LocalDate start = LocalDate.of(2020, 12, 23);
    public static LocalDate end = LocalDate.of(2021, 1, 3);

    static List<LocalDate> dates = start.datesUntil(end).collect(Collectors.toList());
    static ArrayList<String> timeShow = new ArrayList<String>();

    public static Map<String, Integer> seatMap = new HashMap<String, Integer>();
    public static Map<String, Boolean> seatAvailability = new HashMap<String, Boolean>();

    public static CreateSeats seat = new CreateSeats();
    private static Scanner scanner = new Scanner(System.in);

    public static void run() {
        if (main.length == 0 || southBalcony.length == 0 || westBalcony.length == 0 || eastBalcony.length == 0) {
            createTheSeats();
        }
        timeShow.add("6:30pm");
        timeShow.add("8:30pm");
        boolean dateandTime = true;
        while(dateandTime) {
        System.out.println("Please enter your desired date(year-month-date) and time(hour:minute(am/pm)) of the show:");
        System.out.println("Date:");
        String selectedDate = scanner.next();
        System.out.println("Time:");
        String selectedTime = scanner.next();
        
        if(!dates.contains(selectedDate) || !timeShow.contains(selectedTime)) {
            System.out.println("Date or Time Entered Invalid. Try Again!");
            dateandTime = true;
        }
        else {
            dateandTime = false;
        }
        }
        

        boolean seatSelect = true;
        String[] seatChoices = new String[400];
        while (seatSelect) {
            for (int i = 0; i <= seatChoices.length; i++) {
                System.out.println("Please select the following seats:");
                System.out.println("Main Floor Left(m1-50), Main Floor Right(m50-100) = $35");
                System.out.println("Main Floor(m100-150) = $45");
                System.out.println("South Balcony(sb1-25) = $50");
                System.out.println("South Balcony(sb25-50) = $55");
                System.out.println("West Balcony(wb1-100) = $40");
                System.out.println("East Balcony(eb1-100) = $40");
                String seatSelection = scanner.next();
                seatChoices[i] = seatSelection;
                boolean seatConfirm = true;
                while (seatConfirm) {
                    System.out.println("Seat" + seatSelection
                            + " added to the reservation. Would you like to add another selection?");
                    String choice = scanner.next();
                    if (choice == "Yes") {
                        seatSelect = true;
                        seatConfirm = false;
                    } else if (choice == "No") {
                        seatSelect = false;
                        seatConfirm = false;
                        break;
                    } else {
                        System.out.println("Invalid answer, please try again!");
                        seatConfirm = true;
                    }
                }
            }
        }

    }

    public static void createTheSeats() {
        seat.createTheSeats(sec[0], main, seatMap, 35);
        seat.createTheSeats(sec[1], southBalcony, seatMap, 50);
        seat.createTheSeats(sec[2], westBalcony, seatMap, 40);
        seat.createTheSeats(sec[3], eastBalcony, seatMap, 40);
    }

    public static void checkReservation() {

    }

    public static void cancelReservation() {
        System.out.println("Please enter the date(year-month-date) and time (hour:minute(am/pm)) of the show:");
        System.out.println("Date:");
        String selectedDate = scanner.next();
        System.out.println("Time:");
        String selectedTime = scanner.next();
    }

    public boolean checkDiscount(String aDate, int numofSeats) {
        String discountDate1 = "2020-12-26";
        String discountDate2 = "2020-12-27";
        if (aDate == discountDate1 || aDate == discountDate2) {
            return true;
        } else if (numofSeats >= 5) {
            return true;
        } else {
            return false;
        }
    }

}
