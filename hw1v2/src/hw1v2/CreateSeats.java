package hw1v2;
import java.util.Map;

public class CreateSeats{
    
    public void createTheSeats(String sections, String[] sectionseatNum, Map<String,Integer> seatPrice, int price) {
            SeatCompiler seat = new SeatCompiler(sections,sectionseatNum);
            seat.createSeats(sections, sectionseatNum);
            seat.setPrice(sections, sectionseatNum, seatPrice, price);
    }
    
}
