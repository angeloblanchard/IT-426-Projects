package io.exporting;

import model.PartsDatabase;

import javax.xml.bind.*;
import java.io.File;

/**
 * Exports PartsDatabase object to a .json file
 *
 * @author Angelo
 * @version 1.0
 *
 */
public class XMLExporter implements IExporter
{
    PartsDatabase data;

    public XMLExporter(PartsDatabase data)
    {
        this.data = data;
    }

    /**
     * exports all parts to parts.json file
     * @return true if new parts added, false if empty or the same
     */
    @Override
    public boolean exportParts()
    {
        try
        {
            JAXBContext context = JAXBContext.newInstance(PartsDatabase.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            if (((PartsDatabase) unmarshaller.unmarshal(new File("parts.xml")) != null))
            {
                PartsDatabase parts = (PartsDatabase) unmarshaller.unmarshal(new File("parts.xml"));

                if (parts == data)
                {
                    return false;
                }
            }

            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(data, new File("parts.xml"));

            return true;
        } catch (UnmarshalException ex)
        {

        } catch (JAXBException e)
        {
            e.printStackTrace();
        }

        return false;
    }
}
