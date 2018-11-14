import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class CanvasDemo extends JPanel {

    public static final Color LINE_COLOR = Color.BLACK;
    public double globalX;
    public double globalY;
    private BufferedImage img, img1, img2,img3;
    private int i = 0;

    public CanvasDemo(){
        try {
            img = ImageIO.read(getClass().getResourceAsStream("/images/grapg1.PNG"));
            img1 = ImageIO.read(getClass().getResourceAsStream("/images/img1.PNG"));
            img2 = ImageIO.read(getClass().getResourceAsStream("/images/img2.PNG"));
            img3 = ImageIO.read(getClass().getResourceAsStream("/images/img3.PNG"));


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

        if(PSO.funNumber == 1)
            g.drawImage(img1, 0, 0, 200, 200, null, null);

        if(PSO.funNumber == 2)
            g.drawImage(img2, 0, 0, 200, 200, null, null);

        if(PSO.funNumber == 3)
            g.drawImage(img3, 0, 0, 200, 200, null, null);

    }

}
