package kwic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class AlternateKWIC
{
    public static void main(String[] args)
    {
        KWICLines lines = new KWICLines();
        lines.circularShift();
        lines.outputToFile();
    }

    private static class KWICLines
    {
        private ArrayList<String> lines = new ArrayList<String>();
        private KWICLines()
        {
            try {
                File filename = new File("input1.txt");

                Scanner lineScan = new Scanner(filename);

                while(lineScan.hasNextLine())
                {
                    lines.add(lineScan.nextLine());
                }
                lineScan.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        public void circularShift()
        {
            for (int i = 0; i < lines.size(); i++)
            {
                lines.set(i, shiftLine(lines.get(i)));
            }
            Collections.sort(lines);
        }

        private String shiftLine(String line)
        {
            String[] array = line.split(" ", 2);
            String newLine = array[1] + " " + array[0];
            return newLine;
        }

        public void outputToFile()
        {
            try {
                PrintStream fileOutput = new PrintStream(new File("output1.txt"));
                System.out.println("New shifted lines:\n");
                for(String line : lines)
                {
                    fileOutput.println(line);
                    System.out.println(line);
                }
            } catch (FileNotFoundException e) {
                System.out.println("Failed to create file.");;
            }
        }

    }
}
