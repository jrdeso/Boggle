// Jordan Deso
// CS 110
// BoggleGUI runs the actual display of boggle game played by 
// the user. 
import javafx.application.Application; 
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Node;

import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

import javax.swing.JOptionPane;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.geometry.Pos;

import javafx.geometry.Insets;
import java.util.ArrayList;
import java.io.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BoggleGUI extends Application
{
   // Game variables to run functions within the game
   private Game game;
   
   // Grid Pane holds tiles of letters
   private GridPane grid;
   private BorderPane display;
   
   // Buttons & holdButtons - pane also holds user's score
   private HBox holdButtons;
   private Button endGame;
   private Button newGame;
   private Button testTiles;
   private Button directions;
   private Text displayScore;
   
   // VBox to hold words that have been tested and display updated score each time
   private VBox wordsPane;
   private Text wordsHeader;
   private Text wordsUsed;
   private Text selectedTiles;
   private String tilesSelected = "";
   private Text tilesHeader;
   
   // text for Title of game
   private Image title;
   private HBox titlePane;
   private ImageView viewTitle;
   
   // text for notifications
   private Text status;
   private VBox notifications;
   private Text notificationsHeader;
   
   @Override 
   public void start(Stage stage) throws IOException
   {
      Dictionary dict = new Dictionary("dictionary.txt");
      
      display = new BorderPane();
      display.setPrefSize(1500,850);
      
      stage.setTitle("Boggle");
      // Boggle Title
      title = new Image("Boggle Logo.png", 780, 190, false, false);
      viewTitle = new ImageView(title);
      
      titlePane = new HBox(40);
      titlePane.setPadding(new Insets(0, 0, 20, 0));
      titlePane.setAlignment(Pos.CENTER);
      titlePane.getChildren().add(viewTitle);
      titlePane.setStyle("-fx-background-color: LIGHTSKYBLUE");
      display.setTop(titlePane);
      
      // add grid to display
      grid = new GridPane();
      grid.setAlignment(Pos.CENTER);
      grid.setStyle("-fx-background-color: LIGHTSKYBLUE");
      display.setCenter(grid);
      
      game = new Game();
      displayBoard();
      
      // create notifications VBox
      notificationsHeader = new Text("Notifications:");
      notificationsHeader.setFont(Font.font("impact", 55));
      
      notifications = new VBox();
      notifications.setPadding(new Insets(20, 30, 20, 20));
      notifications.setStyle("-fx-background-color: LIGHTSKYBLUE");
      notifications.setAlignment(Pos.TOP_LEFT);
      status = new Text("");
      status.setFont(Font.font("Arial", 28));
      notifications.getChildren().add(notificationsHeader);
      notifications.getChildren().add(status);
      // add notifications to BorderPane
      display.setRight(notifications);
      
      // Create VBox for words used 
      tilesHeader = new Text("Selected Tiles:");
      tilesHeader.setFont(Font.font("impact", 45));
      
      selectedTiles = new Text("");
      selectedTiles.setFont(Font.font("impact", 35));
      
      wordsHeader = new Text("\nValid Words Tested: ");
      wordsHeader.setFont(Font.font("impact", 45));
      
      wordsPane = new VBox();
      wordsPane.setStyle("-fx-background-color: LIGHTSKYBLUE");
      wordsPane.setPadding(new Insets(30, 0, 20, 20));
      wordsUsed = new Text("");
      wordsUsed.setFont(Font.font("Arial", 20));
      
      wordsPane.getChildren().add(tilesHeader);
      wordsPane.getChildren().add(selectedTiles);
      wordsPane.getChildren().add(wordsHeader);
      wordsPane.getChildren().add(wordsUsed);
      display.setLeft(wordsPane);
      
      // Edit button pane and buttons
      holdButtons = new HBox(60);
      holdButtons.setPadding(new Insets(30, 20, 20, 20));
      holdButtons.setStyle("-fx-background-color: LIGHTSKYBLUE");
      
      endGame = new Button("End Game");
      endGame.setFont(Font.font ("Arial", 25));
      
      newGame = new Button("New Game");
      newGame.setFont(Font.font ("Arial", 25));
      
      testTiles = new Button("Test Selected");
      testTiles.setFont(Font.font ("Arial", 25));
      
      directions = new Button("Directions");
      directions.setFont(Font.font ("Arial", 25));
      
      displayScore = new Text("Current Score: "+ game.getScore());
      displayScore.setFont(Font.font("impact", 40));
      
      // End game process
      endGame.setOnAction(new EventHandler<ActionEvent>() 
      {
         public void handle(ActionEvent e)
         {
            // end program and show user final score 
            JOptionPane.showMessageDialog(null, "Thank You for Playing!\n Your Final Score was: " + game.getScore());
            Platform.exit();
         }
       }
       );
       // process of testing tiles
       testTiles.setOnAction(new EventHandler<ActionEvent>() 
       {
         public void handle(ActionEvent e)
         {
            // test selected tiles
            try {game.testSelected(); }
            catch (IOException error) {}
            
            if(game.getWordUsed())
            {
               status.setText("You have already played that word");
               game.setWordUsed();
            }
            
            // inform user if word tested is not a valid word
            if (dict.isValidWord(game.getSelectedTiles()))
            {
               game.clearSelected();
               selectedTiles.setText("");
               tilesSelected = "";
            }
            else
            {
               game.clearSelected();
               status.setText("The word you entered \nis not a valid word.\nPlease try again.  ");
               selectedTiles.setText("");
               tilesSelected = "";
            }
            // adjust current score 
            displayScore.setText("Current Score: "+ game.getScore());
            
            ArrayList<String> words = game.getWords();
            String wordsPlayed = "";
            displayBoard();
            // Display word that was used 
            for (int i = 0; i < words.size(); i++)
            {
                  wordsPlayed += (words.get(i) + "\n");
            }
            wordsUsed.setText(wordsPlayed.toUpperCase());
         }
       }
       );
       // process for creating a new game
       newGame.setOnAction(new EventHandler<ActionEvent>() 
       {
         public void handle(ActionEvent e)
         {
            game = new Game();
            displayScore.setText("Current Score: "+ game.getScore());
            displayBoard();
            status.setText("");
            wordsUsed.setText("");
            selectedTiles.setText("");
            tilesSelected = "";
         }
       }
       );
       // when clicked on displays game instructions
       directions.setOnAction(new EventHandler<ActionEvent>()
       {
         public void handle(ActionEvent e)
         {
            String gameDirections = ("Boggle is a game where the player is presented with a random \n" +
                                      "4x4 board of letters. \n\n" + 
                                      "The objective of the game is that the player form as many \n" + 
                                      "words as possible starting with any letter on the board \n" + 
                                      "following any adjacent letter. (adjacent meaning any \n" +
                                      "two letter next to each other in a row, column, or diagonally) \n\n" +
                                      "When the player has formed a word they can test it to see if \n" +
                                      "it is a valid word. If it is a valid word it will be added to \n" +
                                      "the total score depending on the length of the word.\n\n" +
                                      "Scoring Guide:\n" +
                                      "3 letters = 1 point\n" +
                                      "4 letters = 1 point\n" +
                                      "5 letters = 2 points\n" +
                                      "6 letters = 3 points\n" +
                                      "7 letters = 5 points\n" +
                                      "8 or more letters = 11 Points");
            JOptionPane.showMessageDialog(null, gameDirections);
         }
       }
       );
       // Put buttons in pane 
       holdButtons.getChildren().add(displayScore);
       holdButtons.getChildren().add(newGame);
       holdButtons.getChildren().add(testTiles);
       holdButtons.getChildren().add(endGame);
       holdButtons.getChildren().add(directions);
       
       display.setBottom(holdButtons);
       
       Scene scene = new Scene(display);
       stage.setScene(scene);
       stage.show();
   }
   
   public void tileSelected(MouseEvent e)
   {
      
      TilePane tp = (TilePane)(e.getSource());
      if (game.isValidSelection(tp.getTpRow(),tp.getTpCol()))
      {  
         if (tp.getTpSelected() == false)
         {
            // add selected tiles to selected list
            game.addToSelected(tp.getTpRow(),tp.getTpCol());
            tp.setSelected();
            // clear previous error message if there was one
            status.setText("");
            tilesSelected += (game.getPreviousTile()).toString() + " ";
            selectedTiles.setText(tilesSelected);
         }
         // tile was previously selected and user clicks on it again
         // unselect that tile 
         else if (tp.getTpSelected() == true)
         {
            if (tp.getTpTile() == game.getPreviousTile())
            {
               tp.setUnselected();
               game.removeFromSelected(tp.getTpRow(),tp.getTpCol());
               tilesSelected = "";
               for (int i = 0; i < game.getSelectedTiles().size(); i++)
                  tilesSelected += game.getSelectedTiles().get(i);
               selectedTiles.setText(tilesSelected);
            }
         }
      }
      else
      {
         // display error message if invalid selection
         status.setText("Invalid Selection, select \na letter adjacent to \npreviously selected tile");
      }
   }
   // Creates boggle Board
   public void displayBoard()
   {
      grid.getChildren().clear();
      // four rows of boggle
      for (int row = 0; row < 4; row++)
         for (int column = 0; column < 4; column++)
         {
            TilePane tp = new TilePane(game.getTile(row,column));
            if(game.isValidSelection(tp.getTpRow(),tp.getTpCol()))
               tp.setOnMouseClicked(this::tileSelected);
            grid.add(tp,column,row);
         }
   }

   public static void main(String[] args)
   {
      launch(args);
   }
}