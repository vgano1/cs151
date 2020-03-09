package hw1v2;

public class SectionandSeatNumber {
    private String section;
    private int seatNum;
    
    public SectionandSeatNumber(String section, int seatNum){
        this.setSection(section);
        this.setSeatNum(seatNum);
    }

    public int getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(int seatNum) {
        this.seatNum = seatNum;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }
    
    
}
