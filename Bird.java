
import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.imageio.ImageIO;

public class Bird extends Rectangle
{
  private Image image;
  
  public Bird()
  {
    super(390, 390, 30, 30);
  } 


  public Bird(int x, int y, int w, int h)
  {
    super(x, y, w, h);
    try
    {
      URL url = getClass().getResource("bird.png");
      image = ImageIO.read(url);
    }
    catch(Exception e)
    {
      System.out.println("Error getting file.");
    }
     
  }

 

  public void fall()
  {
    if (!FlappyBird.started)
    {
      FlappyBird.started = true;
    }
    
    else if (!FlappyBird.gameOver)
    {
      if (FlappyBird.yMotion > 0)
      {
        FlappyBird.yMotion = 0;
      }

      FlappyBird.yMotion -= 8;
    }
  }

  public void intersect()
  {
    for (Rectangle column : FlappyBird.columns) 
    {
      if (column.y == 0 && this.x + getWidth()/2 > column.x + column.width/2 - 10 && this.x + getWidth()/2 < column.x + column.width/2 + 10)
      {
        FlappyBird.score.addScore();
      }

      if (column.intersects(this))
      {
        FlappyBird.gameOver = true;

        if (this.x <= column.x)
        {
          this.x = column.x - (int)getWidth();
        }
        else
        {
          if (column.y != 0)
          {
            this.y = column.y - (int)getHeight();
          }
          else if (this.y < column.height)
          {
            this.y = column.height;
          }
        }
      }
    }

    if (this.y > FlappyBird.HEIGHT - 120 || this.y < 0)
    {
      FlappyBird.gameOver = true;
    }

    if (this.y + FlappyBird.yMotion >= FlappyBird.HEIGHT - 120)
    {
      this.y = FlappyBird.HEIGHT - 120 - (int)getHeight();
    }
 }

  public void draw( Graphics window )
  {
    window.drawImage(image, x, y, width, height, null);
  }



  public String toString()
  {
    return x + " ," + y + " ," + width + " ," + height;
  }
}
