package adapters;

import drawing.IShape;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import shapes.Rectangle;

/**
 * @author Angelo
 * @version 1.0
 * This adapter implements the Rectangle shape
 */
public class RectangleAdapter implements IShape
{
    private Rectangle rectangle;

    public RectangleAdapter(Rectangle rectangle)
    {
        this.rectangle = rectangle;
    }

    /**
     *
     * @param value thickness value
     * @return IShape interface
     */
    @Override
    public IShape setThickness(double value)
    {
        rectangle = new Rectangle(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight(),
                value, rectangle.getColor(), rectangle.isFill());
        return this;
    }

    /**
     *
     * @param value color value
     * @return IShape interface
     */
    @Override
    public IShape setColor(Color value)
    {
        rectangle = new Rectangle(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight(),
                rectangle.getThickness(), value, rectangle.isFill());
        return this;
    }

    /**
     *
     * @param value true if filled
     * @return IShape interface
     */
    @Override
    public IShape setFilled(boolean value)
    {
        rectangle = new Rectangle(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight(),
                rectangle.getThickness(), rectangle.getColor(), value);
        return this;
    }

    /**
     *
     * @return x value
     */
    @Override
    public double getX()
    {
        return rectangle.getX();
    }

    /**
     *
     * @return y value
     */
    @Override
    public double getY()
    {
        return rectangle.getY();
    }

    /**
     *
     * @return thickness value
     */
    @Override
    public double getThickness()
    {
        return rectangle.getThickness();
    }

    /**
     *
     * @return color value
     */
    @Override
    public Color getColor()
    {
        return rectangle.getColor();
    }

    /**
     *
     * @return true if filled
     */
    @Override
    public boolean getFilled()
    {
        return rectangle.isFill();
    }

    /**
     *
     * @param graphics Graphics to be used to draw on the canvas
     */
    @Override
    public void drawShape(GraphicsContext graphics)
    {
        graphics.setStroke(rectangle.getColor());
        graphics.setLineWidth(rectangle.getThickness());
        graphics.strokeRect(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());

        if(getFilled())
        {
            graphics.setFill(rectangle.getColor());
            graphics.fillRect(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
        }
    }
}
