import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by germinolegrand on 05/03/14.
 */
public class PlayerOnStorage extends Cell {
    @Override
    public void draw(OutputStream os) throws IOException {
        os.write('Y');
    }
}