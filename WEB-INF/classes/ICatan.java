import java.util.ArrayList;

/**
 * Этот интерфейс описывает игру целиком.
 * Через методы этого итерфейса можно обратиться к любому столу в игре, создать или удатить стол и т.д.
 */
public interface ICatan {
    /**
     * @return список всех столов
     */
    public ArrayList<ITable> getTables();

    /**
     * @param tableId Id искомого стола.
     * @return Конкретный экземпляр ITable.
     */
    public ITable getTable(String tableId);

    /**
     * Создать новый игровой стол, с хотя бы одним игроком.
     * @param players Список игроков за столом (от 1 до 4)
     * @param tableName Уникальное имя стола. Будет отображаться на странице выбора столов.
     * @return В случае успеха возвращает true, и false в случае неудачи.
     */
    public boolean createTable(ArrayList<IPlayer> players, String tableName);

    /**
     * Удаляет стол по его id.
     * @param tableId id удаляемого стола.
     * @return В случае успеха возвращает true, и false в случае неудачи.
     *
     * @see {@link this.deleteTable(ITable)}, {@link this.deleteTable(IPlayer)}
     */
    public boolean deleteTable(String tableId);

    /**
     * Удаляет переданный стол из списка столов игры.
     * @param table Конкретный экземпляр стола.
     * @return В случае успеха возвращает true, и false в случае неудачи.
     *
     * @see {@link this.deleteTable(String)}, {@link this.deleteTable(IPlayer)}
     */
    public boolean deleteTable(ITable table);

    /**
     * Удаляет стол по конкретному игроку находящемуся за столом.
     * @param player Экземпляр игрока, принадлежащего к конкретному столу.
     * @return В случае успеха возвращает true, и false в случае неудачи.
     */
    public boolean deleteTable(IPlayer player);

    /**
     * Найти пользователя с данным именем.
     * @param userName имя искомого пользователя.
     * @return Конкретный экземпляр пользователя.
     */
    public IUser findUser(String userName);
}
