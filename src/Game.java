import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.*;

public class Game extends JFrame {
    public JPanel panelTop = new JPanel();
    public JPanel panelBoard = new JPanel();
    public JPanel panelBottom = new JPanel();
    public JButton test = new JButton();
//    public Pieces start, end, intersection, reflect, corner;

    public int x,y,z;

    public static ArrayList<Shape> shapes = new ArrayList();

    public Game() {
        shapes.add(new Rectangle(20,20,100,100));
        shapes.add(new Rectangle(200,200,100,100));

        x = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        y = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();

        panelTop.setBackground(Color.red);
        panelBoard.setBackground(Color.BLACK);
        panelBottom.setBackground(Color.green);


        add(panelBoard, BorderLayout.CENTER);
        add(panelTop, BorderLayout.NORTH);
        add(panelBottom, BorderLayout.SOUTH);
        panelBoard.add(test);

        setPreferredSize(new Dimension(x / 3, y));
        panelTop.setPreferredSize(new Dimension(x / 3, y / 5));
        panelBoard.setPreferredSize(new Dimension(x / 3, y * (3 / 5)));
        panelBottom.setPreferredSize(new Dimension(x / 3, y / 5));
        test.setPreferredSize(new Dimension(x/6,y/8));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        pack();

        test.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                shapes.add(new Rectangle(100,100,2000,2000));
                repaint();
            }
        } );

    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.CYAN);

        for (int i = 0; i < shapes.size(); i++) {
            g2.draw(shapes.get(i));
        }
    }

    public static void main(String[] args) {
        shapes.add(new Rectangle(0,0,1000,1000));
        new Game();
    }
}