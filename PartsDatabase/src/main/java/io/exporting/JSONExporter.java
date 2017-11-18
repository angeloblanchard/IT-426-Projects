package io.exporting;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.CarPart;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JSONExporter implements IExporter
{
    CarPart carPart;

    public JSONExporter(CarPart carPart)
    {
        this.carPart = carPart;
    }

    @Override
    public boolean exportParts()
    {
        try
        {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            while (gson.fromJson(new FileReader("parts.json"), CarPart[].class) != null)
            {
                CarPart carPartInput = (gson.fromJson(new FileReader("parts.json"), CarPart.class));

                if (carPart == carPartInput)
                {
                    return false;
                }
            }
            gson.toJson(carPart, new FileWriter("parts.json"));
            return true;
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        return false;
    }
}
