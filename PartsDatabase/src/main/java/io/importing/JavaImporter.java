package io.importing;

import model.CarPart;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class JavaImporter implements IImporter
{
    CarPart carPart;

    public JavaImporter()
    {
        carPart = new CarPart();
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
                carPart = (CarPart) inputStream.readObject();
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
