import java.io.FileWriter; // Import the FileWriter class
import java.io.IOException; // Import the IOException class to handle errors
import java.io.BufferedReader;
import java.io.FileReader;

public class AdvancedScore extends Score
{
  
  private double highScore;
  private FileWriter writer;
  private boolean printable;
  private BufferedReader reader;

  public AdvancedScore()
  {
    super();
    printable = true;
    highScore = 0;
    try {
      writer = new FileWriter("Scores.txt");
      reader = new BufferedReader(new FileReader("Scores.txt"));
    } catch (IOException e) {}
  }

  public int getHighScore()
  {
    return (int)highScore;
  }

  public void setHighScore(int newScore)
  {
    highScore = newScore;
  }

  public void resetPrintable()
  {
    printable = !printable;
  }

  public void closeWriter()
  {
    try {
      writer.close();
    } catch (IOException e) {}
  }

  @Override
  public void addScore()
  {
    super.addScore();
    if (super.getScore() > highScore)
      highScore = super.getScore(); 
  }

  @Override
  public void printScore()
  {
    try {
      if (printable) {
        writer.write("Score" + ": " + getScore() + "\n");
        printable = false;
      }
    } catch (IOException e) {
      System.out.println("An error occurred.");
    }
  }

  public void printScoresInTextFile() {
      int counter = 1;
      String line = "";
    	try {
        line = reader.readLine();
      } catch(IOException e) {}
			while (line != null) {
				System.out.println("Your Score for Attempt " + counter + ": " + line);
        counter++;
    	try {
        line = reader.readLine();
      } catch(IOException e) {}
      }
  }

}