import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class CarZoom {
    public static void main(String[] args) {
        CarZoom test = new CarZoom();
    }

    public CarZoom() {
        JFrame frame = new JFrame();

        JButton zoomIn = new JButton("Zoom In");
        JButton zoomOut = new JButton("Zoom Out");

        Car car = new Car();
        frame.add(car);

        zoomIn.addActionListener(e -> {
            car.carZoom += .1;
            frame.repaint();
        });
        zoomOut.addActionListener(e -> {
            car.carZoom -= .1;
            frame.repaint();
        });

        frame.setLayout(new FlowLayout());

        frame.add(zoomIn);
        frame.add(zoomOut);

        frame.setSize(325, 300);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
class Car extends JComponent {

    @Override
    public Dimension getPreferredSize() {
    return new Dimension(300, 200);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g2);
        Rectangle2D.Double body = new Rectangle2D.Double(x, y + (width * carZoom) / 6, (width * carZoom) - 1, (width * carZoom) / 6);
        Ellipse2D.Double frontTire = new Ellipse2D.Double(x + (width * carZoom) / 6, y + (width * carZoom) / 3, (width * carZoom) / 6, (width * carZoom) / 6);
        Ellipse2D.Double rearTire = new Ellipse2D.Double(x + (width * carZoom) * 2 / 3, y + (width * carZoom) / 3, (width * carZoom) / 6, (width * carZoom) / 6);

        // The bottom of the front windshield
        Point2D.Double r1 = new Point2D.Double(x + (width * carZoom) / 6, y + (width * carZoom) / 6);
        // The front of the roof
        Point2D.Double r2 = new Point2D.Double(x + (width * carZoom) / 3, y);
        // The rear of the roof
        Point2D.Double r3 = new Point2D.Double(x + (width * carZoom) * 2 / 3, y);
        // The bottom of the rear windshield
        Point2D.Double r4 = new Point2D.Double(x + (width * carZoom) * 5 / 6, y + (width * carZoom) / 6);
        Line2D.Double frontWindshield = new Line2D.Double(r1, r2);
        Line2D.Double roofTop = new Line2D.Double(r2, r3);
        Line2D.Double rearWindshield = new Line2D.Double(r3, r4);

        g2.draw(body);
        g2.draw(frontTire);
        g2.draw(rearTire);
        g2.draw(frontWindshield);
        g2.draw(roofTop);
        g2.draw(rearWindshield);
    }

    private int x = 0;
    private int y = 0;
    private double width = 100;
    public double carZoom = 1;
}
