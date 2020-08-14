package Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/example-post"})
public class ExamplePost extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String color = req.getParameter("color");
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("<h1> The select color is: ");
        writer.println(color);
        writer.println("</h1>\n Method:POST ");
        writer.close();
    }
}
