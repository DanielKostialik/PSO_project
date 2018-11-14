import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class GuiForm extends JPanel{

    public JFrame mainFrame;
    public JPanel panel1;
    private JPanel p1;
    private JPanel p2;
    private JTextField radiusTextField;
    private JTextField nSizeTextField;
    private JTextField delayTextField;
    private JButton runButton;
    public JRadioButton f1RadioButton;
    public JRadioButton f2RadioButton;
    public JRadioButton f3RadioButton;
    private JPanel chartPanel;
    private CanvasDemo canvas;


    public GuiForm() {

        ButtonGroup buttonGroup = new ButtonGroup();
        f1RadioButton.setSelected(true);
        buttonGroup.add(f1RadioButton);
        buttonGroup.add(f2RadioButton);
        buttonGroup.add(f3RadioButton);


        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Image image;

                if(f1RadioButton.isSelected()) {
                    PSO.funNumber = 1;
                }
                if(f2RadioButton.isSelected())
                    PSO.funNumber = 2;
                if(f3RadioButton.isSelected())
                    PSO.funNumber = 3;

                PSO.N = Integer.parseInt(nSizeTextField.getText());
                PSO.delay = Integer.parseInt(delayTextField.getText());
                PSO.radiusRandom = Integer.parseInt(radiusTextField.getText());

                PSO.initSeekers();
                PSO.newRound = true;

            }
        });
    }


    public void drawForm(double gBestX, double gBestY) {

        mainFrame = new JFrame("PSO");
        mainFrame.setVisible(true);
        mainFrame.setPreferredSize(new Dimension(1200,1000));
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        canvas = new CanvasDemo();
        canvas.setPreferredSize(new Dimension(50,50));
        canvas.setPreferredSize(new Dimension(200, 200));
        canvas.setMaximumSize(new Dimension(400, 400));
        canvas.setMinimumSize(new Dimension(200, 200));
        canvas.setFocusable(false);
        //canvas.setBackground(Color.orange);
        mainFrame.setVisible(true);

        panel1.setPreferredSize(new Dimension(10,10));
        p2.add(canvas);
        mainFrame.add(panel1);
        mainFrame.pack();


    }
    public void redrawI() {

        this.mainFrame.repaint();
        this.canvas.redrawI(0,0);

    }

}
