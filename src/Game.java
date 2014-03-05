import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

/**
 * Created by germinolegrand on 27/02/14.
 */
///////// des commentaires s'il te plait ?????
public class Game implements Drawable {

    private Map currentLevel;
    private  Score score;

    public Game(Map currentLevel) {
        this.currentLevel = currentLevel;
        this.score = new Score();
    }

    public void start(){
        try {
            Scanner sc = new Scanner(System.in);
            score.goChrono();
            //Tant que la level n'est pas résolu
            while(!currentLevel.isSolved()) {
                //Si un caractère a été entré
                if(sc.hasNextByte()) {
                    Byte b = sc.nextByte();

                    //On joue l'action correspondante
                    playerCommand(b);

                    //On affiche le jeu
                    draw(System.out);
                }
            }
            score.stopChrono();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    Execute l'action correspondante au caractère
     */
    private void playerCommand(Byte b) throws IOException {
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
        currentLevel.draw(os);
    }
}
