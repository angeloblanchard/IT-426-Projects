package io.exporting;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.CarPart;
import model.PartsDatabase;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JSONExporter implements IExporter
{
    PartsDatabase data;

    public JSONExporter(PartsDatabase data)
    {
        this.data = data;
    }

    @Override
    public boolean exportParts()
    {
        try
        {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            CarPart[] carPartInput = (gson.fromJson(new FileReader("parts.json"), CarPart[].class));
            int count = 0;

            for (CarPart carPart : data.getParts())
            {
                if (carPart == carPartInput[count])
                {
                    return false;
                }
                count++;
            }

            gson.toJson(data.getParts(), new FileWriter("parts.json"));
            return true;
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        return false;
    }
}
