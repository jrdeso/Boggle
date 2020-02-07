// TilePane class creates the TilePane for each individual
// Tile on the board
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class TilePane extends HBox
{
   // know row and column of tile
   private int row;
   private int col;
   private Tile tile;
   private Text letter = new Text();
   private boolean tpSelected = false;
   /**
      default construction accepts a tile and records row and column values
      it then sets it to a default black letter
      @param tile being created
   */
   public TilePane(Tile tile)
   {
      super();
      this.tile = tile;
      // edit text objects to be displayed
      letter.setText(tile.toString());
      letter.setFont(Font.font ("impact", 85));
      letter.setFill(Color.BLACK);
      // get column values associated from tile 
      row = tile.getRow();
      col = tile.getColumn();
      
      this.setAlignment(Pos.CENTER);
      this.setPrefSize(150,150);
      this.setStyle("-fx-border-width: 10; -fx-border-color: GOLD;");
      this.getChildren().add(letter);
   }
   /**
      getTpTile returns the tile created
      @return created tile
   */
   public Tile getTpTile()
   {
      return tile;
   }
   /** 
      getTpRow returns the row of specific tile
      @return row of tile
   */
   public int getTpRow()
   {
      return row;
   }
   /** 
      getTpCol returns the col of specific tile
      @return col of tile
   */   
   public int getTpCol()
   {
      return col;
   }
   /**
      setSelected method visually indicates that the tile
      was selected by the user
   */
   public void setSelected()
   {
      
      letter.setFont(Font.font ("impact", 85));
      letter.setFill(Color.GOLD);
      tpSelected = true;
   }
   /**
      setUnselected method visually indciates the tile isn't 
      selected
   */
   public void setUnselected()
   {
      
      letter.setFont(Font.font ("impact", 85));
      letter.setFill(Color.BLACK);
      tpSelected = false;
   }
   /**
      getTpSelected returns a boolean value indicating whether or not the tile
      has been selected or not. 
   */
   public boolean getTpSelected()
   {
      return tpSelected;
   }
}