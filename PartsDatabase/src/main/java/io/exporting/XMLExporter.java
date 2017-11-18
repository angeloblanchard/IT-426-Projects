package io.exporting;

import model.CarPart;
import model.PartsDatabase;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;

public class XMLExporter implements IExporter
{
    PartsDatabase data;

    public XMLExporter(PartsDatabase data)
    {
        this.data = data;
    }

    @Override
    public boolean exportParts()
    {
        try
        {
            JAXBContext context = JAXBContext.newInstance(CarPart.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            while ((CarPart)unmarshaller.unmarshal(new File("parts.xml")) != null)
            {
                CarPart carPartInput = (CarPart)unmarshaller.unmarshal(new File("parts.xml"));

                for (CarPart carPart : data.getParts())
                {
                    if (carPart == carPartInput)
                    {
                        return false;
                    }
                }

            }

            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(data.getParts(), new File("parts.xml"));

            return true;
        } catch (JAXBException e)
        {
            e.printStackTrace();
        }

        return false;
    }
}
