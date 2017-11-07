import junit.framework.TestCase;

public class GameBoardTest extends TestCase
{
    public GameBoardTest (String name)
    {
        super(name);
    }

    /*
    Tests the size of Cell contained inside GameBoard, starting with 1 (the GoCell in GameBoard constructor),
    then 2 when a new Cell is added to the GameBoard.
     */
    public void testAddCell()
    {
        GameBoard gameboard = new GameBoard();
        assertEquals(1, gameboard.getCellNumber());
        Cell cell = new Cell();
        gameboard.addCell(cell);
        assertEquals (2, gameboard.getCellNumber());
    }

    /*
    Tests if the GoCell instantiated in the GameBoard constructor and a Cell pulled from gameBoard
    index 0 is the same.
     */
    public void testFirstCell()
    {
        GameBoard gameboard = new GameBoard();
        Cell firstCell = gameboard.getCell(0);
        assertSame(GoCell.class, firstCell.getClass());
    }


    /*
    First test pulls Cell blue2 from the gameBoard's internal ArrayList, and asserts it equals 2.
    Second test creates a new Cell not inside gameBoard, and asserts that it's index is -1.
     */
    public void testGetCellIndex()
    {
        GameBoard gameBoard = new SimpleGameBoard();
        Cell blue2 = gameBoard.getCell(2);
        int index = gameBoard.getCellIndex(blue2);
        assertEquals(2, index);
        Cell notExist = new Cell();
        index = gameBoard.getCellIndex(notExist);
        assertEquals(-1, index);
    }
}
