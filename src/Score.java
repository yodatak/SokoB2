import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

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
    public void save_score(int level, int current_level) throws IOException {
        double[][] levels = new double[0][];


        BufferedReader lecteurFichier = null;
        lecteurFichier = new BufferedReader(new FileReader("score.txt"));
           String line;
        int lvls = Integer.parseInt(lecteurFichier.readLine());
        while ((line = lecteurFichier.readLine()) != null)
        {
            for (int i = 0; i <= current_level; i++)
            {
                for (int j = 0; j <= levels[i].length; i++)
                {
                    if(levels[i][j] != 0){
                        levels[i][j] = chrono / 1000;
                    }
                }
            }
            System.out.println(score);
        }
        lecteurFichier.close(); // toujours fermer le fichier
    }


}
