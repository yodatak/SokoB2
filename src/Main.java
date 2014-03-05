import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by germinolegrand on 05/03/14.
 */
public class Main {

    public static void main (String[] args)  {
        System.out.println("Hello World");
        try{
        FileWriter fileScore = new FileWriter(new File("score.txt"), true);
            FileWriter fileMap = new FileWriter(new File("levels.sok"), true);
        }catch (IOException e) {
            e.printStackTrace();
        }
        if(args.length >= 1 && args[0].equals("--create")){
            //mode editeur
        }else{
            //mode jeu
            Map level = new Map();

            if(args.length >= 2 && args[0].equals("--level")){
                //On charge le niveau demandé
                System.out.println("Play level" + args[1]);
            }else{
                //On charge le premier niveau
                try {
                    level.load(System.in);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            Game game = new Game(level);

            //On lance le jeu
            game.start();
            //on lance le chrono pour le score

        }
    }
}
