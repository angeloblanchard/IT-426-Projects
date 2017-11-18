package io.importing;

import model.CarPart;
import model.PartsDatabase;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Imports in an XML file and converts back into PartsDatabase object
 *
 * @author Angelo
 * @version 1.0
 */
public class XMLImporter implements IImporter
{
    PartsDatabase data;

    /**
     * Imports the .xml file
     * @return false if file is empty, true otherwise
     */
    @Override
    public boolean importParts()
    {
        File partsFile = new File("parts.xml");
        if (partsFile.exists() || partsFile.length() != 0)
        {
            try
            {
                JAXBContext context = JAXBContext.newInstance(PartsDatabase.class);
                Unmarshaller unmarshaller = context.createUnmarshaller();

                PartsDatabase partsData = (PartsDatabase) unmarshaller.unmarshal(new File("parts.xml"));

                if (partsData != null)
                {
                    for (CarPart part : partsData.getParts())
                    {
                        data.addPart(part);
                    }
                }

                return true;
            } catch (JAXBException e)
            {
                e.printStackTrace();
            } catch (UnsupportedOperationException e)
            {
                e.printStackTrace();
            }
        }
        return false;
    }
}
