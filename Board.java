// Jordan Deso
// CS 110
// The board class creates the board that will be shown
// to the user in the game boggle by randomly selecting a letter
// in each spot of the 4x4 board
import java.util.ArrayList;
import java.util.Random;
public class Board
{
   // Create the sixteen dice used in Boggle
   private static ArrayList<String> die1 = new ArrayList<String>(6);
   private static ArrayList<String> die2 = new ArrayList<String>(6);
   private static ArrayList<String> die3 = new ArrayList<String>(6);
   private static ArrayList<String> die4 = new ArrayList<String>(6);
   private static ArrayList<String> die5 = new ArrayList<String>(6);
   private static ArrayList<String> die6 = new ArrayList<String>(6);
   private static ArrayList<String> die7 = new ArrayList<String>(6);
   private static ArrayList<String> die8 = new ArrayList<String>(6);
   private static ArrayList<String> die9 = new ArrayList<String>(6);
   private static ArrayList<String> die10 = new ArrayList<String>(6);
   private static ArrayList<String> die11 = new ArrayList<String>(6);
   private static ArrayList<String> die12 = new ArrayList<String>(6);
   private static ArrayList<String> die13 = new ArrayList<String>(6);
   private static ArrayList<String> die14 = new ArrayList<String>(6);
   private static ArrayList<String> die15 = new ArrayList<String>(6);
   private static ArrayList<String> die16 = new ArrayList<String>(6);
   // create ArrayList to hold all Dice
   private static ArrayList<ArrayList> dice = new ArrayList<>();
   // Create board array
   private  ArrayList<ArrayList<Tile>> board = new ArrayList<>(4);
   
   /**
      default constructor creates the 16 die used in boggle and stores all of 
      their contents in one array. Randomly selects an order of dice to be submitted
      as tiles to create a 4x4 board. 
   */
   public Board()
   {
      // Create Die One
      die1.add("R"); die1.add("I"); die1.add("F"); die1.add("O"); die1.add("B"); die1.add("X");
      // Create Die Two
      die2.add("I"); die2.add("F"); die2.add("E"); die2.add("H"); die2.add("E"); die2.add("Y");
      // Create Die Three
      die3.add("D"); die3.add("E"); die3.add("N"); die3.add("O"); die3.add("W"); die3.add("S");
      // Create Die Four
      die4.add("U"); die4.add("T"); die4.add("O"); die4.add("K"); die4.add("N"); die4.add("D");
      // Create Die Five
      die5.add("H"); die5.add("M"); die5.add("S"); die5.add("R"); die5.add("A"); die5.add("O");
      // Create Die Six
      die6.add("L"); die6.add("U"); die6.add("P"); die6.add("E"); die6.add("T"); die6.add("S");
      // Creat Die Seven
      die7.add("A"); die7.add("C"); die7.add("I"); die7.add("T"); die7.add("O"); die7.add("A");
      // Create Die Eight
      die8.add("Y"); die8.add("L"); die8.add("G"); die8.add("K"); die8.add("U"); die8.add("E");
      // Create Die Nine
      die9.add("Qu"); die9.add("B"); die9.add("M"); die9.add("J"); die9.add("O"); die9.add("A");
      // Create Die Ten
      die10.add("E"); die10.add("H"); die10.add("I"); die10.add("S"); die10.add("P"); die10.add("N");
      // Create Die Eleven
      die11.add("V"); die11.add("E"); die11.add("T"); die11.add("I"); die11.add("G"); die11.add("N");
      // Create Die Twelve
      die12.add("B"); die12.add("A"); die12.add("L"); die12.add("I"); die12.add("Y"); die12.add("T");
      // Create Die Thirteen
      die13.add("E"); die13.add("Z"); die13.add("A"); die13.add("V"); die13.add("N"); die13.add("D");
      // Create Die Fourteen
      die14.add("R"); die14.add("A"); die14.add("L"); die14.add("E"); die14.add("S"); die14.add("C");
      // Create Die Fifteen
      die15.add("U"); die15.add("W"); die15.add("I"); die15.add("L"); die15.add("R"); die15.add("G");
      // Create Die Sixteen
      die16.add("P"); die16.add("A"); die16.add("C"); die16.add("E"); die16.add("M"); die16.add("D");
      // File dice with all of the dice
      dice.add(die1); dice.add(die2); dice.add(die3); dice.add(die4); dice.add(die5); dice.add(die6); 
      dice.add(die7); dice.add(die8); dice.add(die9); dice.add(die10); dice.add(die11); dice.add(die12); 
      dice.add(die13); dice.add(die14); dice.add(die15); dice.add(die16); 
   
      // Create variables
      Random r = new Random();
      
      // possibleRoll holds contents of randomDie the was rolled and will be used
      // to randomly select a letter from that Die
      ArrayList<String> possibleRoll = new ArrayList<String>(6);
     
      for (int rw = 0; rw < 4; rw++)
      {
         ArrayList<Tile> row = new ArrayList<>(4);
         for (int cl = 0; cl < 4; cl++)
         {
             // choose a random die and letter to be read 
            int randomDie = r.nextInt(dice.size());
            int randomLetter = r.nextInt(5);
            // Store contents of random die
            possibleRoll = dice.get(randomDie);
            // Remove dice so that it"s not reused
            dice.remove(randomDie);
            // get random letter from that dice
            String letter = possibleRoll.get(randomLetter); 
            possibleRoll.clear();
            // put tile in row
            row.add(new Tile(letter, rw, cl));

         }
         board.add(row);
      }
   }   
   
   /**
      getBoard method returns the board arrayList containing all of the Tiles 
      in the randomly created baord
      @return board ArrayList of tiles
   */
   public ArrayList<ArrayList<Tile>> getBoard()
   {
      return board;
   }
   
   /**
      toString displays the contents of the board 
   */
   @Override
   public String toString()
   {
      // String to be returned - holds contents of the board
      String displayBoard = "";
      // temporarily holds each letter from board array
      String tempLetter = "";
      // Sort through rows
      for (int i = 0; i < 4; i++)
      {
         // Sort through columns
         for (int j = 0; j < 4; j++)
         {
            tempLetter += (board.get(i)).get(j);
            // Conditional to handle QU
            if (tempLetter.equals("QU"))
            {
               tempLetter = "Qu";
               displayBoard += tempLetter + " ";
            }
            else
               displayBoard += tempLetter + "  ";
            tempLetter = "";
         }
         // Print new row
         displayBoard += "\n"; 
      }
      return displayBoard;
   }
}