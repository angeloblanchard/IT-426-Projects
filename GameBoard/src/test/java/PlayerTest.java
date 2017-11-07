import junit.framework.TestCase;

public class PlayerTest extends TestCase
{
    public PlayerTest (String name)
    {
        super(name);
    }

    /*
    This test creates two players on the SimpleGameBoard, then asserts that player1 and player2 are both
    starting on the GoCell.
     */
    public void testStartPosition()
    {
        GameBoard board = new SimpleGameBoard();
        GameMaster.instance().setGameBoard(board);
        Player player1 = new Player();
        Player player2 = new Player();
        Cell go = board.getCell(0);
        assertSame(go, player1.getPosition());
        assertSame(go, player2.getPosition());
    }
}
