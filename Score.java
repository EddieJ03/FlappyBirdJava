public class Score
{
  private double score;

  public Score()
  {
    score = 0;
  }

  public void addScore()
  {
    score += 0.34;
  }

  public int getScore()
  {
    return (int)score;
  }

  public void setScore(int newScore)
  {
    score = newScore;
  }

  public void printScore()
  {
    System.out.println("Your score was: " + score);
  }

}
