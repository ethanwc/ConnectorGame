import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.*;

public class Game extends JPanel {
    JFrame window;
    JPanel panelBottom, panelTop;
    BoardPanel panelBoard;
    Pieces start, end, intersection, reflect, corner;
    JButton test;
    int x,y,z;
    public static ArrayList<Shape> shapes = new ArrayList();

    public Game() {
        window = new JFrame();
        panelBoard = new BoardPanel();
        panelBottom = new JPanel();
        panelTop = new JPanel();
        test = new JButton();

        test.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                shapes.add(new Rectangle(100,100,2000,2000));
            }
        } );
    }

    public void run() {
        shapes.add(new Rectangle(20,20,100,100));
        shapes.add(new Rectangle(200,200,100,100));
        x = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        y = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();

        panelTop.setBackground(Color.red);
        panelBoard.setBackground(Color.BLACK);
        panelBottom.setBackground(Color.green);

        window.add(panelBoard, BorderLayout.CENTER);
        panelBoard.add(test);
        window.add(panelTop, BorderLayout.NORTH);
        window.add(panelBottom, BorderLayout.SOUTH);

        window.setPreferredSize(new Dimension(x / 3, y));
        panelTop.setPreferredSize(new Dimension(x / 3, y / 5));
        panelBoard.setPreferredSize(new Dimension(x / 3, y * (3 / 5)));
        panelBottom.setPreferredSize(new Dimension(x / 3, y / 5));
        test.setPreferredSize(new Dimension(x/6,y/8));

        window.setVisible(true);
        window.pack();

        buildConnectors();
    }

    public void buildConnectors() {
        start = new Pieces(0,0,100,100,Color.blue);
    }

    public static void main(String[] args) {
        Pieces.Start intersection = new Pieces.Start(1,1,100,100,Color.red);
        Pieces.pieces.add(intersection);

        Game bad = new Game();
        bad.run();

    }

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

            for (int i = 0; i <Game.shapes.size(); i++) {
                g2.draw(Game.shapes.get(i));
            }
        }
    }
}