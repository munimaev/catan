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
        String sessionId = req.getRequestedSessionId();
        PrintWriter pw = resp.getWriter();

        String action = req.getParameter("action");

        if(action == null) {
            // Проверка, что параметр action пришел и отдача "404 page not found"  в случае провала.
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        // Обработка action
        if (action.equals("view_tables")) {
            pw.println("<h3>view_tables</h3>");
            pw.println("<p>Tables count: " + Catan.getInstance().getTables().size() + "</p>");
        } else if(action.equals("create_table")) {
            pw.println("<p>create_table</p>");
        } else {
            pw.println("<p>else</p>");
        }

        pw.println("<p>Session id: " + sessionId + "</p>");

        pw.close();
    }
}
