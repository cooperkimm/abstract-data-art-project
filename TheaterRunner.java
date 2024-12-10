import org.code.theater.*;
// Cooper and Gabriel Partners
public class TheaterRunner {
  public static void main(String[] args) {
    
    // Instantiate a DataScene object to play in the Theater
    DataScene scene = new DataScene();
    
    // Call any DataScene methods to diplay
    scene.drawScene();
    
    // Play the DataScene in the theater
    Theater.playScenes(scene);
    
  }
}
