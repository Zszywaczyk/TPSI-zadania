package com.lab02;

import java.util.ArrayList;
import java.util.List;

public class Faculty implements EmailRecipient{

    private List<Teacher> teachers = new ArrayList<>();
    private String facultyEmail;
    private String facultyName;

    public Faculty(String facultyName, String facultyEmail){
        this.facultyName = facultyName;
        this.facultyEmail = facultyEmail;
    }

    @Override
    public String getEmailAddress(){
        return facultyEmail;
    }

    @Override
    public String toString(){
        String text;
        text = "\t\t"+facultyName+"\t"+" Email: "+facultyEmail+"\n\t\t\t";
        for(Teacher teacher : teachers){
            text+=teacher.toString()+"\t";
        }
        return text;
    }

    public void addTeacher(Teacher teacher){
        teachers.add(teacher);
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }
}
