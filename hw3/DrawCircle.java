import javax.swing.*;

import java.awt.*;

public class DrawCircle extends JFrame
{
    public static void main(String[]args)
    {
        DrawCircle drawCircle = new DrawCircle();
    }

    private Color currentColor = Color.RED;

    public DrawCircle()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton red = new JButton("Red");
        JButton green = new JButton("Green");
        JButton blue = new JButton("Blue");

        red.addActionListener(event -> {
            currentColor = Color.RED;
            repaint();
        });
        green.addActionListener(event -> {
            currentColor = Color.GREEN;
            repaint();
        });
        blue.addActionListener(event -> {
            currentColor = Color.BLUE;
            repaint();
        });

        setLayout(new FlowLayout());

        add(red);
        add(green);
        add(blue);

        setSize(250,200);
        setVisible(true);
    }

    public void paint(Graphics g)
    {
        super.paint(g);
        g.setColor(currentColor);
        g.fillOval(75,75,100,100);
    }
}