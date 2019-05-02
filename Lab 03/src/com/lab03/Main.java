package com.lab03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import com.lab02.*;

public class Main {

    public static void main(String[] args) {

        //test();
        zad1();
        System.out.println();
        System.out.println();
        zad2();
        //test2();
        System.out.println();
        System.out.println();
        zad3();
    }

    public static void zad1() {
        //Set<String> zbioryDni = new HashSet<>();
        Set<String> zbioryDni = new TreeSet<>();
        zbioryDni.add("poniedziałęk");
        zbioryDni.add("wtorek");
        zbioryDni.add("środa");
        zbioryDni.add("czwartek");
        zbioryDni.add("piątek");
        zbioryDni.add("sobota");
        zbioryDni.add("niedziela");
        System.out.println(zbioryDni);
        for (String single : zbioryDni) {
            System.out.println(single);
        }
    }

    public static void zad2() {
        Map<String, Teacher> teachersMap = new HashMap<>();
        Teacher teacher1 = new Teacher("Zenek", "Martyniuk", "ma@zut.pl", "programowanie obiektowe");
        Teacher teacher2 = new Teacher("Norberd", "Malecki", "nm@zut.pl", "hurtownie danych");
        Teacher teacher3 = new Teacher("Jacek", "Kowal", "jk@zut.pl", "projektowanie aplikacji");
        Teacher teacher4 = new Teacher("Marek", "Jankowski", "mj@zut.pl", "grafika komputerowa");
        Teacher teacher5 = new Teacher("Zofia", "Lapa", "zl@zut.pl", "szycie");

        teachersMap.put(teacher1.getCourseName(), teacher1);
        teachersMap.put(teacher2.getCourseName(), teacher2);
        teachersMap.put(teacher3.getCourseName(), teacher3);
        teachersMap.put(teacher4.getCourseName(), teacher4);
        teachersMap.put(teacher5.getCourseName(), teacher5);

        System.out.println("Programowania obiektowego uczy: " + teachersMap.get("programowanie obiektowe"));

        List<Student> gr32A = new ArrayList<>();
        List<Student> gr32B = new ArrayList<>();
        List<Student> gr32C = new ArrayList<>();
        List<Student> gr32D = new ArrayList<>();

        Student[] students = new Student[10];
        students[0] = new Student("Bjarne0", "Stroustrup0", "bjarne@fake.org0", "32A");
        students[1] = new Student("Bjarne1", "Stroustrup1", "bjarne@fake.org1", "32B");
        students[2] = new Student("Bjarne2", "Stroustrup2", "bjarne@fake.org2", "32C");
        students[3] = new Student("Bjarne3", "Stroustrup3", "bjarne@fake.org3", "32D");
        students[4] = new Student("Bjarne4", "Stroustrup4", "bjarne@fake.org4", "32A");
        students[5] = new Student("Bjarne5", "Stroustrup5", "bjarne@fake.org5", "32A");
        students[6] = new Student("Bjarne6", "Stroustrup6", "bjarne@fake.org6", "32B");
        students[7] = new Student("Bjarne7", "Stroustrup7", "bjarne@fake.org7", "32C");
        students[8] = new Student("Bjarne8", "Stroustrup8", "bjarne@fake.org8", "32D");
        students[9] = new Student("Bjarne9", "Stroustrup9", "bjarne@fake.org9", "32A");

        for (Student student : students) {
            switch (student.getGroupId()) {
                case "32A":
                    gr32A.add(student);
                    break;
                case "32B":
                    gr32B.add(student);
                    break;
                case "32C":
                    gr32C.add(student);
                    break;
                case "32D":
                    gr32D.add(student);
                    break;
            }
        }

        Map<String, List> studentsByGroups = new HashMap<>();
        studentsByGroups.put("32A", gr32A);
        studentsByGroups.put("32B", gr32B);
        studentsByGroups.put("32C", gr32C);
        studentsByGroups.put("32D", gr32D);

        //studentsByGroups.get("32A").
        System.out.println("Grupa 32A: " + studentsByGroups.get("32A"));
        //studentsByGroups.get("32A").get()
        /*for(Object object : studentsByGroups.get("32A")){
            object.
        }*/

    }

    public static void zad3() {
        List<Product> products = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\src\\com\\lab03\\produkty.txt"))) {
            String textLine = in.readLine();
            //int i=0;

            while (textLine != null) {
                //System.out.println(textLine);

                products.add(parseLine(textLine));

                textLine = in.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<Integer, Product> productById = new HashMap<>();
        Map<String, List<Product>> productByCategory = new HashMap<>();

        for (Product product : products) {
            productById.put(product.getId(), product);
        }
        System.out.println("Produkt z id=107: " + productById.get(107));

        Set<String> categories = new HashSet<>();

        for (Product product : products) {
            categories.add(product.getCategory());
        }
        //System.out.println(categories);

        for (Product p1 : products) {
            if (!productByCategory.containsKey(p1.getCategory())) {
                productByCategory.put(p1.getCategory(), new ArrayList<Product>());
                //productByCategory.put(p1.getCategory(),new ArrayList<Product>(Arrays.asList(p1.getId(),p1.getName(),p1.getPrice(),p1.getCategory())));
            }
            productByCategory.get(p1.getCategory()).add(p1);
        }
        //productByCategory
/*
        List<Product> temp = new ArrayList<>();
        for (String category : categories){
            for(Product product : products){
                if(product.getCategory().equals(category)){
                    temp.add(product);
                    //System.out.println(category+":  "+product.toString());
                }
            }
            productByCategory.put(category, temp);
            temp = new ArrayList<>();
        }*/
        System.out.println("Produkty z kategorią oprogramowanie: " + productByCategory.get("oprogramowanie"));
    }

    public static Product parseLine(String textToParse) {
        String[] parsedText = textToParse.split(";");
        //System.out.println("Id: "+parsedText[0]+"\t\tNazwa: "+parsedText[1]+"\t\tCena: "+parsedText[3]+"\t\tKategoria: "+parsedText[2]);
        return new Product(Integer.parseInt(parsedText[0]), parsedText[1], Double.parseDouble(parsedText[3]), parsedText[2]);
    }

    public static void test() {

        Map<String, String> dniTygodnia = new HashMap<>();
        dniTygodnia.put("pn", "poniedzialek");
        dniTygodnia.put("wt", "wtorek");
        dniTygodnia.put("śr", "środa");
        dniTygodnia.put("czw", "czwartek");
        System.out.println(dniTygodnia.get("pn"));

        for (String key : dniTygodnia.keySet()) {
            System.out.println(key + " - " + dniTygodnia.get(key));
        }

        Set<String> zbiorDni = new HashSet<>();
        zbiorDni.add("poniedziałek");
        zbiorDni.add("wtorek");
        zbiorDni.add("wtorek");
        zbiorDni.add("środa");
        System.out.println(zbiorDni);

        for (String dzien : zbiorDni) {
            System.out.println(dzien);
        }

    }

    public static void test2() {
        try (BufferedReader in = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\src\\com\\lab03\\plik.txt"))) {
            String s = in.readLine();
            while (s != null) {
                System.out.println(s);

                s = in.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println(System.getProperty("user.dir")+"\\plik.txt");
    }
}
