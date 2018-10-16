import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class Homework4 {

    public static void main(String[] args) {
        JFrame textFrame = new JFrame("Edit Graphs");
        JFrame graphFrame = new JFrame("Display Graphs");

        JLabel label1 = new JLabel("Graph 1");
        JLabel label2 = new JLabel("<html><br>Graph 2</html>");
        JLabel label3 = new JLabel("<html><br>Graph 3</html>");
        JLabel label4 = new JLabel("<html><br>Graph 4</html>");
        JLabel label5 = new JLabel("<html><br>Graph 5</html>");

        JTextField textField1 = new JTextField("100",5);
        JTextField textField2 = new JTextField("100",5);
        JTextField textField3 = new JTextField("100",5);
        JTextField textField4 = new JTextField("100",5);
        JTextField textField5 = new JTextField("100",5);

        Graph graph = new Graph();
        graphFrame.add(graph);

        textFrame.setLayout(new BoxLayout(textFrame.getContentPane(), BoxLayout.Y_AXIS));

        textFrame.add(label1);
        textFrame.add(textField1);
        textFrame.add(label2);
        textFrame.add(textField2);
        textFrame.add(label3);
        textFrame.add(textField3);
        textFrame.add(label4);
        textFrame.add(textField4);
        textFrame.add(label5);
        textFrame.add(textField5);

        textField1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                graph.values.set(0, Double.parseDouble(textField1.getText()));
                graphFrame.repaint();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if(textField1.getText().equals(""))
                    graph.values.set(0, 0.0);
                else
                    graph.values.set(0, Double.parseDouble(textField1.getText()));
                graphFrame.repaint();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                graph.values.set(0, Double.parseDouble(textField1.getText()));
                graphFrame.repaint();
            }
        });

        textField2.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                graph.values.set(1, Double.parseDouble(textField2.getText()));
                graphFrame.repaint();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if(textField2.getText().equals(""))
                    graph.values.set(1, 0.0);
                else
                    graph.values.set(1, Double.parseDouble(textField2.getText()));
                graphFrame.repaint();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                graph.values.set(1, Double.parseDouble(textField2.getText()));
                graphFrame.repaint();
            }
        });

        textField3.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                graph.values.set(2, Double.parseDouble(textField3.getText()));
                graphFrame.repaint();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if(textField3.getText().equals(""))
                    graph.values.set(2, 0.0);
                else
                    graph.values.set(2, Double.parseDouble(textField3.getText()));
                graphFrame.repaint();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                graph.values.set(2, Double.parseDouble(textField3.getText()));
                graphFrame.repaint();
            }
        });

        textField4.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                graph.values.set(3, Double.parseDouble(textField4.getText()));
                graphFrame.repaint();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if(textField4.getText().equals(""))
                    graph.values.set(3, 0.0);
                else
                    graph.values.set(3, Double.parseDouble(textField4.getText()));
                graphFrame.repaint();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                graph.values.set(3, Double.parseDouble(textField4.getText()));
                graphFrame.repaint();
            }
        });

        textField5.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                graph.values.set(4, Double.parseDouble(textField5.getText()));
                graphFrame.repaint();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if(textField5.getText().equals(""))
                    graph.values.set(4, 0.0);
                else
                    graph.values.set(4, Double.parseDouble(textField5.getText()));
                graphFrame.repaint();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                graph.values.set(4, Double.parseDouble(textField5.getText()));
                graphFrame.repaint();
            }
        });

        textFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textFrame.pack();
        textFrame.setSize(250,300);
        textFrame.setVisible(true);

        graphFrame.setLocation(250,0);
        graphFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        graphFrame.pack();
        graphFrame.setSize(375,300);
        graphFrame.setVisible(true);
    }
}

class Graph extends JComponent{
    public Graph(){
        values = new ArrayList<>();
        values.add(100.0);
        values.add(100.0);
        values.add(100.0);
        values.add(100.0);
        values.add(100.0);
    }

    @Override
    public Dimension getPreferredSize(){
        return new Dimension(375,300);
    }

    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g2);

        Rectangle2D.Double graph1 = new Rectangle2D.Double(50, 250-values.get(0), 50, values.get(0));
        Rectangle2D.Double graph2 = new Rectangle2D.Double(100, 250-values.get(1), 50, values.get(1));
        Rectangle2D.Double graph3 = new Rectangle2D.Double(150, 250-values.get(2), 50, values.get(2));
        Rectangle2D.Double graph4 = new Rectangle2D.Double(200, 250-values.get(3), 50, values.get(3));
        Rectangle2D.Double graph5 = new Rectangle2D.Double(250, 250-values.get(4), 50, values.get(4));

        g2.setColor(Color.BLACK);
        g2.fill(graph1);
        g2.setColor(Color.LIGHT_GRAY);
        g2.fill(graph2);
        g2.setColor(Color.BLACK);
        g2.fill(graph3);
        g2.setColor(Color.LIGHT_GRAY);
        g2.fill(graph4);
        g2.setColor(Color.BLACK);
        g2.fill(graph5);

    }

    ArrayList<Double> values;
}


