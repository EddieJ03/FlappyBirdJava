import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Color;

public class PaintColumn extends Column {

  private Graphics g;

  public PaintColumn(Rectangle column, Graphics g) {
    super(column);
    this.g = g;
  }

  public void setGraphics(Graphics g) {
    this.g = g;
  }

  public void paintColumn()
  {
    g.setColor(Color.green.darker());
    g.fillRect(getX(), getY(), getWidth(), getHeight());

    if (getY() == 0) 
    {
      g.setColor(Color.cyan);
      g.fillRect(getX(), getY(), 10, getHeight() - 50);
      g.fillRect(getX() + getWidth() - 10, getY(), 10, getHeight() - 50);

      g.setColor(Color.black);
      g.fillRect(getX() + 5, getY(), 5, getHeight() - 50);
      g.fillRect(getX() + getWidth() - 10, getY(), 5, getHeight() - 50);
      g.fillRect(getX() + 5, getY() + getHeight() - 55, getWidth() - 10, 5);
      g.fillRect(getX(), getY() + getHeight() - 50, 5, 50);
      g.fillRect(getX() + getWidth() - 5, getY() + getHeight() - 50, 5, 50);
      g.fillRect(getX(), getY() + getHeight() - 5, getWidth(), 5);

      g.setColor(Color.green.darker().darker().darker());
      g.fillRect(getX(), getY() + getHeight() - 50, getWidth(), 5);

      g.setColor(Color.green.darker().darker());
      g.fillRect(getX() + getWidth() - 20, getY(), 10, getHeight() - 55);
      g.fillRect(getX() + getWidth() - 30, getY(), 5, getHeight() - 55);
      g.fillRect(getX() + getWidth() - 15, getY() + getHeight() - 45, 10, 40);
      g.fillRect(getX() + getWidth() - 25, getY() + getHeight() - 45, 5, 40);
      g.fillRect(getX() + 5, getY() + getHeight() - 10, 85, 5);


      g.setColor(Color.green);
      g.fillRect(getX() + 10, getY(), 20, getHeight() - 55);
      g.fillRect(getX() + 35, getY(), 5, getHeight() - 55);
      g.fillRect(getX() + 5, getY() + getHeight() - 45, 20, 35);
      g.fillRect(getX() + 30, getY() + getHeight() - 45, 5, 35);
      g.fillRect(getX() + 10, getY() + getHeight() - 10, 70, 5);

      g.setColor(new Color(0.931f, 1f, 0.788f));
      g.fillRect(getX() + 15, getY(), 5, getHeight() - 55);
      g.fillRect(getX() + 10, getY() + getHeight() - 45, 5, 35);
      g.fillRect(getX() + 15, getY() + getHeight() - 10, 35, 5);
      g.fillRect(getX() + 55, getY() + getHeight() - 10, 5, 5);
    }
    else
    {
      g.setColor(Color.cyan);
      g.fillRect(getX(), getY() + 50, 10, getHeight() - 50);
      g.fillRect(getX() + getWidth() - 10, getY() + 50, 10, getHeight() - 50);

      g.setColor(Color.black);
      g.fillRect(getX() + 5, getY() + 50, 5, getHeight() - 50);
      g.fillRect(getX() + getWidth() - 10, getY() + 50, 5, getHeight() - 50);
      g.fillRect(getX() + 5, getY() + 50, getWidth() - 10, 5);
      g.fillRect(getX(), getY(), 5, 50);
      g.fillRect(getX() + getWidth() - 5, getY(), 5, 50);
      g.fillRect(getX(), getY(), getWidth(), 5);

      g.setColor(Color.green.darker().darker().darker());
      g.fillRect(getX(), getY() + 45, getWidth(), 5);

      g.setColor(Color.green.darker().darker());
      g.fillRect(getX() + getWidth() - 20, getY() + 55, 10, getHeight() - 55);
      g.fillRect(getX() + getWidth() - 30, getY() + 55, 5, getHeight() - 55);
      g.fillRect(getX() + getWidth() - 15, getY() + 10, 10, 35);
      g.fillRect(getX() + getWidth() - 25, getY() + 10, 5, 35);
      g.fillRect(getX() + 5, getY() + 5, 85, 5);

      g.setColor(Color.green);
      g.fillRect(getX() + 10, getY() + 55, 20, getHeight() - 55);
      g.fillRect(getX() + 35, getY() + 55, 5, getHeight() - 55);
      g.fillRect(getX() + 5, getY() + 10, 20, 35);
      g.fillRect(getX() + 30, getY() + 10, 5, 35);
      g.fillRect(getX() + 10, getY() + 5, 70, 5);

      g.setColor(new Color(0.931f, 1f, 0.788f));
      g.fillRect(getX() + 15, getY() + 55, 5, getHeight() - 55);
      g.fillRect(getX() + 10, getY() + 10, 5, 35);
      g.fillRect(getX() + 15, getY() + 5, 35, 5);
      g.fillRect(getX() + 55, getY() + 5, 5, 5);
    }
  }
}