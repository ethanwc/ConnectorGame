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
        g2.setStroke(new BasicStroke(8));


        for (int i = 0; i < panels.size(); i++) {
            g2.setColor(new Color((int)(Math.random() *255),(int)(Math.random() *255),(int)(Math.random() *255)));
            g2.fillRect(panels.get(i).getX() +3,panels.get(i).getY() + panelTop.getHeight() +26,panels.get(i).getWidth(),panels.get(i).getHeight());
        }

        for (int i = 0; i < panels.size(); i++) {
            System.out.println(panels.size());


            //get cords returns 2 points

            g2.setColor(new Color((int)(Math.random() *255),(int)(Math.random() *255),(int)(Math.random() *255)));

            g2.drawLine(getX1(i),getY1(i),getX2(i),getY2(i));
            g2.drawLine(getX1(i),getY2(i),getX2(i),getY1(i));
            g2.drawOval(getX1(i),getY2(i),panels.get(i).getWidth(),panels.get(i).getHeight());
        }

    }

    public int getX1(int i) {

        int x1 = panels.get(i).getX();
        return x1;
    }

    public int getY1 (int i) {
        int y1 = panels.get(i).getY() + panelTop.getHeight() + 26 + panels.get(i).getHeight();
        return y1;
    }

    public int getX2 (int i) {
        int x2 = (int) panels.get(i).getLocation().getX() + panels.get(i).getWidth();
        return x2;
    }

    public int getY2 (int i) {
        int y2 = (int) panels.get(i).getLocation().getY() + panelTop.getHeight() + 26;
        return y2;
    }



    public static void main(String[] args) {
        new Game();
    }
}