import junit.framework.TestCase;

public class GameMasterTest extends TestCase
{
    GameMaster master;

    public void setup()
    {
        master = GameMaster.instance();
        master.setGameBoard(new SimpleGameBoard());
    }

    /*
    Tests whether the GameMaster is not null when it's instantiated with its instance method, then
    asserts that two different instances of a singleton class would be the same.
     */
    public void testSingleton()
    {
        GameMaster instance1 = GameMaster.instance();
        assertNotNull(instance1);

        GameMaster instance2 = GameMaster.instance();
        assertNotNull(instance2);

        assertSame(instance1, instance2);
    }

    /*
    This test creates 6 players, then asserts getNumberOfPlayers returns that number. Then,
    using a for loop checks if all 6 players are starting on go.
     */
    public void testPlayerInitiation()
    {
        setup();
        master.setNumberOfPlayers(6);
        assertEquals(6, master.getNumberOfPlayers());
        Cell go = master.getGameBoard().getCell(0);

        for (int i = 0; i < 6; i++)
        {
            Player player = master.getPlayer(i);
            assertSame(go, player.getPosition());
        }
    }

    /*
    Tests a single player moving along the board. When the dice roll is 2, asserts that player should
    be on Blue2, then a dice roll of 3 following asserts the player is on Green2.
     */
    public void testMovePlayerSimple()
    {
        setup();
        master.setNumberOfPlayers(1);
        Player player = master.getPlayer(0);
        master.movePlayer(0, 2);
        assertEquals("Blue 2", player.getPosition().getName());
        master.movePlayer(0, 3);
        assertEquals("Green 2", player.getPosition().getName());

    }
}
