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
 * This program uses a more instance-based style to implement
 * indexing by using KWIC.
 */
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

        /**
         * Shifts the first word in each element's String to the end of same String
         */
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
            if (!line.contains(" "))
            {
                return line;
            }
            String[] array = line.split(" ", 2);
            return array[1] + " " + array[0];
        }

        /**
         * Prints the newly shifted and sorted lines to console output and a text file.
         */
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
                System.out.println("Failed to create file.");
            }
        }

    }
}