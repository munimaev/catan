/**
 * Этот класс хранит шаблоны ответов клиенту.
 */
public abstract class JsonAnswers {
    /**
     * @return Пустой объект.
     */
    public static String empty() {
        return "{}";
    }

    /**
     * @param count Количество существующих столов.
     * @return Json с информацией о количестве столов.
     */
    public static String tablesCount(int count) {
        return "{\"tables_count\": " + count + "}";
    }

    /**
     * @param id Id стола.
     * @param name Наименование стола.
     * @return Json с информацией о конкретном столе.
     */
    public static String table(String id, String name) {
        return "{" +
                "\"id\": " + id + ", " +
                "\"name\": " + name + ", " +
                "\"players\": [\"???\"]" +
                // TODO: Подумать над массивом игроков
                "}";
    }

}
