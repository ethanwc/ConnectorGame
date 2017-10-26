import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Game extends JFrame {
    public JPanel panelTop = new JPanel();
    public JPanel panelBoard = new JPanel();
    public JPanel panelBottom = new JPanel();
    public ArrayList<JPanel> panels = new ArrayList<>();
    public ArrayList<Shapes> shapes = new ArrayList();
    public int x,y,z;


    public Game() {

        //im bad at inheritance allegedly

        Shapes st = new Shapes();
        Shapes.Start test = st.new Start(new Rectangle(1,1,1,1),1,1,Color.red);
        shapes.add(test);

        x = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        y = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();

        panelTop.setBackground(Color.red);
        panelBoard.setBackground(Color.BLACK);
        panelBottom.setBackground(Color.green);

        add(panelBoard, BorderLayout.CENTER);
        add(panelTop, BorderLayout.NORTH);
        add(panelBottom, BorderLayout.SOUTH);
        panelBoard.setLayout(new GridLayout(3,3));

        for (int i = 0; i < 9; i++) {
            JPanel panel = new JPanel();
            panel.setBackground(Color.green);
            panels.add(panel);
            panelBoard.add(panels.get(i));
        }

        setPreferredSize(new Dimension(x / 3, y));
        panelTop.setPreferredSize(new Dimension(x / 3, y / 5));
        panelBoard.setPreferredSize(new Dimension(x / 3, y * (3 / 5)));
        panelBottom.setPreferredSize(new Dimension(x / 3, y / 5));
        test.setPreferredSize(new Dimension(x/6,y/8));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        pack();

    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.CYAN);

        for (int i = 0; i < shapes.size(); i++) {
            Shapes test = shapes.get(i);
            Rectangle r = shapes.get(i).getRectangle();
            g2.draw(r);
        }
    }

    public static void main(String[] args) {
        new Game();
    }
}