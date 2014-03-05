import java.util.ArrayList;
import java.util.List;
//implémentation des vectors

/**
 * Created by Lachenayefred on 27/02/14.
 */

public class Map implements Drawable {

    private int hauteur ;
    private int largeur ;
    List<Cell> tab=new ArrayList<Cell>();
    /////////////////attributs de class map

    public void set_Haut(int hauteur) { //////////// set hauteur
        this.hauteur = hauteur;
    }

    public void set_Larg(int largeur) { /////////// set largeur
        this.largeur = largeur;
    }

    public int get_Haut() {   /////////////// get hauteur
        return hauteur;
    }

    public int get_Larg() { //////////// get largeur
        return largeur;
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
        Score.Stop_Chrono();
        return true;

    }

    @Override
    public void draw() {

    }

    //draw sera faite ce soir :)
}



