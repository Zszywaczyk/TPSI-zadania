package com.lab02;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person{

    private String groupId;
    private List<Double> grades = new ArrayList<>();

    public Student(String firstName, String lastName, String emailAddress, String groupId){
        super(firstName, lastName, emailAddress);
        this.groupId = groupId;
    }

    public Double getGradesAverage(){
        if(grades.size()==0){
            throw new ArithmeticException("Nie ma ocen, prawdopodobne dzielenie przez zero\n");
        }
        double sum=0;
        for (double single : grades)
            sum += single;
        if (sum<=0){
            throw new ArithmeticException("Dzielenie przez zero\n");
        }
        double resoult = sum/grades.size();

        return resoult;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public List<Double> getGrades() {
        return grades;
    }

    public void addGrades(double grade) {
        grades.add(grade);
    }
}
