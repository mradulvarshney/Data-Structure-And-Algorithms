package Arrays;

/*
Create an application that store a sequence of high score
entries(with name and score) for a video game in an array. 
	
A Java class, GameEntry, representing a game entry is as follows:-

public class GameEntry {
  private int score;
  private String name;
  public GameEntry(int score, String name) {
    this.score = score;
    this.name = name;
  }
  // Getter methods that returns the name and score 
  public int getScore() { return score; }
  public String getName() { return name; }
 // here i am returning a string representation of the entry
  @Override
  public String toString() {
    return "("+score + ", "+ name+ ")";
  }
}

Hint :- Sorting
*/

import java.util.Scanner;

public class GameEntry
{
    private int score;
    private String name;

    public GameEntry(String name, int score)
    {
        this.score = score;
        this.name = name;
    }

    public int getScore()
    {
        return score;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public String toString()
    {
        return "("+ score + "," + name + ')';
    }

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no. of entries");
        GameEntry[] ar=new GameEntry[sc.nextInt()];
        for (int i = 0; i < ar.length; i++)
        {
            System.out.println("Enter name and score:");
            ar[i]=new GameEntry(sc.next(), sc.nextInt());
        }
        for (int i = 0; i < ar.length; i++)
        {
            for (int j = i+1; j < ar.length; j++)
            {
                if(ar[i].getScore()<ar[j].getScore())
                {
                    GameEntry tmp=ar[i];
                    ar[i]=ar[j];
                    ar[j]=tmp;
                }
            }
        }
        for (int i = 0; i < ar.length; i++)
        {
            System.out.println(ar[i]);
        }
    }
}