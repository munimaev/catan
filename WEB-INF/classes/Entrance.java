import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import com.google.gson.Gson;

public class Entrance extends HttpServlet {
    // Наименования возможных параметров запроса
    private String optAction = "action";
    private String optFirstTable = "first_table";

    // Наименования возможных действий
    private String actionTablesCount = "tables_count";
    private String actionGetTables = "get_tables";
    private String actionCreateTable = "create_tables";

    /**
     * Стандартное количество возвращаемых столов
     */
    private int TABLE_COUNT = 25;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        StringBuilder answer = new StringBuilder();

//        String sessionId = req.getRequestedSessionId();
//        answer.append("<p>Session id: " + sessionId + "</p>\n\r");

        String action = req.getParameter(optAction);


        Gson gson = new Gson();


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

            if(req.getParameter(optFirstTable) != null) {
                first_table = Integer.parseInt(req.getParameter(optFirstTable));
            }

            ArrayList<ITable> tables = getTables(first_table, TABLE_COUNT);

            if (tables.size() == 0) {
                answer.append(JsonAnswers.empty());
                return;
            }

            for (ITable table : tables) {
                // TODO: добавить запятые и обернуть все в массив
                answer.append(JsonAnswers.table(table.getId(), table.getName()));
            }
        }
        else {
            answer.append(JsonAnswers.empty());
        }

        try (PrintWriter pw = resp.getWriter()) {
            pw.println(answer.toString());
        }

    }

    /**
     * @return Количество существующих столов.
     */
    private int getTablesCount() {
        return Catan.getInstance().getTables().size();
    }

    /**
     * С помощью этого метода можно получить список из нескольких игровых столов.
     * @param first Номер первого получаемого стола.
     * @param count Количество столов, которое мы хотим получить.
     * @return Список некоторого количества игровых столов.
     */
    private ArrayList<ITable> getTables(int first, int count) {
        ArrayList<ITable> tables = new ArrayList<>();

        for (int i = 0; i < getTablesCount() && i < first + count; i++) {
            tables.add(Catan.getInstance().getTables().get(i));
        }

        return tables;
    }
}
