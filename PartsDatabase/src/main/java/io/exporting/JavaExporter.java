package io.exporting;

import io.importing.JavaImporter;
import model.CarPart;
import model.PartsDatabase;

import java.io.*;

public class JavaExporter implements IExporter
{
    PartsDatabase data;

    public JavaExporter(PartsDatabase data)
    {
        this.data = data;
    }

    @Override
    public boolean exportParts()
    {
        try
        {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("parts.dat"));
            while (inputStream.readObject() != null)
            {
                CarPart carPartInput = (CarPart) inputStream.readObject();

                for (CarPart carPart : data.getParts())
                {
                    if (carPartInput == carPart)
                    {
                        return false;
                    }
                }
            }

            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("parts.dat"));

            for (CarPart carPart : data.getParts())
            {
                outputStream.writeObject(carPart);
            }

            return true;
        } catch (IOException e)
        {
            e.printStackTrace();
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return false;
    }
}
