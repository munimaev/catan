/**
 * Created by Viktor on 21.12.2014.
 */
public abstract class JsonAnswers {
    public static String empty() {
        return "{}";
    }

    public static String tablesCount(int count) {
        return "{\"tables_count\": " + count + " }";
    }

    public static String table(String id, String name) {
        return "{" +
                "\"id\": " + id + ", " +
                "\"name\": " + name + ", " +
                "\"players\": [\"???\"]" +
                // TODO: Подумать над массивом игроков
                "}";
    }





}
