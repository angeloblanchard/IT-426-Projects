package io.exporting;

import io.importing.JavaImporter;
import model.CarPart;

import java.io.*;

public class JavaExporter implements IExporter
{
    CarPart carPart;

    public JavaExporter(CarPart carPart)
    {
        this.carPart = carPart;
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
                if (carPartInput == carPart)
                {
                    return false;
                }
            }
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("parts.dat"));
            outputStream.writeObject(carPart);

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
