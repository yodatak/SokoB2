import java.io.IOException;
import java.io.OutputStream;

//les murs du jeu héritants de Cell
public class Wall extends Cell {

    @Override
    public void draw(OutputStream os) throws IOException {
        os.write('=');
    }
}
