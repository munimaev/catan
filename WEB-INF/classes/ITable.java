import java.util.ArrayList;

/**
 * Created by Viktor on 09.12.2014.
 */
public interface ITable {
    /**
     * Получить список всех игроков с этого стола.
     * @return
     */
    public ArrayList<IPlayer> getPlayers();

    /**
     * Получить экземпляр конкретного игрока по id его http сессии.
     * @param sessionId
     * @return
     */
    public IPlayer getPlayer(String sessionId);

    /**
     * Получить id стола. Скорее всего он бедет складываться из session id игроков за столом.
     * @return
     */
    public String getTableId();
}
