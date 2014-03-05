import java.io.*;
import java.util.concurrent.atomic.AtomicLong;


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
    public void save_score( int currentLevel) throws IOException {
        /*
        double[][] levels = new double[current_level][];
        BufferedWriter write = null;
        write = new BufferedWriter(new FileWriter("score.txt"));
           String line="";
        int lvls = Integer.parseInt(write.writeLine());
        while ((line = write.FileWriter()) != null)
        {

                for (int j = 0; j <= levels[current_level].length; j++)
                {
                    if(levels[current_level][j] != 0){
                        levels[current_level][j] = chrono / 1000;
                    }

                }

            System.out.println(line);
        }
        write.close(); // toujours fermer le fichier
        */
        /* compte le nombre de lignes dans mon fichier
        FileInputStream fis = new FileInputStream("score.txt");
        LineNumberReader l = new LineNumberReader(
                new BufferedReader(new InputStreamReader(fis)));
        int count = 0;
        while ((str=l.readLine())!=null)
        {
            count = l.getLineNumber();
        }
        System.out.println(count);
        */
        FileWriter monFichier = null;
        BufferedWriter tampon = null;
        String[] scores = new String[currentLevel];

        // Entre des scores dans le tableau


        try {
            monFichier = new FileWriter("c:\\score.txt",true);//on ajoute les scores avec "ture"
            tampon = new BufferedWriter(monFichier);
            String saved = ("level :"+currentLevel+" highest score "+ score+"\n");


                tampon.write(saved);

                //System.out.println("Ecriture de : " + saved[i]);

          //  System.out.println("Ecriture du fichier terminée.");

        } catch (IOException exception) {
            exception.printStackTrace();
        } finally {
            try {
                tampon.flush();
                tampon.close();
                monFichier.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }


}
