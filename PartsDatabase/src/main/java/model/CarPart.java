package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * CarPart object, to be used with the PartsDatabase. Implements Serializable to
 * work with XML.
 *
 * @author Angelo Blanchard
 * @version 1.1
 */
@XmlRootElement
public class CarPart implements Serializable
{
    private String id;
    private String manufacturer;
    private double listPrice;
    private String[] categories;
    public static final long serialVersionUID = 42L;

    public CarPart()
    {
        //do nothing - leave this method here...
    }

    public CarPart(String id, String manufacturer, double listPrice, String[] categories)
    {
        this.id = id;
        this.manufacturer = manufacturer;
        this.listPrice = listPrice;
        this.categories = categories;
    }

    @XmlElement
    public String getId()
    {
        return id;
    }

    @XmlElement
    public String getManufacturer()
    {
        return manufacturer;
    }

    @XmlElement
    public double getListPrice()
    {
        return listPrice;
    }

    @XmlElement
    public String[] getCategories()
    {
        return categories;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public void setManufacturer(String manufacturer)
    {
        this.manufacturer = manufacturer;
    }

    public void setListPrice(double listPrice)
    {
        this.listPrice = listPrice;
    }

    public void setCategories(String[] categories)
    {
        this.categories = categories;
    }


}
