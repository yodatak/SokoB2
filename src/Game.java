import java.io.IOException;
import java.util.Scanner;

/**
 * Created by germinolegrand on 27/02/14.
 */
///////// des commentaires s'il te plait ?????
public class Game implements Drawable {

    private Map currentLevel;

    public Game(Map currentLevel) {
        this.currentLevel = currentLevel;
    }

    public void start(){
        try {
            Scanner sc = new Scanner(System.in);
            int read = System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void draw() {

    }
}
