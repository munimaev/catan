import java.util.ArrayList;

public interface ITable {
    /**
     * Посадить игрока за этот игровой стол.
     * @param player Экземпляр игрока.
     * @return В случае успеха возвращает true и false в случае неудачи.
     */
    public boolean addPlayer(IPlayer player);

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
     * @return Название стола.
     */
    public String getTableName();

    /**
     * @return Json в виде строки с ситуацией на столе.
     */
    public String getSituation();
}
