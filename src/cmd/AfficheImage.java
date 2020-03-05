package cmd;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

public class AfficheImage {
    public JLabel affichageimage(URL url){

        try {

            Image images = ImageIO.read(url);
            return new JLabel(new ImageIcon(images));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }




}

