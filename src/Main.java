import com.sun.java.util.jar.pack.*;
import java.lang.Package;

import java.io.*;


public class Main {

    public static void main (String[] args)  {
        //System.out.println("Hello World");
        try{
        FileWriter monFichier = null;
        BufferedWriter tampon = null;
            monFichier = new FileWriter("score.txt");
        //fichiers des maps ouverts en version "ajout"
        File fileMap = new File("levels.sok");
        tampon = new BufferedWriter(monFichier);

        if(args.length >= 1 && args[0].equals("--create")){
            //mode editeur
            Map map = new Map();
            try(FileOutputStream fis = new FileOutputStream(fileMap, true)) {
                map.load(System.in, "P");
                map.draw(fis);
            } catch (IOException e) {
                e.printStackTrace();
            }
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

            try(FileInputStream fis = new FileInputStream(fileMap)) {
                for(int lvlCount = 1; lvlCount < lvlnb; ++lvlCount){
                    map.fakeLoad(fis);
                }

                map.load(fis, "");
            } catch (IOException e) {
                e.printStackTrace();
            }

            //le game a deux paramètres une map et le n° du level
            Game game = new Game(map, lvlnb);

            //On lance le jeu
            game.start();
        }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
