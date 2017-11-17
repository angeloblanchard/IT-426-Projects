package test;

import adventures.Adventurer;
import adventures.AdventurerType;
import adventures.GearedAdventurer;
import behaviors.AggressiveBehavior;
import behaviors.NobleBehavior;
import behaviors.TimidBehavior;
import tools.ArchaelogicalTool;
import tools.TrowelTool;

public class TestAdventurers
{
    public static void main(String[] args)
    {
        // squire
        Adventurer squire = new Adventurer("Jeff", AdventurerType.SQUIRE,
                                            new TimidBehavior());

        squire.takeAction();

        // we can dynamically alter the behaviors of our Adventurer class
        squire = new Adventurer("Lydia", AdventurerType.SQUIRE,
                                new NobleBehavior());
        squire.takeAction();

        GearedAdventurer knight = new GearedAdventurer("Robyn", AdventurerType.KNIGHT,
                                                new TimidBehavior(), new TrowelTool());

        // act timid with a trowel!
        knight.takeAction();
        knight.useTool();

        knight = new GearedAdventurer("Brianne", AdventurerType.KNIGHT,
                                    new AggressiveBehavior(), new ArchaelogicalTool());


        knight.takeAction();
        knight.useTool();

    }
}
