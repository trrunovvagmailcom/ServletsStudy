package Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
@WebServlet(urlPatterns = {"/tracking"})
public class Tracking extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        Date date = (Date) session.getAttribute("date");
        if (date != null) {
            writer.print("Last access: " + date + "<br>");
        }

        date = new Date();
        session.setAttribute("date", date);
        writer.println("Current date:" + date);
    }
}
