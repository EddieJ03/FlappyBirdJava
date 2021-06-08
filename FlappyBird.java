import javax.swing.JFrame;
import java.awt.Component;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import java.awt.Font;
import java.awt.Image;


public class FlappyBird implements ActionListener, MouseListener, KeyListener
{
  public static FlappyBird flappyBird;
  public Renderer renderer;
  public PaintColumn paintCol;
  public Bird bird;
  public static ArrayList<Rectangle> columns;
  public static int ticks, yMotion;
  public static AdvancedScore score;
  public static boolean gameOver, started;
  public Random rand;
 // public boolean paused = false;

  public static final int WIDTH = 800;
  public static final int HEIGHT = 800;

  public FlappyBird()
  {
    JFrame jframe = new JFrame();
    Timer timer = new Timer(20, this);
    score = new AdvancedScore();

    paintCol = new PaintColumn(null, null);
    
    renderer = new Renderer();
    rand = new Random();

    jframe.add(renderer);
    jframe.setTitle("Flappy Bird");
    jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jframe.setSize(WIDTH, HEIGHT);
    jframe.addMouseListener(this);
    jframe.addKeyListener(this);
    jframe.setResizable(false);
    jframe.setVisible(true);

    bird = new Bird(WIDTH/2 - 10, HEIGHT/2 - 10, 30, 30);
    columns = new ArrayList<Rectangle>();
    


    addColumn(true);
    addColumn(true);
    addColumn(true);
    addColumn(true);

    timer.start();
  }


  public void addColumn(boolean start)
  {
    int space = 300;
    int width = 100;
    int height = 50 + rand.nextInt(300);

    if (start) 
    {
      columns.add(new Rectangle(WIDTH + width + columns.size()*300, HEIGHT - height - 120, width, height));
      columns.add(new Rectangle(WIDTH + width + (columns.size() - 1)*300, 0, width, HEIGHT - height - space));
    } else 
    {
      columns.add(new Rectangle(columns.get(columns.size() - 1).x + 600, HEIGHT - height - 120, width, height));
      columns.add(new Rectangle(columns.get(columns.size() - 1).x, 0, width, HEIGHT - height - space));
    }
  }

  public void jump()
  {

    if (gameOver)
    {
      bird = new Bird(WIDTH/2 - 10, HEIGHT/2 - 10, 30, 30);
       

      columns.clear();
      yMotion = 0;

      score.setScore(0);
      score.resetPrintable();
      
      addColumn(true);
      addColumn(true);
      addColumn(true);
      addColumn(true);

      gameOver = false;
    }
      

    if (!started)
    {
      started = true;
    }
    
    else if (!gameOver)
    {
      if (yMotion > 0)
      {
        yMotion = 0;
      }

      yMotion -= 8;
    }
  
  }

  @Override
  public void actionPerformed(ActionEvent e)
  {
    int speed = 8;

    ticks++;

    if (started)
    {
      for (int i = 0; i < columns.size(); i++) 
      {
        Rectangle column = columns.get(i);
        column.x -= speed;
      }

      if (ticks % 2 == 0 && yMotion < 15) 
      {
        yMotion += 2;
      }

      for (int i = 0; i < columns.size(); i++) 
      {
        Rectangle column = columns.get(i);
        
        if (column.x + column.width < 0)
        {
          columns.remove(column);

          if (column.y == 0) 
          {
            addColumn(false);
          }
        }
      }

      bird.y += yMotion;
      bird.intersect();
/*    
      for (Rectangle column : columns) 
      {
        if (column.y == 0 && bird.x + bird.getWidth()/2 > column.x + column.width/2 - 10 && bird.x + bird.getWidth()/2 < column.x + column.width/2 + 10)
        {
          score.addScore();
        }

        if (column.intersects(bird))
        {
          gameOver = true;

          if (bird.x <= column.x)
          {
            bird.x = column.x - (int)bird.getWidth();
          }
          else
          {
            if (column.y != 0)
            {
              bird.y = column.y - (int)bird.getHeight();
            }
            else if (bird.y < column.height)
            {
              bird.y = column.height;
            }
          }
        }
      }

      if (bird.y > HEIGHT - 120 || bird.y < 0)
      {
        gameOver = true;
      }

      if (bird.y + yMotion >= HEIGHT - 120)
      {
        bird.y = HEIGHT - 120 - (int)bird.getHeight();
      }*/
    }

    renderer.repaint();
  }

  public void repaint(Graphics g)
  {
    paintCol.setGraphics(g);

    g.setColor(Color.cyan);
    g.fillRect(0, 0, WIDTH, HEIGHT);

    g.setColor(Color.orange);
    g.fillRect(0, HEIGHT - 120, WIDTH, 120);
    g.setColor(Color.green);
    g.fillRect(0, HEIGHT - 120, WIDTH, 20);

    for (Rectangle column : columns)
    {
      paintCol.setColumn(column);
      paintCol.paintColumn();
    }
    

    g.setColor(Color.red);
    bird.draw(g);

    g.setColor(Color.white);
    g.setFont(new Font("Arial", 1, 100));

    if (!started)
    {
      g.drawString("Click to Start!", 15, HEIGHT/2  - 50);
    }

    if (gameOver)
    {
      g.drawString("Game Over!", 95, HEIGHT/2  - 50);
      g.setFont(new Font("Arial", 1, 35));
      g.drawString("Press 'Q' to End Game and See Score(s)", 10, HEIGHT/2  - 20);
      
      score.printScore();
    }

    if (!gameOver && started)
    {
      g.drawString(String.valueOf((int)score.getScore()), WIDTH/2 - 25, 100);
    }
  }

  public static void main(String[] args)
  {
    flappyBird = new FlappyBird();
  }

  public void mouseClicked(MouseEvent e)
  {
    jump();
  }

  public void mousePressed(MouseEvent e)
  {
  }

  public void mouseReleased(MouseEvent e)
  {
  }

  public void mouseEntered(MouseEvent e)
  {
  }

  public void mouseExited(MouseEvent e)
  {
  }

  public void keyTyped(KeyEvent e)
  {
  }

  public void keyPressed(KeyEvent e)
  {
  }

  public void keyReleased(KeyEvent e)
  {
    if (e.getKeyCode() == KeyEvent.VK_SPACE)
    {
      jump();
    }
    if (e.getKeyCode() == KeyEvent.VK_Q)
    {
      score.closeWriter();
      score.printScoresInTextFile();
      System.exit(0);
    }
    // if(e.getKeyCode() == KeyEvent.VK_P) {
    //   paused = !paused;
    //   if (paused)
    //   {

    //   }
    //   else
    //   {

    //   }
    // }
  }
}
