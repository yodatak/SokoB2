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

    public void delete_score(){


        score = 0;
    }
    public void save_score(int score){

        setScore(score);
    }


}
