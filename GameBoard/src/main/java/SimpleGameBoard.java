public class SimpleGameBoard extends GameBoard
{
    public SimpleGameBoard()
    {
        super();
        Cell blue1 = new PropertyCell();
        Cell blue2 = new PropertyCell();
        Cell blue3 = new PropertyCell();
        Cell green1 = new PropertyCell();
        Cell green2 = new PropertyCell();

        blue1.setName("Blue 1");
        blue2.setName("Blue 2");
        blue3.setName("Blue 3");
        green1.setName("Green 1");
        green2.setName("Green 2");

        addCell(blue1);
        addCell(blue2);
        addCell(blue3);
        addCell(green1);
        addCell(green2);
    }
}
