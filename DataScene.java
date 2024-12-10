import org.code.theater.*;
import org.code.media.*;

/**
 * Represents a Scene to be played in the Theater using data from
 * a chosen dataset
 */
public class DataScene extends Scene {
  /**
  * Instance variables
  */
  private Olympic[] olympics;        

  /** Constructor */
  public DataScene() {
    olympics = createOlympics();
  }
  /**
  * File Reader methods also known as Static methods; This goes through all 5 files and gets the country name,
  * gold medals, silver medals, and bronze medals.
  */
  public Olympic[] createOlympics() {
    String[] countryArray = FileReader.toStringArray("country.txt");
    int[] goldArray = FileReader.toIntArray("gold.txt");
    int[] silverArray = FileReader.toIntArray("silver.txt");
    int[] bronzeArray = FileReader.toIntArray("bronze.txt");

    Olympic[] olympicsArray = new Olympic[countryArray.length];
    /**
    * Traverses the olympicsArray which is the country array. 
    * olympicsArray[i] has the country, gold, silver, and bronze array.
    */
    for(int i = 0; i < olympicsArray.length; i++){
      olympicsArray[i] = new Olympic(countryArray[i], goldArray[i], silverArray[i], bronzeArray[i]);
    }
    return olympicsArray;
  }

  /**
   * Top-level method to draw the animation, including the drawBackground, drawMedal, 
   * styleApply, and moreInfo method, using an enhanced for loop
   */
  public void drawScene() {
    for(Olympic o : olympics){
      String country = o.getCountry();
      int gold = o.getGold();
      int silver = o.getSilver();
      int bronze = o.getBronze();
      
      drawBackground(gold);
      drawMedal(gold);
      
      styleApply();
      moreInfo(country, gold, silver, bronze);
      
      pause(0.5);
    }
  }

  /**
   * drawBackground method that uses the conditonal statements to output a specific background 
   * color and olympic rings
   */
  public void drawBackground(int gold){
      if(gold > 9){
        clear(Color.GOLD);
        drawImage("olympics.png", 100, 5, 200);
      } else if (gold <= 9 && gold >= 2) {
        clear(Color.SILVER);
        drawImage("olympics.png", 100, 5, 200);
      } else if(gold < 2){
        clear(Color.TAN);
        drawImage("olympics.png", 100, 5, 200);
      }
  }
   /**
   * drawMedal method that uses the conditonal statements to output a specific image/medal
   */
  public void drawMedal(int gold){
     if(gold > 9){
        drawImage("gold.jpg", 70, 110, 250);
      } else if (gold <= 9 && gold >= 2) {
        drawImage("silver.jpg", 75, 110, 250);
      } else if(gold < 2){
        drawImage("bronze.jpg", 165, 120, 65);
      }
  }
   /**
   * styleApply method that sets the text style, height, and color
   */
  public void styleApply(){
    setTextStyle(Font.SANS, FontStyle.BOLD);
    setTextHeight(25);
    setTextColor("black");
  }
   /**
   * moreInfo method that outputs text for the country, total medals, and gold medals squared
   */
  public void moreInfo(String country, int gold, int silver, int bronze){
    drawText(country, 140, 305);
    drawText("Total Medals: " + (gold + silver + bronze), 90, 345);
    drawText("Gold Squared: " + Math.pow(gold, 2), 70, 380);
  }
}
