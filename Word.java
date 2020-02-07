// Jordan Deso
// CS 110
// The word class works with the boggle game to take the word input 
// by the user and store the amount of points it is worth
import java.util.ArrayList;
public class Word
{
   private ArrayList<Character> letters = new ArrayList<Character>();
   // Constants for value of the length of the word
   private static final int THREE_LETTER_POINTS = 1;
   private static final int FOUR_LETTER_POINTS = 1;
   private static final int FIVE_LETTER_POINTS = 2;
   private static final int SIX_LETTER_POINTS = 3;
   private static final int SEVEN_LETTER_POINTS = 5;
   private static final int EIGHT_OR_MORE_LETTER_POINTS = 11;
    
   // variables to store total points of the word
   private int points = 0;
  
   /**
      Contructor accepts an ArrayList of the word input by the user
      and records the amount of points that word is worth based off of
      its length
      @param tiles is the word input by user
   */
   public Word(ArrayList tiles)
   {
      this.letters = tiles;
      // Create a stringbuilder that is the size of the world entered by the user
      StringBuilder userWord = new StringBuilder(tiles.size());
      
      // Put the tiles array into the user word = represents guess of the user
      for (int i = 0; i < tiles.size(); i++)
         userWord.append(tiles.get(i));
      
      // Store points the world is worth
      if (userWord.length() == 3)
         points = THREE_LETTER_POINTS;
      if (userWord.length() == 4)
         points = FOUR_LETTER_POINTS;
      if (userWord.length() == 5)
         points = FIVE_LETTER_POINTS; 
      if (userWord.length() == 6)
         points = SIX_LETTER_POINTS;
      if (userWord.length() == 7)
         points = SEVEN_LETTER_POINTS;
      if (userWord.length() >= 8)
         points = EIGHT_OR_MORE_LETTER_POINTS; 
   }
   
   /**
      toString method returns the word to program
   */
   public String toString()
   {
      String word ="";
      for (int i = 0; i < letters.size(); i++)
         word += letters.get(i);
      return word.toUpperCase();
   }
   /**
      getter getPoints returns the amount of points to the driver
      @return points returns total points of the word
   */
   public int getPoints()
   {
      return points;
   }
}