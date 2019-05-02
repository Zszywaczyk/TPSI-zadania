package tpsi.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "PersonListServlet", urlPatterns = {"/personList"})
public class PersonListServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Piotrek", "Karny", "Karny@edu.pl"));
        personList.add(new Person("Zenek", "Martyniuk", "ma@zut.pl"));
        personList.add(new Person("Norberd", "Malecki", "nm@zut.pl"));
        personList.add(new Person("Jacek", "Kowal", "jk@zut.pl"));
        personList.add(new Person("Marek", "Jankowski", "mj@zut.pl"));
        personList.add(new Person("Zofia", "Lapa", "zl@zut.pl"));

        request.setAttribute("Persons", personList);
        request.setAttribute("japko", "japko");
        request.getRequestDispatcher("personList.jsp").forward(request,response);
    }
    /*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }*/
}
