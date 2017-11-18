package io.importing;

import com.google.gson.Gson;
import model.CarPart;
import model.PartsDatabase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Imports in a JSON file to be converted to PartsDatabase object
 *
 * @author Angelo Blanchard
 * @version 1.0
 */
public class JSONImporter implements IImporter
{
    PartsDatabase data;

    public JSONImporter()
    {
        data = new PartsDatabase();
    }

    /**
     * Imports in the .json file
     * @return false if the file is empty, true otherwise
     */
    @Override
    public boolean importParts()
    {
        File partsFile = new File("parts.json");
        if (partsFile.exists() || partsFile.length() != 0)
        {
            Gson gson = new Gson();
            try
            {
                CarPart[] carParts = gson.fromJson(new FileReader("parts.json"), CarPart[].class);

                for (CarPart carPart : carParts)
                {
                    if (data == null)
                    {
                        data.addPart(carPart);
                    }
                    else if (!data.getParts().contains(carPart))
                    {
                        data.addPart(carPart);
                    }
                }
                return true;
            } catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }
        }

        return false;
    }
}
