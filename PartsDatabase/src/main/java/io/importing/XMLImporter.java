package io.importing;

import model.CarPart;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XMLImporter implements IImporter
{
    CarPart carPart;

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
                carPart = (CarPart)unmarshaller.unmarshal(new File("parts.xml"));

                return true;
            } catch (JAXBException e)
            {
                e.printStackTrace();
            }
        }
        return false;
    }
}
