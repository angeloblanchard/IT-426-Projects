package io.importing;

import model.CarPart;
import model.PartsDatabase;

import java.io.*;

/**
 * Imports in a DAT file to be converted to a PartsDatabase object
 *
 * @author Angelo Blanchard
 * @version 1.0
 */
public class JavaImporter implements IImporter
{
    PartsDatabase data;

    public JavaImporter()
    {
        data = new PartsDatabase();
    }

    /**
     * imports file from parts.dat
     * @return false if file is empty, true otherwise
     */
    @Override
    public boolean importParts()
    {
        File partsFile = new File("parts.dat");
        if (partsFile.exists() || partsFile.length() != 0)
        {
            try
            {
                FileInputStream fileInputStream = new FileInputStream(partsFile);
                ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);

                CarPart part = (CarPart)inputStream.readObject();
                while (part != null)
                {
                    data.addPart(part);
                    part = (CarPart) inputStream.readObject();

                }
                inputStream.close();

            } catch (StreamCorruptedException e)
            {
                e.printStackTrace();
            }catch (EOFException e)
            {
                e.printStackTrace();
            } catch (IOException e)

            {
                e.printStackTrace();
            } catch (ClassNotFoundException e)
            {
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }
}
