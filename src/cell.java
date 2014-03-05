/**
 * Created by yoyonice on 03/03/14.
*/
public abstract class Cell implements Drawable {
    private static int type; //type paire pour les cell qui bougent et impair pour celles qui sont immobilent
    Cell wall; //type == 1
    Cell player; // type ==2
}
