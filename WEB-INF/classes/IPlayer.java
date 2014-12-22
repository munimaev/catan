public interface IPlayer {
    /**
     * Получить id http сессии игрока.
     * @return
     */
    public IUser getUser();

    /**
     * @return Цвет игрока.
     */
    public PlayerColor getColor();
}
