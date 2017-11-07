import java.util.ArrayList;

public class GameMaster
{
    private static GameMaster singleton;
    private GameBoard gameBoard;
    private ArrayList players;

    public static GameMaster instance()
    {
        if (singleton == null)
        {
            singleton = new GameMaster();
        }
        return singleton;
    }

    public void movePlayer(int playerIndex, int diceRoll)
    {
        Player player = getPlayer(playerIndex);
        Cell playerPosition = player.getPosition();
        int oldIndex = gameBoard.getCellIndex(playerPosition);
        int newIndex = (oldIndex + diceRoll) % gameBoard.getCellNumber();
        Cell newPosition = gameBoard.getCell(newIndex);
        player.setPosition(newPosition);
    }

    public void setGameBoard(GameBoard board)
    {
        this.gameBoard = board;
    }

    public void setNumberOfPlayers(int numberOfPlayers)
    {
        players = new ArrayList(numberOfPlayers);
        for (int i = 0; i < numberOfPlayers; i++)
        {
            Player player = new Player();
            players.add(player);
        }
    }

    public GameBoard getGameBoard()
    {
        return gameBoard;
    }

    public int getNumberOfPlayers()
    {
        return players.size();
    }

    public Player getPlayer(int index)
    {
        return (Player) players.get(index);
    }
}
