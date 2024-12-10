public class Olympic {
  /**
  * Instance Variables: country, gold, silver, bronze
  */
  private String country;
  private int gold;
  private int silver;
  private int bronze;
  
  /**
  * This is the parameterized constructors that assigns specific values using the "this" word
  */
  public Olympic(String country, int gold, int silver, int bronze) {
    this.country = country;
    this.gold = gold;
    this.silver = silver;
    this.bronze = bronze;
  }
  /**
  * These are the getter methods also known as the accessor methods. 
  * They get the values of the user and return it. example: country, gold, silver, and bronze
  */
  public String getCountry() {
    return country;
  }

  public int getGold(){
    return gold;
  }

   public int getSilver(){
    return silver;
  }

   public int getBronze(){
    return bronze;
  }
  
}
