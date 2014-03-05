import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by yoyonice on 05/03/14.
 */
public class Blank extends Cell {
    @Override
    public boolean isWalkable() {
        return true;
    }

    @Override
    public void draw(OutputStream os) throws IOException {
        os.write(' ');
    }
}
