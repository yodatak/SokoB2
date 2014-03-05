/**
 * Created by yodatak on 27/02/14.
 */
class Main {
    //please met des commentaires !!!!!!!!!
    public static void main (String[] args){
        System.out.println("Hello World");

        if(args.length >= 1 && args[0].equals("--create")){
            //mode editeur
        }else{
            //mode jeu
            Map level = null;

            if(args.length >= 2 && args[0].equals("--level")){
                //On charge le niveau demandé
                System.out.println("Play level" + args[1]);
            }else{
                //On charge le premier niveau
            }

            Game game = new Game(level);

            //On lance le jeu
            game.start();
            //on lance le chrono pour le score

        }
    }
}