package Servlets;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = {"/main/*","/getpost"})
public class MainServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("Method: service -> enter\n");
        super.service(req, resp);
        resp.getWriter().write("Method: service -> end\n");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        log("Method: init");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uriRequest = req.getRequestURI();
        String uriParameter = formatParameters(req);

        resp.getWriter().write("Method: Get");
        resp.getWriter().write("\n------------------\nREQUEST URI: " + uriRequest);
        resp.getWriter().write("\nREQUEST PARAMETERS:\n------------------\n" + uriParameter + "\n------------------\n");
//        log("Send HTML page to user");//ONLY FOR JETTY --> web.xml add servlet on line:

//        System.out.println("REQUEST URI: " + uriRequest);
//        System.out.println("------------------\nREQUEST PARAMETERS:\n------------------\n" + uriParameter + "\n------------------\n");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uriRequest = req.getRequestURI();
        String uriParameter = formatParameters(req);

        resp.getWriter().write("Method: Post");
        resp.getWriter().write("\n------------------\nREQUEST URI: " + uriRequest);
        resp.getWriter().write("\nREQUEST PARAMETERS:\n------------------\n" + uriParameter + "\n------------------\n");
    }

    private String formatParameters(HttpServletRequest req) {
        return req.getParameterMap()
                .entrySet()
                .stream()
                .map(entry -> {
                    String parameter = String.join(", ", entry.getValue());
                    return " " + entry.getKey() + ": " + parameter;
                }).collect(Collectors.joining("\n"));
    }

    @Override
    public void destroy() {
        destroy();
        log("Method: destroy");

    }
}
