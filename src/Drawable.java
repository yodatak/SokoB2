import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by germinolegrand on 27/02/14.
 */
public interface Drawable {
    public void draw(OutputStream os) throws IOException;
}
