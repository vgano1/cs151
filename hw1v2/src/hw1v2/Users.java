package hw1v2;

import java.util.Map;
import java.util.HashMap;

public class Users {
    private String userID;
    private String password;
    
    private Map<String,String> userMap = new HashMap<String,String>();
    
    public Users(String userID,String password,Map<String,String> userMap){
        this.userID = userID;
        this.password = password;
        this.userMap = userMap;
    }
    
    public void setUser(String userID) {
        this.userID = userID;
    }
    
    public void setPass(String password) {
        this.password = password;
    }
    
    public void setUserMap(Map<String,String> userMap) {
        this.userMap = userMap;
    }
    
    public String getUser() {
        return userID;
    }
    
    public String getPass() {
        return password;
    }
    
    public Map<String,String> getUserMap(Map<String,String> userMap){
        return userMap;
    }
    
    public void addUsers(String userID, String password, Map<String,String> userMap) {
        userMap.put(userID,password);
    }
    
    
    public boolean checkUsers(String userID, String password) {
        if(!userMap.containsKey(userID)||!userMap.containsValue(password)) {
            return false;
        }
        else if(userMap.containsKey(userID)&&userMap.containsValue(password)){
            return true;
        }
        else if(!userMap.containsKey(userID)&&!userMap.containsValue(password)){
            return true;
        }
        else {
            return false;
        }
    }
}
