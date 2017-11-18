package io.importing;

import model.CarPart;
import model.PartsDatabase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class JavaImporter implements IImporter
{
    PartsDatabase data;

    public JavaImporter()
    {
        data = new PartsDatabase();
    }

    @Override
    public boolean importParts()
    {
        File partsFile = new File("parts.dat");
        if (partsFile.exists() || partsFile.length() != 0)
        {
            try
            {
                ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("parts.dat"));
                while (inputStream.readObject() != null)
                {
                    CarPart carPart = (CarPart) inputStream.readObject();

                    data.addPart(carPart);
                }

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
