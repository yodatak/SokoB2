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
            //fichiers des scores et des maps ouvert en version "ajout"
        FileWriter fileScore = new FileWriter(new File("score.txt"), true);
            FileWriter fileMap = new FileWriter(new File("levels.sok"), true);
        }catch (IOException e) {
            e.printStackTrace();
        }
        if(args.length >= 1 && args[0].equals("--create")){
            //mode editeur
        }else{
            //mode jeu
            Map map1 = new Map();
            int lvlnb = 1; //le numero du level util dans la classe game et dans score
            if(args.length >= 2 && args[0].equals("--level")){
                //On charge le niveau demandé dans le tab arg[]
                System.out.println("Play level" + args[1]);
                lvlnb = Integer.parseInt(args[1]);
            }else{
                //On charge le premier niveau
                try {
                    map1.load(System.in);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            Game game = new Game(map1, lvlnb);

            //On lance le jeu
            game.start();
            //on lance le chrono pour le score

        }
    }
}
