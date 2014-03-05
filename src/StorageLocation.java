import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by germinolegrand on 05/03/14.
 */
public class StorageLocation extends Cell {
    @Override
    public boolean isWalkable() {
        return true;
    }

    @Override
    public void draw(OutputStream os) throws IOException {
        os.write('O');
    }
}
