package tpsi.labs.lab2;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*Person p1 = new Person("Bill", "Gates");
        Person p2 = new Person("Gal", "Anonim");

        System.out.println(p1.toString());
        System.out.println(p2.toString());*/

        University zut = new University("Zachodniopomorski Uniwersystet Technologiczny w Szczecinie", "zut@zut.edu.pl");
        University wsks = new University("Wyższa Szkoła Kosmetologii Stosowanej w Koluszkach", "wsks@wsks.edu.pl");
        Person s1 = new Student("Jan", "Kowalski", "jkowalski@wi.zut.edu.pl", "32A");
        Person s2 = new Student("Hermenegilda", "Nowak", "henowak@wi.zut.edu.pl", "32A");
        Person t1 = new Teacher("Bjarne", "Stroustrup", "bjarne@fake.org", "Introduction to C++");

        EmailRecipient[] spamList = new EmailRecipient[5];
        spamList[0] = zut;
        spamList[1] = wsks;
        spamList[2] = s1;
        spamList[3] = s2;
        spamList[4] = t1;

        for (EmailRecipient recipient : spamList){
            String email = recipient.getEmailAddress();
            System.out.println(email);
        }
        Student student= new Student("Bartek","Kowal","bk@bk.com","32F");
        addGrades(student);
        for(double single : student.getGrades()){
            System.out.println(single);
        }
        System.out.printf("%.3f",student.getGradesAverage());
        System.out.print("\n\n");

        Faculty[] faculties = new Faculty[5];
        faculties[0] = new Faculty("Wydzial Informatyki ZUT", "inf@zut.pl");
        faculties[1] = new Faculty("Wydzial Biotechnologii ZUT", "bio@zut.pl");
        faculties[2] = new Faculty("Wydzial Nanotechnologii ZUT", "nano@zut.pl");
        faculties[3] = new Faculty("Wydzial Informatyki WSKS", "inf@wsks.pl");
        faculties[4] = new Faculty("Wydzial Biotechnologii WSKS", "bio@wsks.pl");

        Teacher[] teachers = new Teacher[5];
        teachers[0] = new Teacher("Bjarne", "Stroustrup", "bjarne@fake.org", "Introduction to C++");
        teachers[1] = new Teacher("Bjarne1", "Stroustrup1", "bjarne@fake.org1", "Introduction to C++1");
        teachers[2] = new Teacher("Bjarne2", "Stroustrup2", "bjarne@fake.org2", "Introduction to C++2");
        teachers[3] = new Teacher("Bjarne3", "Stroustrup3", "bjarne@fake.org3", "Introduction to C++3");
        teachers[4] = new Teacher("Bjarne4", "Stroustrup4", "bjarne@fake.org4", "Introduction to C++4");

        faculties[0].addTeacher(teachers[0]); faculties[0].addTeacher(teachers[3]); faculties[0].addTeacher(teachers[4]);
        faculties[1].addTeacher(teachers[1]); faculties[1].addTeacher(teachers[2]);
        faculties[2].addTeacher(teachers[1]);
        faculties[3].addTeacher(teachers[4]);faculties[3].addTeacher(teachers[3]);
        faculties[4].addTeacher(teachers[2]);

        zut.addFaculty(faculties[0]);
        zut.addFaculty(faculties[1]);
        zut.addFaculty(faculties[2]);
        wsks.addFaculty(faculties[3]);
        wsks.addFaculty(faculties[4]);

        System.out.println(zut.toString()+"\n\n");
        System.out.println(wsks.toString());

    }

    public static void addGrades(Student student){
        student.addGrades(5);
        student.addGrades(3);
        student.addGrades(2);
        student.addGrades(2.5);
        student.addGrades(4);
        student.addGrades(4.5);
        student.addGrades(5);
    }
}
