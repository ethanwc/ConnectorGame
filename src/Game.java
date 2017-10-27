import javafx.beans.value.ObservableValue;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Game extends JFrame {
    public JPanel panelTop = new JPanel();
    public JPanel panelBoard = new JPanel();
    public JPanel panelBottom = new JPanel();
    public ArrayList<JPanel> panels = new ArrayList<>();
    public ArrayList<Line> lines = new ArrayList<>();
    public ArrayList<Ellipse> circles = new ArrayList<>();
    public int x,y, barSize, xScale, cScale;
    public boolean turn;

    public Game() {

        x = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        y = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();

        panelTop.setBackground(Color.GRAY);
        panelBoard.setBackground(Color.BLACK);
        panelBottom.setBackground(Color.GRAY);

        add(panelBoard, BorderLayout.CENTER);
        add(panelTop, BorderLayout.NORTH);
        add(panelBottom, BorderLayout.SOUTH);
        panelBoard.setLayout(new GridLayout(3,3));

        for (int i = 0; i < 9; i++) {
            JPanel panel = new JPanel();
            final int localI = i;
            panel.addMouseListener(new MouseAdapter() {

                                       @Override
                                       public void mouseClicked(MouseEvent e) {
                                           super.mouseClicked(e);
                                           System.out.println("Press detected on " +localI);
                                           nextMove(localI);
                                       }
                                   });
                    panel.setBackground(Color.WHITE);
            panels.add(panel);
            panelBoard.add(panels.get(i));
        }

        panelTop.setPreferredSize(new Dimension(x / 3, y / 12));
        panelBoard.setPreferredSize(new Dimension(x / 3, x / 3));
        panelBottom.setPreferredSize(new Dimension(x / 3, y / 12));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setTitle("Tic Tac Toe");
        pack();

        barSize = getHeight() - panelTop.getHeight() - panelBoard.getHeight() - panelBottom.getHeight();
        xScale = (int) (panels.get(1).getHeight() *.2);
        cScale = (int) (panels.get(1).getHeight() * .1);

        //TODO Winner Logic
        //TODO Boolean Turn
        //TODO Reset Game...end the new Game() and do a new Game?

    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(new BasicStroke(20));
        g2.setColor(Color.BLACK);
        //draw board
        g2.drawLine(getX1(1),getY2(1),getX1(1),getY1(7));
        g2.drawLine(getX1(2),getY2(2),getX1(2),getY1(8));
        g2.drawLine(getX1(0),getY1(0),getX2(2),getY1(0));
        g2.drawLine(getX1(6),getY1(3),getX2(8),getY1(3));


        for (int i = 0; i < circles.size(); i++) {
            g2.setColor(Color.BLACK);
            BasicStroke temp = new BasicStroke(12, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
            g2.setStroke(temp);
            g2.drawOval((int)circles.get(i).getCenterX(),(int)circles.get(i).getCenterY(),(int)circles.get(i).getRadiusX(),(int)circles.get(i).getRadiusY());


        }

        for (int i = 0; i < lines.size(); i++) {
            g2.drawLine((int)lines.get(i).getStartX(),(int)lines.get(i).getStartY(),(int)lines.get(i).getEndX(),(int)lines.get(i).getEndY());

        }



    }

    //determines whether to draw x or o
    public void nextMove(int i) {
        if (turn == true) {
            drawX(i);
        }
        else drawC(i);
        turn = !turn;
    }

    //draws the 'x' piece
    public void drawX(int i) {
        lines.add(new Line(getX1(i)+xScale,getY1(i)-xScale,getX2(i)-xScale,getY2(i)+xScale));
        lines.add(new Line(getX1(i)+xScale,getY2(i)+xScale,getX2(i)-xScale,getY1(i)-xScale));
        repaint();
    }

    //draws the 'o' piece
    public void drawC(int i) {
        circles.add(new Ellipse(getX1(i)+cScale,getY2(i)+cScale,panels.get(i).getWidth()-cScale*2,panels.get(i).getHeight()-cScale*2));
        repaint();
    }

    //Uses the GridLayout to arrange a 3x3 area, these calls are for finding cords of the 9 panels to scale

    public int getX1(int i) {

        int x1 = panels.get(i).getX();
        return x1;
    }

    public int getY1 (int i) {
        int y1 = panels.get(i).getY() + panels.get(i).getHeight() + panelTop.getHeight() + barSize;
        return y1;
    }

    public int getX2 (int i) {
        int x2 = panels.get(i).getX() + panels.get(i).getWidth();
        return x2;
    }

    public int getY2 (int i) {
        int y2 = panels.get(i).getY() + panelTop.getHeight() +barSize;
        return y2;
    }

    public static void main(String[] args) {
        new Game();
    }
}