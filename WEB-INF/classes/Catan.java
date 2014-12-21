import java.util.ArrayList;

public class Catan implements ICatan{
    private static ICatan instance = null;
    private final ArrayList<ITable> tables = new ArrayList<ITable>();

    private Catan() {
    }

    public static ICatan getInstance() {
        if(instance == null) {
            instance = new Catan();
        }
        return instance;
    }



    @Override
    public ArrayList<ITable> getTables() {
        return tables;
    }

    @Override
    public ITable getTable(String tableId) {
        // TODO: сделать
        return null;
    }

    @Override
    public boolean createTable(ArrayList<IPlayer> players, String tableName) {
        // TODO: сделать
        return false;
    }

    @Override
    public boolean deleteTable(String tableId) {
        // TODO: сделать
        return false;
    }

    @Override
    public boolean deleteTable(ITable table) {
        // TODO: сделать
        return false;
    }

    @Override
    public boolean deleteTable(IPlayer player) {
        // TODO: сделать
        return false;
    }
}
