import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Entrance extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String sessId = req.getSession().getId();

        PrintWriter pw = resp.getWriter();
        pw.println("<p>Session id:</p>");
        pw.println("<p>" + sessId + "</p>");
        pw.close();
    }
}