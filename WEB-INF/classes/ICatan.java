import java.util.ArrayList;

/**
 * Created by Viktor on 09.12.2014.
 */
public interface ICatan {
    /**
     * Получить список всех столов.
     * @return
     */
    public ArrayList<ITable> getTables();

    /**
     * Создать новый игровой стол, с хотя бы одним игроком.
     * @param players Список игроков за столом (от 1 до 4)
     * @param tableName Уникальное имя стола. Будет отображаться на странице выбора столов.
     * @return
     */
    public boolean createTable(ArrayList<IPlayer> players, String tableName);
}
