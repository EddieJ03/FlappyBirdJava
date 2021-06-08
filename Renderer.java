import javax.swing.JPanel;
import java.awt.Graphics;

public class Renderer extends JPanel
{
  private static final long serialVersionUID = 1L;

  @Override
  protected void paintComponent(Graphics g)
  {
    super.paintComponent(g);

    try {
      FlappyBird.flappyBird.repaint(g);
    } catch (Exception e) {}
  }
}