package Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/cookie_servlet"})
public class CookieServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String data = req.getParameter("data");
        Cookie cookie = new Cookie("MyCookie", data);
        resp.addCookie(cookie);

        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("<h1> The cookies is: ");
        writer.println(data);
        writer.println("</h1>\n Method:POST ");
        writer.close();
    }
}
