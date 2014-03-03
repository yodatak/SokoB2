/**

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
