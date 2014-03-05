import java.io.*;

/**
 * Created by germinolegrand on 05/03/14.
 */
public class Main {

    public static void main (String[] args)  {
        System.out.println("Hello World");
        //fichiers des maps ouverts en version "ajout"
        File fileMap = new File("levels.sok");

        if(args.length >= 1 && args[0].equals("--create")){
            //mode editeur
        }else{
            //mode jeu
            Map map = new Map();
            int lvlnb = 1; //le numero du level util dans la classe game et dans score
            if(args.length >= 2 && args[0].equals("--level")){
                //On charge le niveau demandé dans le tab arg[]
                System.out.println("Play level" + args[1]);
                //args est un tab de string donc -->
                lvlnb = Integer.parseInt(args[1]);
            }

            for(int lvlCount = 1; lvlCount < lvlnb; ++lvlCount){
                try {
                    map.fakeLoad(new FileInputStream(fileMap));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }

            try {
                map.load(new FileInputStream(fileMap));
            } catch (IOException e) {
                e.printStackTrace();
            }

            //le game a deux paramètres une map et le n° du level
            Game game = new Game(map, lvlnb);

            //On lance le jeu
            game.start();
            //on lance le chrono pour le score

        }
    }
}
