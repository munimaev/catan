import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Entrance extends HttpServlet {
    // Наименования возможных параметров запроса
    private String optAction = "action";
    private String optFirstTable = "first_table";
    private String optLastTable = "last_table";

    // Наименования возможных действий
    private String actionTablesCount = "tables_count";
    private String actionGetTables = "get_tables";
    private String actionCreateTable = "create_tables";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        StringBuilder answer = new StringBuilder();

//        String sessionId = req.getRequestedSessionId();
//        answer.append("<p>Session id: " + sessionId + "</p>\n\r");

        String action = req.getParameter(optAction);

        if(action == null) {
            answer.append(JsonAnswers.empty());
            return;
        }

        // Обработка action
        if (action.equals(actionTablesCount)) {
            answer.append(JsonAnswers.tablesCount(getTablesCount()));
        }
        else if(action.equals(actionCreateTable)) {
            answer.append("<p>" + actionCreateTable + "</p>");
        }
        else if(action.equals(actionGetTables)) {
            int first_table = 0;
            int last_table = getTablesCount() - 1;

            if(req.getParameter(optFirstTable) != null) {
                first_table = Integer.parseInt(req.getParameter(optFirstTable));
            } else if(req.getParameter(optLastTable) != null) {
                last_table = Integer.parseInt(req.getParameter(optLastTable));
            }

            ArrayList<ITable> tables = getTables(first_table, last_table);

            if (tables.size() == 0) {
                answer.append(JsonAnswers.empty());
                return;
            }

            for (ITable table : tables) {
                // TODO: добавить запятые и обернуть все в массив
                answer.append(JsonAnswers.table(table.getTableId(), table.getTableName()));
            }
        }
        else {
            answer.append(JsonAnswers.empty());
        }

        try (PrintWriter pw = resp.getWriter()) {
            pw.println(answer.toString());
        }

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
