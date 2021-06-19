import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Color;

public class PaintColumn extends Column {

  private Graphics graphics;

  public PaintColumn(Rectangle column, Graphics g) {
    super(column);
    graphics = g;
  }

  public void setGraphics(Graphics g) {
    graphics = g;
  }

  public void paintColumn()
  {
    graphics.setColor(Color.green.darker());
    graphics.fillRect(getX(), getY(), getWidth(), getHeight());

    if (getY() == 0) 
    {
      graphics.setColor(Color.cyan);
      graphics.fillRect(getX(), getY(), 10, getHeight() - 50);
      graphics.fillRect(getX() + getWidth() - 10, getY(), 10, getHeight() - 50);

      graphics.setColor(Color.black);
      graphics.fillRect(getX() + 5, getY(), 5, getHeight() - 50);
      graphics.fillRect(getX() + getWidth() - 10, getY(), 5, getHeight() - 50);
      graphics.fillRect(getX() + 5, getY() + getHeight() - 55, getWidth() - 10, 5);
      graphics.fillRect(getX(), getY() + getHeight() - 50, 5, 50);
      graphics.fillRect(getX() + getWidth() - 5, getY() + getHeight() - 50, 5, 50);
      graphics.fillRect(getX(), getY() + getHeight() - 5, getWidth(), 5);

      graphics.setColor(Color.green.darker().darker().darker());
      graphics.fillRect(getX(), getY() + getHeight() - 50, getWidth(), 5);

      graphics.setColor(Color.green.darker().darker());
      graphics.fillRect(getX() + getWidth() - 20, getY(), 10, getHeight() - 55);
      graphics.fillRect(getX() + getWidth() - 30, getY(), 5, getHeight() - 55);
      graphics.fillRect(getX() + getWidth() - 15, getY() + getHeight() - 45, 10, 40);
      graphics.fillRect(getX() + getWidth() - 25, getY() + getHeight() - 45, 5, 40);
      graphics.fillRect(getX() + 5, getY() + getHeight() - 10, 85, 5);


      graphics.setColor(Color.green);
      graphics.fillRect(getX() + 10, getY(), 20, getHeight() - 55);
      graphics.fillRect(getX() + 35, getY(), 5, getHeight() - 55);
      graphics.fillRect(getX() + 5, getY() + getHeight() - 45, 20, 35);
      graphics.fillRect(getX() + 30, getY() + getHeight() - 45, 5, 35);
      graphics.fillRect(getX() + 10, getY() + getHeight() - 10, 70, 5);

      graphics.setColor(new Color(0.931f, 1f, 0.788f));
      graphics.fillRect(getX() + 15, getY(), 5, getHeight() - 55);
      graphics.fillRect(getX() + 10, getY() + getHeight() - 45, 5, 35);
      graphics.fillRect(getX() + 15, getY() + getHeight() - 10, 35, 5);
      graphics.fillRect(getX() + 55, getY() + getHeight() - 10, 5, 5);
    }
    else
    {
      graphics.setColor(Color.cyan);
      graphics.fillRect(getX(), getY() + 50, 10, getHeight() - 50);
      graphics.fillRect(getX() + getWidth() - 10, getY() + 50, 10, getHeight() - 50);

      graphics.setColor(Color.black);
      graphics.fillRect(getX() + 5, getY() + 50, 5, getHeight() - 50);
      graphics.fillRect(getX() + getWidth() - 10, getY() + 50, 5, getHeight() - 50);
      graphics.fillRect(getX() + 5, getY() + 50, getWidth() - 10, 5);
      graphics.fillRect(getX(), getY(), 5, 50);
      graphics.fillRect(getX() + getWidth() - 5, getY(), 5, 50);
      graphics.fillRect(getX(), getY(), getWidth(), 5);

      graphics.setColor(Color.green.darker().darker().darker());
      graphics.fillRect(getX(), getY() + 45, getWidth(), 5);

      graphics.setColor(Color.green.darker().darker());
      graphics.fillRect(getX() + getWidth() - 20, getY() + 55, 10, getHeight() - 55);
      graphics.fillRect(getX() + getWidth() - 30, getY() + 55, 5, getHeight() - 55);
      graphics.fillRect(getX() + getWidth() - 15, getY() + 10, 10, 35);
      graphics.fillRect(getX() + getWidth() - 25, getY() + 10, 5, 35);
      graphics.fillRect(getX() + 5, getY() + 5, 85, 5);

      graphics.setColor(Color.green);
      graphics.fillRect(getX() + 10, getY() + 55, 20, getHeight() - 55);
      graphics.fillRect(getX() + 35, getY() + 55, 5, getHeight() - 55);
      graphics.fillRect(getX() + 5, getY() + 10, 20, 35);
      graphics.fillRect(getX() + 30, getY() + 10, 5, 35);
      graphics.fillRect(getX() + 10, getY() + 5, 70, 5);

      graphics.setColor(new Color(0.931f, 1f, 0.788f));
      graphics.fillRect(getX() + 15, getY() + 55, 5, getHeight() - 55);
      graphics.fillRect(getX() + 10, getY() + 10, 5, 35);
      graphics.fillRect(getX() + 15, getY() + 5, 35, 5);
      graphics.fillRect(getX() + 55, getY() + 5, 5, 5);
    }
  }
}