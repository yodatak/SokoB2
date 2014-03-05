import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Lachenayefred on 27/02/14.
 */

public class Map implements Drawable {

    private int height = 0;
    private int width = 0;
    private ArrayList<Cell> tab = null;

    private int playerX = 0;
    private int playerY = 0;
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
                if(resolveGame ==false){
                    switch(line.charAt(j)){
                        case '=': cell = new Wall(); break;
                        case ' ': cell = new Blank(); break;
                        case 'O': cell = new StorageLocation(); break;
                        case 'B': cell = new Box(); break;
                        case 'D': cell = new BoxOnStorage(); break;
                        case 'X':
                            cell = new Player();
                            playerX = j;
                            playerY = tab.size()/width;
                            break;
                        case 'Y':
                            cell = new PlayerOnStorage();
                            playerX = j;
                            playerY = tab.size()/width;
                            break;
                        default: throw new IOException("Unknown Cell type " + line.charAt(j));
                    }
                }else {
                    if (resolveGame) {
                        switch (line.charAt(j)) {
                            case '#':
                                cell = new Wall();
                                break;
                            case ' ':
                                cell = new Blank();
                                break;
                            case 'D':
                                cell = new StorageLocation();
                                break;

                            case 'X':
                                cell = new Player();
                                playerX = j;
                                playerY = tab.size() / width;
                                break;
                            case 'Y':
                                cell = new PlayerOnStorage();
                                playerX = j;
                                playerY = tab.size() / width;
                                break;
                            default:
                                throw new IOException("Unknown Cell type " + line.charAt(j));

                        }
                    }
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

    /*
    Détermine si la position donnée est un emplacement possible pour un objet mobile
     */
    private boolean isValidPosition(int x, int y){
        //Si la position est en dehors de la map
        if(x < 0 || x >= width || y < 0 || y >= height)
            return false;

        Cell c = tab.get(y * width + x);

        return c.isWalkable();
    }

    public void movePlayer(int offsetX, int offsetY) throws ImpossibleMove {
        //position de l'ancien joueur
        Cell futurePlayerCell = getCell(playerX + offsetX, playerY + offsetY);

        //Si la case devant le joueur est occupée
        if(!isValidPosition(playerX + offsetX, playerY + offsetY)){
            if(!(futurePlayerCell instanceof Box || futurePlayerCell instanceof BoxOnStorage)){
                throw new ImpossibleMove();//Si la case devant le joueur est occupée et n'est pas une box, impossible d'avancer
            }

            if(!isValidPosition(playerX + 2*offsetX, playerY + 2*offsetY)){
                throw new ImpossibleMove();//Si les deux cases devant le joueur sont prises, impossible d'avancer
            }

            //position de la nouvelle box
            Cell futureBoxPosition = getCell(playerX + 2*offsetX, playerY + 2*offsetY);

            //On crée la nouvelle box
            if(futureBoxPosition instanceof Blank)
                setCell(playerX + 2*offsetX, playerY + 2*offsetY, new Box());
            else //if(futureBoxPosition instanceof StorageLocation)
                setCell(playerX + 2*offsetX, playerY + 2*offsetY, new BoxOnStorage());

            //On supprime l'ancienne box
            if(futurePlayerCell instanceof Box)
                setCell(playerX + offsetX, playerY + offsetY, new Blank());
            else //if(futurePlayerCell instanceof BoxOnStorage)
                setCell(playerX + offsetX, playerY + offsetY, new StorageLocation());
        }

        //position du nouveau joueur
        futurePlayerCell = getCell(playerX + offsetX, playerY + offsetY);

        //On crée le nouveau joueur
        if(futurePlayerCell instanceof Blank)
            setCell(playerX + offsetX, playerY + offsetY, new Player());
        else //if(futurePlayerCell instanceof StorageLocation)
            setCell(playerX + offsetX, playerY + offsetY, new PlayerOnStorage());

        //position de l'ancien joueur
        Cell currentPlayerCell = getCell(playerX, playerY);

        //On supprime l'ancien joueur
        if(currentPlayerCell instanceof Player)
            setCell(playerX, playerY, new Blank());
        else //if(currentPlayerCell instanceof PlayerOnStorage)
            setCell(playerX, playerY, new StorageLocation());

        //on met à jour la position du joueur
        playerX += offsetX;
        playerY += offsetY;
    }

    private void setCell(int x, int y, Cell cell) {
        tab.set(y * width + x, cell);
    }

    private Cell getCell(int x, int y) {
        return tab.get(y * width + x);
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

    public class ImpossibleMove extends Throwable {
    }
    private boolean resolveGame = false;



}



