import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class CanvasDemo extends JPanel {

    public static final Color LINE_COLOR = Color.BLACK;
    public double globalX;
    public double globalY;
    private BufferedImage img = null;
    private int i = 0;

    public CanvasDemo(){
        try {
            img = ImageIO.read(getClass().getResourceAsStream("/images/grapg1.PNG"));
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public void redrawI(double globalX, double globalY){
        this.globalX = globalX;
        this.globalY = globalY;
        this.repaint();
    }

    public void paint(Graphics g) {

        g.drawImage(img, 0, 0, 1000, 1000, null, null);
        g.setColor(Color.red);
        g.fillOval((int)Math.round(globalX),(int)Math.round(globalY),10,10);
        g.setColor(Color.gray);
        g.setColor(LINE_COLOR);
        for(int i = 0; i< PSO.seekers.length; i++){
            g.fillOval((int)Math.round(PSO.seekers[i].currentX),(int)Math.round(PSO.seekers[i].currentY),5,5);
        }

    }

}
