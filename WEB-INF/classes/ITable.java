import java.util.ArrayList;

public interface ITable {
    /**
     * @return Список всех игроков с этого стола.
     */
    public ArrayList<IPlayer> getPlayers();

    /**
     * @param sessionId  id http сессии игрока.
     * @return Экземпляр конкретного игрока.
     */
    public IPlayer getPlayer(String sessionId);

    /**
     * Скорее всего id стола будет складываться из session id игроков за столом.
     * @return Id стола.
     */
    public String getTableId();

    /**
     * @return Json в виде строки с ситуацией на столе.
     */
    public String getSituation();
}
