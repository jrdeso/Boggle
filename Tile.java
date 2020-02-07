// Jordan Deso
// CS 110
// Tile class represents a tile on the 4x4 board of boggle. 
// It stores the letter, row and column of the tile.
// It also has a flag that indicates if the tile was selected 
public class Tile
{  
   // Create variables
   private char letter;
   private int row;
   private int column;
   private boolean tileSelected = false;
   
   /**
      Constructor accepts a character and sets the letter
      as well as the row and column value
      @param letter is the letter on tile
      @param row is row letter is in
      @param column is the column the letter is in
   */
   public Tile(char letter, int row, int column)
   {
      this.letter = letter;
      this.letter = Character.toUpperCase(this.letter);
      this.row = row;
      this.column = column;     
      tileSelected = true;
   }
   
   /**
      Constructor accepts a string and sets the letter
      as well as the row and column value
      @param letter is the letter on tile
      @param row is row letter is in
      @param column is the column the letter is in
   */
   public Tile(String letter, int row, int column)
   {
      // Save the string as a character (if "Qu" only saves 'Q")
      this.letter = letter.charAt(0);
      this.letter = Character.toUpperCase(this.letter);
      this.row = row;
      this.column = column;
      tileSelected = true;
   }
   /**
      getRow returns the row of the tile
      @return row location
   */
   public int getRow()
   {
      return row;
   }
   /**
      getColumn returns the column of the tile
      @return column location
   */
   public int getColumn()
   {
      return column;
   }
   /**
      toString method returns the letter on the tile
      Note: if the letter is Q, returns QU
   */
   public String toString()
   {
      String tile;
      // If the tile is 'Q' return "Qu"
      if (letter == 'Q')
      {
         tile = "Qu";
         return tile;  
      }
      tile = letter+"";
      return tile;
   }
}