package tpsi.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "HelloServlet", urlPatterns = {"/hello"})
public class HelloServlet extends HttpServlet {
    /*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }*/

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*response.setContentType("txt/html;charset=UTF-8");
        try(PrintWriter out = response.getWriter()) {
            String imie = request.getParameter("imie");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Java Web - laboratorium 4</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Cześć, " + imie + "!</h1>");
            out.println("</body>");
            out.println("</html>");
        }*/

        /*String imie = request.getParameter("imie");
        request.setAttribute("imie", imie);
        request.getRequestDispatcher("hello.jsp").forward(request,response);*/
        test1(request, response);
        zad1(request, response);

    }
    private void zad1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("Person", new Person(
                request.getParameter("imie"),
                request.getParameter("nazwisko"),
                request.getParameter("email")
        ));
        request.getRequestDispatcher("hello.jsp").forward(request,response);
    }
    private void test1(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException{
        List<String> dni = new ArrayList<>();
        dni.add("Poniedziałek");
        dni.add("Wtorek");
        dni.add("Środa");
        dni.add("Czwartek");
        dni.add("Piątek");
        request.setAttribute("dniTygodnia", dni);
    }
}
