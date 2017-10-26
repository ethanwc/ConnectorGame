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

        Shapes st = new Shapes();
        Shapes.Start test = st.new Start(new Rectangle(0,0,500,500),1,1,Color.ORANGE);
        shapes.add(test);

        x = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        y = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();

        panelTop.setBackground(Color.red);
        panelBoard.setBackground(Color.BLACK);
        panelBottom.setBackground(Color.BLUE);

        add(panelBoard, BorderLayout.CENTER);
        add(panelTop, BorderLayout.NORTH);
        add(panelBottom, BorderLayout.SOUTH);
        panelBoard.setLayout(new GridLayout(3,3));

        for (int i = 0; i < 9; i++) {
            JPanel panel = new JPanel();
            panel.setBackground(new Color((int)(Math.random() *255),(int)(Math.random() *255),(int)(Math.random() *255)));
            panel.add(new JTextArea("count "+i));
            panels.add(panel);
            panelBoard.add(panels.get(i));
        }

        panelTop.setPreferredSize(new Dimension(x / 3, y / 12));
        panelBoard.setPreferredSize(new Dimension(x / 4, x / 4));
        panelBottom.setPreferredSize(new Dimension(x / 3, y / 12));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        pack();

    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(12));



        for (int i = 0; i < panels.size(); i++) {
            System.out.println(panels.size());


            //get cords returns 2 points

            g2.setColor(new Color((int)(Math.random() *255),(int)(Math.random() *255),(int)(Math.random() *255)));
            g2.fillRect(panels.get(i).getX() +3,panels.get(i).getY() + panelTop.getHeight() +26,panels.get(i).getWidth(),panels.get(i).getHeight());
            g2.setColor(new Color((int)(Math.random() *255),(int)(Math.random() *255),(int)(Math.random() *255)));
            g2.drawLine(panels.get(i).getX(),panels.get(i).getY() + panelTop.getHeight() + 26,
                    (int)panels.get(4).getLocation().getX() + panels.get(4).getWidth()/2,(int)panels.get(4).getLocation().getY() + panelTop.getHeight() + 26 + panels.get(4).getHeight()/2);
        }

//        for (int i = 0; i < shapes.size(); i++) {
//            g2.draw(shapes.get(i).getRectangle());
//        }
    }

    public Point[] getPanelCoords(int i) {
        Point test[] = new Point[2];
        test[0].x = 1;
        test[0].y = 1;
        //returns array of 2 points for btm left and top right of each panel... USEFUL
        return test;
    }

    public static void main(String[] args) {
        new Game();
    }
}