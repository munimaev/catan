import java.util.ArrayList;

public class Catan implements ICatan{
    private static ICatan instance = null;
    /**
     * Список существующих столов.
     */
    private final ArrayList<ITable> tables = new ArrayList<>();

    /**
     * Список пользователей игры.
     */
    private final ArrayList<IUser> users = new ArrayList<>();

    private Catan() {}

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
        for (ITable table : tables) {
            if (tableId.equals(table.getId())) { return table; }
        }
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

    @Override
    public IUser findUser(String userName) {
        for (IUser user : users) {
            if (userName.equals(user.getUserName())) { return user; }
        }
        return null;
    }
}
