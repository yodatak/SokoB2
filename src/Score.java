/**

 */
public class Score {
    // Fonctions pour le chronometre
      private  long chrono = 0 ;

    // Lancement du chrono
     public  void goChrono() {
        chrono = java.lang.System.currentTimeMillis() ;
    }

    // Arret du chrono
     public  void stopChrono() {
        long chrono2 = java.lang.System.currentTimeMillis() ;
        long temps = chrono2 - chrono ;
        setScore(temps) ;
    }
    public long getScore() {
        return score;
    }

    public  void setScore(long score) {
        score = score;
    }

    private long score;

    public void delete_score(){
        score = 0;
    }
    public void save_score(long score){
        getScore();
    }


}
