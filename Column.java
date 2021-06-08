import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Color;

public class Column {

  private Rectangle column;

  public Column(Rectangle column) {
    this.column = column;
  }

  public int getX() {
    return column.x;
  }

  public int getY() {
    return column.y;
  }

  public int getWidth() {
    return column.width;
  }

  public int getHeight() {
    return column.height;
  }

  public Rectangle getColumn() {
    return column;
  }

  public void setColumn(Rectangle column) {
    this.column = column;
  }
  
}