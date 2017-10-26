import java.awt.*;
/**
 * Created by Ethan on 10/14/2017.
 */
public class Shapes {

    public Rectangle rectangle;
    public int x;
    public int y;
    public Color color;

    public Shapes() {
    }

    public Rectangle getRectangle() {
        return rectangle;
    }


    public class Start extends Shapes {

        public Start(Rectangle rectangle, int x, int y, Color color) {
            this.rectangle = rectangle;
            this.x = x;
            this.y = y;
            this.color = color;
        }

    }
}