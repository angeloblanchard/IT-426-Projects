package adapters;

import drawing.IShape;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import shapes.Triangle;

/**
 * @author Angelo
 * @version 1.0
 * This adapter implements the Triangle shape
 */
public class TriangleAdapter implements IShape
{
    private Triangle triangle;

    public TriangleAdapter(Triangle triangle)
    {
        this.triangle = triangle;
    }

    /**
     *
     * @param value thickness value
     * @return IShape interface
     */
    @Override
    public IShape setThickness(double value)
    {
        triangle = new Triangle(triangle.getX(), triangle.getY(), triangle.getWidth(),
                triangle.getHeight(), value, triangle.getColor(), triangle.isFill());
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
        triangle = new Triangle(triangle.getX(), triangle.getY(), triangle.getWidth(),
                triangle.getHeight(), triangle.getThickness(), value, triangle.isFill());
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
        triangle = new Triangle(triangle.getX(), triangle.getY(), triangle.getWidth(),
                triangle.getHeight(), triangle.getThickness(), triangle.getColor(), value);
        return this;
    }

    /**
     *
     * @return x value
     */
    @Override
    public double getX()
    {
        return triangle.getX();
    }

    /**
     *
     * @return y value
     */
    @Override
    public double getY()
    {
        return triangle.getY();
    }

    /**
     *
     * @return thickness value
     */
    @Override
    public double getThickness()
    {
        return triangle.getThickness();
    }

    /**
     *
     * @return color value
     */
    @Override
    public Color getColor()
    {
        return triangle.getColor();
    }

    /**
     *
     * @return true if filled
     */
    @Override
    public boolean getFilled()
    {
        return triangle.isFill();
    }

    /**
     *
     * @param graphics Graphics to be used to draw on canvas
     */
    @Override
    public void drawShape(GraphicsContext graphics)
    {
        graphics.setStroke(triangle.getColor());
        graphics.setLineWidth(triangle.getThickness());

        graphics.strokePolygon(new double []{ getX(), getX() + triangle.getWidth(), getX() + triangle.getWidth() / 2},
                new double[]{ getY(), getY(), getY() + triangle.getHeight()},
                3);

        if (getFilled())
        {
            graphics.setFill(triangle.getColor());
            graphics.fillPolygon(new double []{ getX(), getX() + triangle.getWidth(), getX() + triangle.getWidth() / 2},
                    new double[]{ getY(), getY(), getY() + triangle.getHeight()}, 3);
        }
    }
}
