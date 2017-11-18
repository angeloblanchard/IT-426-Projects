package io.exporting;

import model.CarPart;
import model.PartsDatabase;

import java.io.*;

/**
 * Exports a PartsDatabase object into a DAT file
 *
 * @author Angelo Blanchard
 * @version 1.0
 */
public class JavaExporter implements IExporter
{
    PartsDatabase data;

    public JavaExporter(PartsDatabase data)
    {
        this.data = data;
    }

    /**
     * exports PartsDatabase object into parts.dat
     * @return
     */
    @Override
    public boolean exportParts()
    {
        try
        {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("parts.dat"));
            while (inputStream.readObject() instanceof CarPart)
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
        } catch (EOFException ex)
        {
            ex.printStackTrace();
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        try
        {

            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("parts.dat"));

            for (CarPart carPart : data.getParts())
            {
                outputStream.writeObject(carPart);
            }

            outputStream.close();
            return true;
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return false;
    }
}
