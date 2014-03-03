/**
 * Created by yoyonice on 01/03/14.
 * Score

 scoring
 etat

 start()
 stop()
 save()
 delete_scores()
 */
public class Score {
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    private int score;

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    private int etat;
}
