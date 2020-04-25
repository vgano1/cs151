package hw2;

import java.util.*;

@SuppressWarnings("deprecation")
public class DataModel extends Observable{
    
    private ArrayList<Integer> data;
    
    public DataModel() {
        data = new ArrayList<Integer>();
    }
    
    public ArrayList<Integer> getDataList(){
        return data;
    }
    
    public int getDataSize() {
        return data.size();
    }
    
    public int getData(int index) {
        return data.get(index);
    }
    
    public void addValue(int value) {
        data.add(value);
        setChanged();
        notifyObservers();
    }
    
    public void modifyValue(int index, int value) {
        data.set(index, value);
        setChanged();
        notifyObservers();
    }
    
}