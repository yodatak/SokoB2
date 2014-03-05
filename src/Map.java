import java.io.*;
import java.util.ArrayList;
import java.util.List;
//implémentation des vectors

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

    public void load(InputStream is) throws IOException {
        DataInputStream dis = new DataInputStream(is);

        height = dis.readInt();
        width = dis.readInt();

        tab = new ArrayList<Cell>(height * width);

        for(int i = 0; i < height; ++i){
            for(int j = 0; j < width; ++j){
                tab.set(i * width + j, new Blank());
            }
            is.skip(1);
        }
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

    //draw sera faite ce soir :)
}



