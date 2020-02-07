// Game class controls the flow of Boggle guides program through
// certain functions dealing with the selections of tiles and
// making sure the words are valid.
import java.util.ArrayList;
import java.io.*;

public class Game
{
   // Create ArrayLists to hold the selected tiles and valid words
   private ArrayList<Tile> selected = new ArrayList<Tile>();
   private ArrayList<String> words = new ArrayList<String>();
   // variable holds total score for user
   private int score = 0;
   // Contains board
   private ArrayList<ArrayList<Tile>> gameBoard = new ArrayList<ArrayList<Tile>>();
   private Board board;
   private boolean wordUsed = false;
   /**
      default constructor creates the gameBoard ArrayList
      that will be used to perform certain operations within the
      game based on the user's commands
   */
   public Game()
   {
      board = new Board();
      // Put the board into gameBoard ArrayList
      for (int r = 0; r < 4; r++)
      {
         ArrayList<Tile> row = new ArrayList<>(4);
         for (int c = 0; c < 4; c++)
         {
            row = ((board.getBoard().get(r)));
            
         }
         gameBoard.add(row);
      }
   }
   /**
      isValidSelection checks to make sure the tiles selected
      by the user are valid tiles (tests adjecency)
      @param row current row user is trying to select
      @param column current column user is trying to select
   */
   public boolean isValidSelection(int row, int column)
   {  
      // Initialize default variables
      boolean valid = true;
      
      // Only tests adjecency if tiles already selected
      if (!selected.isEmpty())
      {
         // get tile that was previously selected
         Tile lastSelection = selected.get(selected.size()-1);
         if (Math.abs(lastSelection.getRow() - row) >= 2 || Math.abs(lastSelection.getColumn() - column) >= 2)
            valid = false;
      }      
      return valid;
   }
   /**
      addToSelected method add the tile requested by user to current 
      tile selection 
      @param row current row user has selected
      @param column current column user has selected
   */
   public void addToSelected(int row, int column)
   {
      selected.add((gameBoard.get(row)).get(column));
   }
   /**
      removeFromSelected method removes a specific tile selected by the user
      @param row current row user wishes to deselect
      @param column current column user wishes to deselect
   */
   public void removeFromSelected(int row, int column)
   {
      selected.remove((gameBoard.get(row)).get(column));
   }
   /**
      getSelectedTiles returns the arraylist of tiles of current selections
      @return selected tiles
   */
   public ArrayList<Tile> getSelectedTiles()
   {
      return selected;
   }
   /**
      getPreviousTile() returns the last tile in the selected ArrayList
      @return previous tile
   */
   public Tile getPreviousTile()
   {
      Tile previousTile = selected.get(selected.size()-1);
      return previousTile;
   }
   /**
      getTile method returns the tile being chosen by the user
      @param row current row user has selected
      @param column current column user has selected
      @return requested tile
   */
   public Tile getTile(int row, int column)
   {
      Tile tilePicked = ((gameBoard.get(row)).get(column));
      return tilePicked;
   }
   /**
      clearSelected method empties the selected array of tiles
   */
   public void clearSelected()
   {
      selected.clear();
   }
   /**
      testSelected method tests if the contents within
      the selected array from a valid word. If it does it adds the score
      of the word to total score and clears selected array. 
   */
   public void testSelected() throws IOException
   {
      Dictionary dict = new Dictionary("dictionary.txt");
      String validWord = "";
      if (dict.isValidWord(selected))
      {
         for (int i = 0; i < selected.size(); i++)
         {
            validWord += selected.get(i);
            
         }
         if (!words.contains(validWord))
         {
            words.add(validWord);
            Word w = new Word(selected); 
            score += w.getPoints();
            
         }
         else
            wordUsed = true;
      }
   }
   /**
      getWordUsed returns a boolean value indicating whether or not 
      the word being tested has already been used
      @return whether or not word's been used
   */
   public boolean getWordUsed()
   {
      return wordUsed;
   }
   /**
      setWordUsed() is used to reset the flag wordUsed
   */
   public void setWordUsed()
   {
      wordUsed = false;
   }
   /**
      getScore() returns the score the user has
      @return score value
   */
   public int getScore()
   {
      return score;
   }
   /**
      getWords returns the arraylist of valid words submitted by user
      @return valid words played
   */
   public ArrayList<String> getWords()
   {
      return words;
   }
   /**
      toString method returns the board being used to play the game
      as well as information about the ongoing game including
      currently selected tiles
      words tested
      total score
      @return game information
   */
   @Override
   public String toString()
   {      
      return board.toString() + "\n\n selected"+ selected + "\n\n words: " + words + "\n\n score: " + score + "\n";
   }
}