package adapters;

import drawing.IShape;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import shapes.Line;

/**
 * @author Angelo
 * @version 1.0
 * This adapter implements the Line shape
 */
public class LineAdapter implements IShape
{
    private Line line;

    public LineAdapter(Line line)
    {
        this.line = line;
    }

    /**
     *
     * @param value thickness value
     * @return IShape interface
     */
    @Override
    public IShape setThickness(double value)
    {
        line = new Line(line.getX(), line.getY(), line.getX2(), line.getX2(), value, line.getColor(), line.isFill());
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
        line = new Line(line.getX(), line.getY(), line.getX2(), line.getX2(), line.getThickness(), value, line.isFill());
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
        line = new Line(line.getX(), line.getY(), line.getX2(), line.getX2(), line.getThickness(), line.getColor(), value);
        return this;
    }

    /**
     *
     * @return x value
     */
    @Override
    public double getX()
    {
        return line.getX();
    }

    /**
     *
     * @return y value
     */
    @Override
    public double getY()
    {
        return line.getY();
    }

    /**
     *
     * @return thickness value
     */
    @Override
    public double getThickness()
    {
        return line.getThickness();
    }

    /**
     *
     * @return color value
     */
    @Override
    public Color getColor()
    {
        return line.getColor();
    }

    /**
     *
     * @return true if shape is filled
     */
    @Override
    public boolean getFilled()
    {
        return line.isFill();
    }

    /**
     *
     * @param graphics Graphics to be used to draw on canvas
     */
    @Override
    public void drawShape(GraphicsContext graphics)
    {
        graphics.setStroke(line.getColor());
        graphics.setLineWidth(line.getThickness());
        graphics.strokeLine(line.getX(), line.getY(), line.getX2(), line.getY2());
    }
}
