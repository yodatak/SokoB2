import java.io.IOException;
import java.io.OutputStream;


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
