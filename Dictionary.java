// Jordan Deso
// CS 110
// Dictionary Class is used for the game boggle to verify if the words
// input by the user are valid words
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
public class Dictionary
{
   // Create array list to hold dictionary
   private ArrayList<String> dictionary = new ArrayList<String>();
   
   /**
      Constructor accepts a filename and is used to open the dictionary file 
      containing the list of valid words. It then stores the words in an array
      @param filename is the name of the dictonary file
   */
   public Dictionary(String filename) throws IOException
   {
      // Open Dictionary file
      File file = new File(filename);
      Scanner readDictionary = new Scanner(file);
      
      // Load words from dictionary into an array list
      while(readDictionary.hasNext())
         dictionary.add(readDictionary.nextLine());
      
      // Close file
      readDictionary.close();
   }
   
   /**
      The method isValidWord checks that the word input by the user is a valid word
      by seeing if it is found within the dictionary
      @param tiles is an ArrayList that contains the letters of the word input by the user
      @return true if the word is a valid word found in the dictonary 
      @return false if the word isn't valid
   */
   public boolean isValidWord(ArrayList<Tile> tiles)
   {
      // Create a string that will hold the word
      String lowerCaseLetter = "";
      String userWord = "";
      
      // Put the tiles array into the user word = represents guess of the user
      for (int i = 0; i < tiles.size(); i++)
      {
         lowerCaseLetter += tiles.get(i);
         userWord += lowerCaseLetter.toLowerCase();
         lowerCaseLetter = "";
      }
        
      // check if word is a valid word
      if (dictionary.contains(userWord))
         return true;
      else 
         return false;
   }
}