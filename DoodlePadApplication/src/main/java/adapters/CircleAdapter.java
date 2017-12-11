package adapters;

import drawing.IShape;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import shapes.Circle;

/**
 * @author Angelo
 * @version 1.0
 *
 * This Adapter implements the Circle shape.
 */
public class CircleAdapter implements IShape
{
    public static final int DEFAULT_SIZE = 50;
    private Circle circle;

    public CircleAdapter(Circle circle)
    {
        this.circle = circle;
    }

    /**
     *
     * @param value thickness value
     * @return the IShape interface
     */
    @Override
    public IShape setThickness(double value)
    {
        circle = new Circle(circle.getRadius(), circle.getX(), circle.getY(), value, circle.getColor(), circle.isFill());
        return this;
    }

    /**
     *
     * @param value Color value
     * @return IShape interface
     */
    @Override
    public IShape setColor(Color value)
    {
        circle = new Circle(circle.getRadius(), circle.getX(), circle.getY(), circle.getThickness(), value, circle.isFill());
        return this;
    }

    /**
     *
     * @param value is filled is true or not
     * @return IShape interface
     */
    @Override
    public IShape setFilled(boolean value)
    {
        circle = new Circle(circle.getRadius(), circle.getX(), circle.getY(), circle.getThickness(), circle.getColor(), value);
        return this;
    }

    /**
     *
     * @return x value
     */
    @Override
    public double getX()
    {
        return circle.getX();
    }

    /**
     *
     * @return y value
     */
    @Override
    public double getY()
    {
        return circle.getY();
    }

    /**
     *
     * @return thickness value
     */
    @Override
    public double getThickness()
    {
        return circle.getThickness();
    }

    /**
     *
     * @return color value
     */
    @Override
    public Color getColor()
    {
        return circle.getColor();
    }

    /**
     *
     * @return true if shape is filled
     */
    @Override
    public boolean getFilled()
    {
        return circle.isFill();
    }

    /**
     *
     * @param graphics Graphics to be used on canvas to draw
     */
    @Override
    public void drawShape(GraphicsContext graphics)
    {
        graphics.setStroke(circle.getColor());
        graphics.setLineWidth(circle.getThickness());
        graphics.strokeOval(circle.getX(), circle.getY(), DEFAULT_SIZE, DEFAULT_SIZE);

        if (getFilled())
        {
            graphics.setFill(circle.getColor());
            graphics.fillOval(circle.getX(), circle.getY(), DEFAULT_SIZE, DEFAULT_SIZE);
        }
    }
}
