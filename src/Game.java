import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

/**
 * Created by germinolegrand on 27/02/14.
 */
///////// des commentaires s'il te plait ?????
public class Game implements Drawable {


    private Map currentMap;
    private Score score;
    private int lvl;

    public Game(Map currentMap, int lvlnb) {
        this.currentMap = currentMap;
        this.score = new Score();
        this.lvl = lvlnb;
    }

    public void start(){
        try {
            Scanner sc = new Scanner(System.in);
            score.goChrono();
            //Tant que le level n'est pas résolu
            while(!currentMap.isSolved()) {
                //Si un caractère a été entré
                String s = sc.nextLine();

                if(s.length() == 0)
                    continue;

                //On joue l'action correspondante
                playerCommand(s.charAt(0));

                //On affiche le jeu
                draw(System.out);
            }
            score.stopChrono();
            score.save_score(lvl);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    Execute l'action correspondante au caractère
     */
    private void playerCommand(char b) throws IOException {
        switch (b){
            case 'q': goLeft();     break;
            case 'd': goRight();    break;
            case 'z': goUp();       break;
            case 's': goDown();     break;
            default: /*rien*/       break;
        }
    }

    private void goLeft() {

    }

    private void goRight() {

    }

    private void goUp() {

    }

    private void goDown() {

    }

    @Override
    public void draw(OutputStream os) throws IOException {
        currentMap.draw(os);
    }
}
