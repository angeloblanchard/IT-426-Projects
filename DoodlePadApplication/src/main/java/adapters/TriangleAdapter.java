package adapters;

import drawing.IShape;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import shapes.Triangle;

public class TriangleAdapter implements IShape
{
    private Triangle triangle;

    @Override
    public IShape setThickness(double value)
    {
        triangle = new Triangle(triangle.getX(), triangle.getY(), triangle.getWidth(),
                triangle.getHeight(), value, triangle.getColor(), triangle.isFill());
        return this;
    }

    @Override
    public IShape setColor(Color value)
    {
        triangle = new Triangle(triangle.getX(), triangle.getY(), triangle.getWidth(),
                triangle.getHeight(), triangle.getThickness(), value, triangle.isFill());
        return this;
    }

    @Override
    public IShape setFilled(boolean value)
    {
        triangle = new Triangle(triangle.getX(), triangle.getY(), triangle.getWidth(),
                triangle.getHeight(), triangle.getThickness(), triangle.getColor(), value);
        return this;
    }

    @Override
    public double getX()
    {
        return triangle.getX();
    }

    @Override
    public double getY()
    {
        return triangle.getY();
    }

    @Override
    public double getThickness()
    {
        return triangle.getThickness();
    }

    @Override
    public Color getColor()
    {
        return triangle.getColor();
    }

    @Override
    public boolean getFilled()
    {
        return triangle.isFill();
    }

    @Override
    public void drawShape(GraphicsContext graphics)
    {
        graphics.setStroke(triangle.getColor());
        graphics.setLineWidth(triangle.getThickness());
        graphics.strokeLine(triangle.getX(), triangle.getY(),triangle.getWidth(), triangle.getHeight());
    }
}
