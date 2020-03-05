package cmd;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class AfficheImage extends JPanel {
    Image eau;


    AfficheImage(String s)
    {
        eau = getToolkit().getImage(s);
        eau = eau.getScaledInstance(500,500,Image.SCALE_DEFAULT);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        g.drawImage(eau, 0, 0, getWidth(), getHeight(), this);
    }
}

