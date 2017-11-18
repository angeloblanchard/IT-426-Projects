package io.importing;

import model.CarPart;
import model.PartsDatabase;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XMLImporter implements IImporter
{
    PartsDatabase data;

    @Override
    public boolean importParts()
    {
        File partsFile = new File("parts.xml");
        if (partsFile.exists() || partsFile.length() != 0)
        {
            try
            {
                JAXBContext context = JAXBContext.newInstance(CarPart.class);
                Unmarshaller unmarshaller = context.createUnmarshaller();

                while ((CarPart)unmarshaller.unmarshal(new File("parts.xml")) != null)
                {
                    CarPart carPart = (CarPart)unmarshaller.unmarshal(new File("parts.xml"));
                    data.addPart(carPart);
                }

                return true;
            } catch (JAXBException e)
            {
                e.printStackTrace();
            }
        }
        return false;
    }
}
