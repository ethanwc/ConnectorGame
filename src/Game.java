import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
//todo repaint from badlayout, add shape to connectors

public class Game extends JPanel {
    JFrame window;
    JPanel panelBottom, panelTop;
    BoardPanel panelBoard;
    Pieces start, end, intersection, reflect, corner;
    int x,y;


    public Game() {
        window = new JFrame();
        panelBoard = new BoardPanel();
        panelBottom = new JPanel();
        panelTop = new JPanel();
    }

    public void run() {
        x = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        y = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();

        panelTop.setBackground(Color.red);
        panelBoard.setBackground(Color.BLACK);
        panelBottom.setBackground(Color.green);

        window.add(panelBoard, BorderLayout.CENTER);
        window.add(panelTop, BorderLayout.NORTH);
        window.add(panelBottom, BorderLayout.SOUTH);

        window.setPreferredSize(new Dimension(x / 3, y));
        panelTop.setPreferredSize(new Dimension(x / 3, y / 5));
        panelBoard.setPreferredSize(new Dimension(x / 3, y * (3 / 5)));
        panelBottom.setPreferredSize(new Dimension(x / 3, y / 5));

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
}