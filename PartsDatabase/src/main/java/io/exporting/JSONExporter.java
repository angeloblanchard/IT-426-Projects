package io.exporting;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.CarPart;
import model.PartsDatabase;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Exports the PartsDatabase object into a JSON file
 *
 * @author Angelo Blanchard
 * @version 1.0
 */
public class JSONExporter implements IExporter
{
    PartsDatabase data;

    public JSONExporter(PartsDatabase data)
    {
        this.data = data;
    }

    /**
     * exports PartsDatabase object into parts.json
     * @return
     */
    @Override
    public boolean exportParts()
    {
        try
        {
            Gson gsonIn = new Gson();

            CarPart[] carPartInput = (gsonIn.fromJson(new FileReader("parts.json"), CarPart[].class));
            int count = 0;
            CarPart[] carPart;

            if (carPartInput != null)
            {
                for (CarPart part : carPartInput)
                {
                    if (carPartInput == null)
                    {
                        break;
                    }
                    if (data.getParts().contains(part))
                    {
                        return false;
                    }
                    data.addPart(part);
                }
            }

            carPart = new CarPart[data.getParts().size()];
            for (CarPart part : data.getParts())
            {
                carPart[count] = part;
                count++;
            }
            Gson gsonOut = new GsonBuilder().setPrettyPrinting().create();

            FileWriter writer = new FileWriter("parts.json");
            gsonOut.toJson(carPart, writer);
            writer.flush();

            return true;
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        return false;
    }
}
