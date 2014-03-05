import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Lachenayefred on 27/02/14.
 */

public class Map implements Drawable {

    private int height;
    private int width;
    private ArrayList<Cell> tab;
    /////////////////attributs de class map

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    /*
    Charge une map en mémoire
     */
    public void load(InputStream is) throws IOException {
        Scanner sc = new Scanner(is);

        tab = new ArrayList<Cell>();

        String line = null;

        do{
            //On récupère la ligne
            line = sc.nextLine();

            if(width == 0)//Si on n'a pas encore récupéré la largeur
                width = line.length();
            else if(line.length() >0 && width != line.length())//Si la largeur a changé
                throw new IOException("All lines are not same length");

            //Pour chaque caractère de la ligne
            for(int j = 0; j < line.length(); ++j){
                Cell cell = null;
                switch(line.charAt(j)){
                    case '=': cell = new Wall(); break;
                    case ' ': cell = new Blank(); break;
                    case 'X': cell = new Player(); break;
                    case 'Y': cell = new PlayerOnStorage(); break;
                    case 'O': cell = new StorageLocation(); break;
                    case 'B': cell = new Box(); break;
                    case 'D': cell = new BoxOnStorage(); break;
                    default: throw new IOException("Unknown Cell type " + line.charAt(j));
                }
                //On ajoute une cellule
                tab.add(cell);
            }
        }while(line.length() > 0);

        //On calcule la hauteur en fonction du nombre total de cellules
        height = tab.size()/width;
    }

    /*
    Détermine si la map est résolue
     */
    public boolean isSolved() {
        for(Cell c : tab){
            //Si on trouve une StorageLocation la map n'est pas résolue
            if(c instanceof StorageLocation)
                return false;
        }
        //Dans le cas où il n'y a plus aucune StorageLocation, la map est résolue
        return true;
    }

    @Override
    public void draw(OutputStream os) throws IOException {
        for(int i = 0; i < height; ++i){
            for(int j = 0; j < width; ++j){
                tab.get(i * width + j).draw(os);
            }
            os.write('\n');
        }
    }
}



