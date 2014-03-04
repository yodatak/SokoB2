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

    public void setHauteur(int hauteur) { //////////// set hauteur
        this.hauteur = hauteur;
    }

    public void setLargeur(int largeur) { /////////// set largeur
        this.largeur = largeur;
    }

    public int getHauteur() {   /////////////// get hauteur
        return hauteur;
    }

    public int getLargeur() { //////////// get largeur
        return largeur;
    }
}



