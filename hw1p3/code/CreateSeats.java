package hw1v2;
import java.time.LocalDate;
import java.util.Map;

public class CreateSeats{
    
    public void createTheSeats(String sections, String[] sectionseatNum, Map<String,Integer> seatPrice, int price, LocalDate date, String time) {
            SeatCompiler seat = new SeatCompiler(sections,sectionseatNum, date, time);
            seat.createSeats(sections, sectionseatNum);
            seat.setPrice(sections, sectionseatNum, seatPrice, price);
    }
    
}
