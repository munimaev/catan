public interface IPlayer {
    /**
     * Получить id http сессии игрока.
     * @return
     */
    public String getSessionId();

    /**
     * @return Цвет игрока.
     */
    public PlayerColor getColor();
}
