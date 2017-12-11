package adapters;

import drawing.IShape;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import shapes.Rectangle;

public class RectangleAdapter implements IShape
{
    private Rectangle rectangle;

    public RectangleAdapter(Rectangle rectangle)
    {
        this.rectangle = rectangle;
    }

    @Override
    public IShape setThickness(double value)
    {
        rectangle = new Rectangle(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight(),
                value, rectangle.getColor(), rectangle.isFill());
        return this;
    }

    @Override
    public IShape setColor(Color value)
    {
        rectangle = new Rectangle(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight(),
                rectangle.getThickness(), value, rectangle.isFill());
        return this;
    }

    @Override
    public IShape setFilled(boolean value)
    {
        rectangle = new Rectangle(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight(),
                rectangle.getThickness(), rectangle.getColor(), value);
        return this;
    }

    @Override
    public double getX()
    {
        return rectangle.getX();
    }

    @Override
    public double getY()
    {
        return rectangle.getY();
    }

    @Override
    public double getThickness()
    {
        return rectangle.getThickness();
    }

    @Override
    public Color getColor()
    {
        return rectangle.getColor();
    }

    @Override
    public boolean getFilled()
    {
        return rectangle.isFill();
    }

    @Override
    public void drawShape(GraphicsContext graphics)
    {
        graphics.setStroke(rectangle.getColor());
        graphics.setLineWidth(rectangle.getThickness());
        graphics.strokeRect(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
    }
}
