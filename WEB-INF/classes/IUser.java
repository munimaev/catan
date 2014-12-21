/**
 * Этот класс представляет собой пользователя, представившегося системе.
 * От классов реализующих интерфейс {@link IPlayer} отличается тем, что это именно пользователь портала,
 * а неигрок за конкретным столом.
 */
public interface IUser {

    /**
     * Установить новое имя пользователя.
     * @param userName Новое имя пользователя
     */
    public void setUserName(String userName);

    /**
     * Получить имя пользователя.
     * @return имя пользователя.
     */
    public String getUserName();

    /**
     * Получить id http сессии игрока.
     * @return Id http сессии пользователя.
     */
    public String getSessionId();
}
