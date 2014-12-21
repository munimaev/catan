import java.util.ArrayList;

/**
 * Игровой стол.
 */
public class Table implements ITable {
    private String id, name;
    private ArrayList<IPlayer> players = new ArrayList<>();

    public Table(String id) {
        this.id = id;
        this.name = "Без имени";
    }

    public Table(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public ArrayList<IPlayer> getPlayers() {
        return null;
    }

    @Override
    public IPlayer getPlayer(String sessionId) {
        return null;
    }

    @Override
    public String getTableId() {
        return null;
    }

    @Override
    public String getTableName() {
        return null;
    }

    @Override
    public String getSituation() {
        return null;
    }
}
