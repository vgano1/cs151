package hw1v2;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class SeatCompiler {
    private int seatCount1 = 150;
    
    private String seatSection = "";
    private String [] seatSections;
    
    private Map<String, Integer> seatPrice = new HashMap<String,Integer>();
    private LocalDate date;
    private String time;
    
    public SeatCompiler(String seatSection, String [] seatSections, LocalDate date, String time) {
        this.setSeatSection(seatSection);
        this.setSeatSections(seatSections);
        this.setDate(date);
        this.setTime(time);
    }

    public String getSeatSection() {
        return seatSection;
    }

    public String setSeatSection(String seatSection) {
        this.seatSection = seatSection;
        return seatSection;
    }

    public String [] getSeatSections() {
        return seatSections;
    }

    public void setSeatSections(String [] seatSections) {
        this.seatSections = seatSections;
    }
    
    public Map<String, Integer> getSeatPrice() {
        return seatPrice;
    }

    public void setSeatPrice(Map<String, Integer> seatPrice) {
        this.seatPrice = seatPrice;
    }
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    
    
    public void createSeats(String seatSection, String[] seatSections){
        if(seatSection == "m") {
            for(int i=0;i<seatCount1;i++) {
                seatSections[i] = seatSection+(i+1);
            }
        }
        else if(seatSection == "sb") {
            for(int i=0;i<seatCount1-100;i++) {
                seatSections[i] = seatSection+(i+1);
            }
        }
        else {
            for(int i=0;i<seatCount1-50;i++) {
                seatSections[i] = seatSection+(i+1);
            }
        }
    }
    public void setPrice(String seatSection, String [] seatSections, Map<String,Integer> seatPrice, int price) {
        if(seatSection == "m") {
            for(int i=0;i<seatCount1-50;i++) {
                seatPrice.put(seatSections[i], price);
            }
            for(int i=seatCount1-50;i<seatCount1;i++) {
                seatPrice.put(seatSections[i], price+10);
            }
        }
        else if(seatSection == "sb") {
            for(int i=0;i<seatCount1-125;i++) {
                seatPrice.put(seatSections[i], price);
            }
            for(int i=seatCount1-125;i<seatCount1-100;i++) {
                seatPrice.put(seatSections[i], price+5);
            }
        }
        else {
            for(int i=0;i<seatCount1-50;i++) {
                seatPrice.put(seatSections[i], price);            }
        }
    }


    
}
