import javax.swing.*;
import java.awt.*;

/**
 * Created by Ethan on 10/14/2017.
 */
public class BoardPanel extends JPanel{
    public Color Color;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.white);
        g2.setStroke(new BasicStroke(20));
        g2.drawOval(5,5,500,500);
//        g2.drawLine(Pieces.pieces.get());

    }
}
