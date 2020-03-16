package hw1v2;

import java.util.Map;


import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.HashMap;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

public class ReservationProgram {
    public static String[] sec = { "m", "sb", "wb", "eb" };
    public static String[] main = new String[150];
    public static String[] southBalcony = new String[50];
    public static String[] westBalcony = new String[100];
    public static String[] eastBalcony = new String[100];
    
    public static LocalDate start = LocalDate.of(2020, 12, 23);
    public static LocalDate end = LocalDate.of(2021, 1, 3);
    
    public static LocalTime time1 = LocalTime.of(18, 30);
    public static LocalTime time2 = LocalTime.of(20, 30);
    
    

    static List<LocalDate> dates = start.datesUntil(end).collect(Collectors.toList());
    static List<String> timeShow = new ArrayList<String>();

    public static Map<String, Integer> seatMap = new HashMap<String, Integer>();
    public static Map<String, String> seatAvailability = new HashMap<String, String>();
    
    public static Map<LocalDate,String> DateTime6 = new HashMap<LocalDate,String>();
    public static Map<LocalDate,String> DateTime8 = new HashMap<LocalDate,String>();
    
    public static Map<Map<LocalDate,String>,Map<String,Boolean>> seatDateTime6 = new HashMap<Map<LocalDate,String>,Map<String,Boolean>>();
    public static Map<Map<LocalDate,String>,Map<String,Boolean>> seatDateTime8 = new HashMap<Map<LocalDate,String>,Map<String,Boolean>>();

    public static CreateSeats seat = new CreateSeats();
    private static Scanner scanner = new Scanner(System.in);
    

    public static void run(String user) {
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("hh:mma");
        timeShow.add(0,time1.format(pattern));
        timeShow.add(1,time2.format(pattern));
        setDateandTime();
        
        
        
        
        boolean dateandTime = true;
        while(dateandTime) {
        System.out.println("Please enter your desired date(year-month-date in YYYY-MM-DD) and time(6:30PM or 8:30PM) of the show:");
        System.out.println("Date:");
        String selectedDate = scanner.next();
        System.out.println("Time:");
        String selectedTime = scanner.next();
        LocalDate selectDate = LocalDate.parse(selectedDate);
        
        
        try {
        if(!dates.contains(selectDate) || timeShow.contains(selectedTime) == false) {
            System.out.println("Date or Time Entered Invalid. Try Again!");
            dateandTime = true;
        }
        else if(dates.contains(selectDate)){
            setTheSeats();
            createTheSeats(selectDate,selectedTime);
            dateandTime = false;
        }
        }
        catch(DateTimeParseException e) {
            System.err.println("Wrong Format, please try again!");
            dateandTime = true;
        }
        }
        
        boolean seatSelect = true;
        String[] seatChoices = new String[20];
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
                    if(seatAvailability.get(seatSelection) != null) {
                        System.out.println("Seat taken please try again");
                        seatSelect = true;
                        seatConfirm = false;
                    }
                    System.out.println("Seat " + seatSelection
                            + " added to the reservation. Would you like to add another selection?");
                    String choice = scanner.next();
                    if (choice.equalsIgnoreCase("Yes")) {
                        seatSelect = true;
                        seatConfirm = false;
                    } else if (choice.equalsIgnoreCase("No")) {
                        seatSelect = false;
                        seatConfirm = false;
                        for(int a=0;i<seatChoices.length;i++) {
                            seatAvailability.replace(seatChoices[a], user);
                        }
                        break;
                    } else {
                        System.out.println("Invalid answer, please try again!");
                        seatConfirm = true;
                    }
                }

            }
        }
 
    }

    public static void createTheSeats(LocalDate date, String time) {
        seat.createTheSeats(sec[0], main, seatMap, 35, date, time);
        seat.createTheSeats(sec[1], southBalcony, seatMap, 50, date, time);
        seat.createTheSeats(sec[2], westBalcony, seatMap, 40, date, time);
        seat.createTheSeats(sec[3], eastBalcony, seatMap, 40, date, time);
        
    }
    
    public static void setDateandTime() {
        for(int i=0;i<dates.size();i++) {
            DateTime6.put(dates.get(i), timeShow.get(0));
        }
        for(int i=0;i<dates.size();i++) {
            DateTime8.put(dates.get(i), timeShow.get(1));
        }
    }
    
    public static void setTheSeats() {
        for(int i = 0;i<main.length;i++) {
            seatAvailability.put(main[i],"");
        }
        for(int i = 0;i<southBalcony.length;i++) {
            seatAvailability.put(southBalcony[i],"");
        }
        for(int i = 0;i<westBalcony.length;i++) {
            seatAvailability.put(westBalcony[i],"");
        }
        for(int i = 0;i<eastBalcony.length;i++) {
            seatAvailability.put(eastBalcony[i],"");
        }
        System.out.println(seatAvailability);
    }

    public static void checkReservation() {
        
    }

    public static void cancelReservation() {
        boolean input = true;
        while(input)
        System.out.println("Please enter the date(year-month-date in YYYY-MM-DD) and time (hour:minute(am/pm)) of the show:");
        System.out.println("Date:");
        String selectedDate = scanner.next();
        System.out.println("Time:");
        String selectedTime = scanner.next();
        
        LocalDate selectDate = LocalDate.parse(selectedDate);
        if(dates.contains(selectDate) == false || timeShow.contains(selectedTime) == false) {
            input = true;
        }
        else {
            input = false;
            checkReservation();
        }
        
    }

    public boolean checkDiscountDate(LocalDate date) {
        
        LocalDate date1 = LocalDate.of(2020, 12, 26);
        LocalDate date2 = LocalDate.of(2020, 12, 27);
        if (date == date1 || date == date2) {
            return true;
        } else {
            return false;
        }
    }

}
