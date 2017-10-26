package kwic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

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

    public static String getInputFile()
    {
        System.out.println("Input file name?");
        Scanner console = new Scanner(System.in);
        String filename = console.next();
        console.close();
        return filename;
    }

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

    public static void circularShift(ArrayList<String> lines)
    {
        for (int i = 0; i < lines.size(); i++)
        {
            lines.set(i, shiftLine(lines.get(i)));
        }
    }

    private static String shiftLine(String line)
    {
        String[] array = line.split(" ", 2);
        String newLine = array[1] + " " + array[0];
        return newLine;
    }

    public static void sortLines(ArrayList<String> lines)
    {
        Collections.sort(lines);
    }

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
