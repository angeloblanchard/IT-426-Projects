package io.importing;

import com.google.gson.Gson;
import model.CarPart;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JSONImporter implements IImporter
{

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

                return true;
            } catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }
        }

        return false;
    }
}
