import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Ethan on 10/14/2017.
 */
public class Pieces {
    public static ArrayList pieces = new ArrayList();
    public int x;
    public int y;
    public int width;
    public int height;
    public Color Color;

    public Pieces(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.Color = color;
    }


    public static class Start extends JPanel {
        public int x1, y1, x2, y2;
        public Color color;

        public int getX1() {
            return x1;
        }

        public void setX1(int x1) {
            this.x1 = x1;
        }

        public int getY1() {
            return y1;
        }

        public void setY1(int y1) {
            this.y1 = y1;
        }

        public int getX2() {
            return x2;
        }

        public void setX2(int x2) {
            this.x2 = x2;
        }

        public int getY2() {
            return y2;
        }

        public void setY2(int y2) {
            this.y2 = y2;
        }

        public java.awt.Color getColor() {
            return color;
        }

        public void setColor(java.awt.Color color) {
            this.color = color;
        }

        public Start(int x1, int y1, int x2, int y2, Color color) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.color = color;
        }
        //paints the intersection piece
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(color);
            g2.setStroke(new BasicStroke(10));
            g2.drawLine(x1,y2/2,x2,y2/2);
            g2.drawLine(x2/2,0,x2/2,y2);
            JOptionPane.showMessageDialog(null,"AADDDSDF");

        }
    }
}