package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Stores a Collection of all CarPart objects. Also uses xml annotations
 */
@XmlRootElement
public class PartsDatabase
{
    private Collection<CarPart> parts;

    public PartsDatabase()
    {
        parts = new ArrayList<CarPart>();
    }

    public void addPart(CarPart part)
    {
        parts.add(part);
    }

    @XmlElement
    public Collection<CarPart> getParts()
    {
        return Collections.unmodifiableCollection(parts);
    }

    public void clear()
    {
        parts.clear();
    }
}
