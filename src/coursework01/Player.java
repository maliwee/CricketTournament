package coursework01;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private String teamName;
    private int age;
    private String role;
    private ArrayList<MatchRecord> records = new ArrayList<>();

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void addMatchRecord(MatchRecord record){
        records.add(record);
    }

    public int getTotalMarks(){
        int total = 0;
        for(MatchRecord m : records){
            total += m.getRuns();
        }
        return total;
    }

    public int getBoundariesCount(){
        int total = 0;
        for(MatchRecord m : records){
            total += m.getBoundaries();
        }
        return total;
    }

    public ArrayList<MatchRecord> getRecords(){
        return records;
    }
}
