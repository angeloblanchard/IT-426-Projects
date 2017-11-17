package kwic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @Date October 25 2017
 * @Version 1.0
 * @Author Angelo Blanchard
 * This program uses a more static-based style to implement
 * indexing by using KWIC.
 */
public class OriginalKWIC
{
    public static void main(String[] args)
    {
        ArrayList<String> lines;
        File filename = new File(getInputFile());
        lines = readLines(filename);
        System.out.println("File found!");
        circularShift(lines);
        sortLines(lines);

        outputToFile(lines);
    }

    /**
     * Asks user for name of input file.
     * @return name of input file
     */
    public static String getInputFile()
    {
        System.out.println("Input file name?");
        Scanner console = new Scanner(System.in);
        String filename = console.next();
        console.close();
        return filename;
    }

    /**
     *
     * @param file File to be read from
     * @return ArrayList of all lines scanned from file
     */
    public static ArrayList<String> readLines(File file)
    {
        ArrayList<String> lines = new ArrayList<String>();
        try {
            Scanner lineScan = new Scanner(file);
            while(lineScan.hasNextLine())
            {
                lines.add(lineScan.nextLine());
            }
            lineScan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return lines;

    }

    /**
     * Circularly shifts the String, from the first word in each element, to the back of the String
     * @param lines lines of text
     */
    public static void circularShift(ArrayList<String> lines)
    {
        for (int i = 0; i < lines.size(); i++)
        {
            lines.set(i, shiftLine(lines.get(i)));
        }
    }

    private static String shiftLine(String line)
    {
        if (!line.contains(" "))
        {
            return line;
        }
        String[] array = line.split(" ", 2);
        return array[1] + " " + array[0];
    }

    /**
     * Sorts the lines alphabetically.
     * @param lines Sorted lines of text.
     */
    public static void sortLines(ArrayList<String> lines)
    {
        Collections.sort(lines);
    }

    /**
     * Outputs the shifted and sorted lines to console and to a text file.
     * @param lines lines to be printed out to console and text file
     */
    public static void outputToFile(ArrayList<String> lines)
    {
        try {
            PrintStream fileOutput = new PrintStream(new File("output.txt"));
            System.out.println("New shifted lines:\n");
            for(String line : lines)
            {
                fileOutput.println(line);
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
