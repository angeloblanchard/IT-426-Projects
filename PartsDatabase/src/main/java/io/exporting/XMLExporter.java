package io.exporting;

import model.CarPart;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;

public class XMLExporter implements IExporter
{
    CarPart carPart;

    public XMLExporter(CarPart carPart)
    {
        this.carPart = carPart;
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

                if (carPart == carPartInput)
                {
                    return false;
                }
            }

            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(carPart, new File("parts.xml"));

            return true;
        } catch (JAXBException e)
        {
            e.printStackTrace();
        }

        return false;
    }
}
