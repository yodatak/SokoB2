import java.io.IOException;
import java.io.OutputStream;


public class PlayerOnStorage extends Cell {
    @Override
    public void draw(OutputStream os) throws IOException {
        os.write('Y');
    }
}
