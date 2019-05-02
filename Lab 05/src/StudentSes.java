import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

import static java.util.Objects.isNull;

@WebServlet(name = "StudentSes", urlPatterns = {"/"})
public class StudentSes extends HttpServlet {



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ArrayList<Student> students;
        Integer counter;
        if(isNull((ArrayList<Student>) session.getAttribute("Students"))) {
            students = new ArrayList<Student>();
        }
        else{
            students = (ArrayList<Student>) session.getAttribute("Students");
        }

        if(!isNull(session.getAttribute("counter")) ){
            counter = (int)session.getAttribute("counter");
            counter++;
        }
        else {
            counter = 1;
        }

        if(!isNull(request.getParameter("name")) && !isNull(request.getParameter("surname")) && !isNull(request.getParameter("email"))
                && !request.getParameter("name").isEmpty() && !request.getParameter("surname").isEmpty() && !request.getParameter("email").isEmpty()) {
            students.add(new Student(request.getParameter("name"), request.getParameter("surname"), request.getParameter("email")));
        }
        session.setAttribute("counter", counter);
        session.setAttribute("Students", students);
        request.getRequestDispatcher("index.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        session.isNew();
        Integer counter;
        ArrayList<Student> students;

        if(isNull(session.getAttribute("counter"))){
            counter=1;
        }
        else {
            counter= (int)session.getAttribute("counter");
            counter++;
        }

        if(isNull((ArrayList<Student>)session.getAttribute("Students"))){
            students = new ArrayList<>();
        }
        else {
            students = (ArrayList<Student>)session.getAttribute("Students");
        }
        session.setAttribute("Students", students);
        session.setAttribute("counter",counter);

        /*if(session.isNew()){
            counter=1;
            students = new ArrayList<>();
            *//*students.add(new Student("Piotrek", "Karny", "Karny@edu.pl"));
            students.add(new Student("Zenek", "Martyniuk", "ma@zut.pl"));
            students.add(new Student("Norberd", "Malecki", "nm@zut.pl"));
            students.add(new Student("Jacek", "Kowal", "jk@zut.pl"));
            students.add(new Student("Marek", "Jankowski", "mj@zut.pl"));
            students.add(new Student("Zofia", "Lapa", "zl@zut.pl"));*//*
        }
        else {
            counter= (int)session.getAttribute("counter");
            counter++;
            students = (ArrayList<Student>)session.getAttribute("Students");
            session.setAttribute("Students", students);
        }
        session.setAttribute("counter",counter);*/




        //request.setAttribute("int2", i);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    //processRequest


}
