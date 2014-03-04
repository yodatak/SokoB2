import java.util.Vector;
//implémentation des vectors

/**
 * Created by Lachenayefred on 27/02/14.
 */

public class Map {

    private int hauteur ;
    private int largeur ;
    Vector tab=new Vector();
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

    //draw sera faite ce soir :)
}



