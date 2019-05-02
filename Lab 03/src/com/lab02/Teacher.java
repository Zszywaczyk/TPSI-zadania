package com.lab02;

public class Teacher extends Person{

    private String courseName;

    public Teacher(String firstName,String lastName, String emailAddress, String courseName){
        super(firstName, lastName, emailAddress);
        this.courseName = courseName;
    }
    @Override
    public String toString(){
        String text;
        text = "\t\t"+super.getFirstName()+" "+super.getLastName();
        return text;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
