package com.lab02;

import java.util.ArrayList;
import java.util.List;

public class University implements EmailRecipient{

    private String emailAdress;
    private String name;
    private List<Faculty> faculties = new ArrayList<>();

    public University(String name, String emailAdress){
        this.emailAdress = emailAdress;
        this.name = name;
    }
    @Override
    public String getEmailAddress(){
        return emailAdress;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }
    public void addFaculty(Faculty faculty){
        faculties.add(faculty);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString(){
        String text="";
        text+="Uniwersytet: "+name+"\n"+"Email: "+emailAdress+"\n";
        text+="\tWydziały: \n";
        for (Faculty faculty : faculties){
            text+=faculty.toString()+"\n";
        }
        return text;
    }
}
