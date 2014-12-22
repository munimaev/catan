import java.util.ArrayList;

/**
 * Этот класс реализует игровой стол.
 */
public class Table implements ITable  {
    private String id, name;
    private ArrayList<IPlayer> players;

    public Table(ArrayList<IPlayer> players) throws NullPointerException {
        this.name = "Без имени";
        this.players = players;
        if (players.size() == 0) {
            throw new NullPointerException();
        } else {
            this.id = players.get(0).getUser().getSessionId();
        }
    }

    public Table(ArrayList<IPlayer> players, String name) throws NullPointerException {
        this(players);
        this.name = name;
    }

    @Override
    public boolean addPlayer(IPlayer player) {
        // TODO: Реализовать
        return false;
    }

    @Override
    public ArrayList<IPlayer> getPlayers() {
        return players;
    }

    @Override
    public IPlayer getPlayer(String sessionId) {
        for (IPlayer player : players) {
            if (sessionId.equals(player.getUser().getSessionId())) { return player; }
        }

        return null;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSituation() {
        // TODO: Реализовать
        return null;
    }
}
