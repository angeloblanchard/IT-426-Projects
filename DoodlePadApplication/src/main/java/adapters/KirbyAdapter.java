package adapters;

import drawing.IShape;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import shapes.Kirby;

public class KirbyAdapter implements IShape
{
    private Kirby kirby;

    public KirbyAdapter(Kirby kirby)
    {
        this.kirby = kirby;
    }

    @Override
    public IShape setThickness(double value)
    {
        return null;
    }

    @Override
    public IShape setColor(Color value)
    {
        return null;
    }

    @Override
    public IShape setFilled(boolean value)
    {
        return null;
    }

    @Override
    public double getX()
    {
        return 0;
    }

    @Override
    public double getY()
    {
        return 0;
    }

    @Override
    public double getThickness()
    {
        return 0;
    }

    @Override
    public Color getColor()
    {
        return null;
    }

    @Override
    public boolean getFilled()
    {
        return false;
    }

    @Override
    public void drawShape(GraphicsContext graphics)
    {
        // Feet
        graphics.setLineWidth(2);
        graphics.setStroke(Color.BLACK);
        graphics.setFill(Color.RED);
        graphics.fillOval(kirby.getX() - 5, kirby.getY() + 120, 70, 40);
        graphics.strokeOval(kirby.getX() - 5, kirby.getY() + 120, 70, 40);
        graphics.fillOval(kirby.getX() + 85, kirby.getY() + 120, 70, 40);
        graphics.strokeOval(kirby.getX() + 85, kirby.getY() + 120, 70, 40);


        graphics.setStroke(Color.BLACK);
        graphics.setFill(Color.PINK);
        graphics.setLineWidth(3);

        // Arms
        graphics.strokeOval(kirby.getX() - 20, kirby.getY() + 65, 30, 30);
        graphics.fillOval(kirby.getX() - 20, kirby.getY() + 65, 30, 30);
        graphics.strokeOval(kirby.getX() + 140, kirby.getY() + 65, 30, 30);
        graphics.fillOval(kirby.getX() +140, kirby.getY() + 65, 30, 30);

        // Body
        graphics.strokeOval(kirby.getX(), kirby.getY(), 150, 150);
        graphics.fillOval(kirby.getX(), kirby.getY(), 150, 150);

        // Cheeks
        graphics.setFill(Color.RED);
        graphics.setLineWidth(1);
        graphics.fillOval(kirby.getX() + 20, kirby.getY() + 80, 30, 20);
        graphics.strokeOval(kirby.getX() + 20, kirby.getY() + 80, 30, 20);
        graphics.fillOval(kirby.getX() + 90, kirby.getY() + 80, 30, 20);
        graphics.strokeOval(kirby.getX() + 90, kirby.getY() + 80, 30, 20);

        // Eyes
        graphics.setLineWidth(2);
        graphics.strokeOval(kirby.getX() + 35, kirby.getY() + 35, 20, 40);
        graphics.strokeOval(kirby.getX() + 80, kirby.getY() + 35, 20, 40);
        graphics.setFill(Color.BLUE);
        graphics.fillOval(kirby.getX() + 35, kirby.getY() + 35, 20, 40);
        graphics.fillOval(kirby.getX() + 80, kirby.getY() + 35, 20, 40);
        graphics.setFill(Color.BLACK);
        graphics.fillOval(kirby.getX() + 35, kirby.getY() + 36, 20, 30);
        graphics.fillOval(kirby.getX() + 80, kirby.getY() + 36, 20, 30);
        graphics.setFill(Color.WHITE);
        graphics.fillOval(kirby.getX() + 37, kirby.getY() + 36, 16, 20);
        graphics.fillOval(kirby.getX() + 82, kirby.getY() + 36, 16, 20);

        // Mouth
        graphics.setFill(Color.BLACK);
        graphics.fillOval(kirby.getX() + 60, kirby.getY() + 100, 20, 16);
        graphics.setFill(Color.DARKMAGENTA);
        graphics.fillOval(kirby.getX() + 64, kirby.getY() + 109, 10, 6);
    }
}
