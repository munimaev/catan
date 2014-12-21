import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Entrance extends HttpServlet {
    /**
     * Имена возможных параметров запроса
     */
    private enum Options {
        ACTION("action"),
        TABLES_COUNT("tables_count"),
        GET_TABLES("get_tables"),
        FIRST_TABLE("first_table"),
        LAST_TABLE("last_table"),
        CREATE_TABLE("create_tables");

        private String option;

        Options(String option) {
            this.option = option;
        }

        @Override
        public String toString() {
            return option;
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String sessionId = req.getRequestedSessionId();
        PrintWriter pw = resp.getWriter();

        String action = req.getParameter(Options.ACTION.toString());

        if(action == null) {
            pw.println(JsonAnswers.empty());
            return;
        }

        // Обработка action
        if (action.equals(Options.TABLES_COUNT.toString())) {
            pw.println(JsonAnswers.tablesCount(getTablesCount()));
        }
        else if(action.equals(Options.CREATE_TABLE.toString())) {
            pw.println("<p>create_tables</p>");
        }
        else if(action.equals(Options.GET_TABLES.toString())) {
            int first_table = 0;
            int last_table = getTablesCount() - 1;

            if(req.getParameter(Options.FIRST_TABLE.toString()) != null) {
                first_table = Integer.parseInt(req.getParameter(Options.FIRST_TABLE.toString()));
                return;
            } else if(req.getParameter(Options.LAST_TABLE.toString()) != null) {
                last_table = Integer.parseInt(req.getParameter(Options.LAST_TABLE.toString()));
                return;
            }

            ArrayList<ITable> tables = getTables(first_table, last_table);

            for (ITable table : tables) {
                // TODO: добавить запятые и обернуть все в массив
                pw.println(JsonAnswers.table(table.getTableId(), table.getTableName()));
            }

            pw.println("<p>get_tables</p>");
        }
        else {
            pw.println(JsonAnswers.empty());
        }

        pw.println("<p>Session id: " + sessionId + "</p>");

        pw.println(Integer.parseInt(req.getParameter("first_table")));


        pw.close();
    }

    private int getTablesCount() {
        return Catan.getInstance().getTables().size();
    }

    private ArrayList<ITable> getTables(int first, int last) {
        ArrayList<ITable> tables = new ArrayList<ITable>();

        for (int i = 0; i < Catan.getInstance().getTables().size(); i++) {
            if (i >= first && i <= last) {
                tables.add(Catan.getInstance().getTables().get(i));
            }
        }

        return tables;
    }




}
