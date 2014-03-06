import java.io.IOException;
import java.io.OutputStream;


public interface Drawable {
    public void draw(OutputStream os) throws IOException;
}
