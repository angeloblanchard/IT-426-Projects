import java.util.ArrayList;

public class GameBoard
{
    ArrayList cells = new ArrayList();

    public GameBoard()
    {
        addCell(new GoCell());
    }

    public void addCell (Cell cell)
    {
        cells.add(cell);
    }

    public Cell getCell(int index)
    {
        return (Cell)cells.get(index);
    }

    public int getCellIndex(Cell cell)
    {
        return cells.indexOf(cell);

    }

    public int getCellNumber()
    {
        return cells.size();
    }
}