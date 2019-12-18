package imagenes;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.border.Border;
 

public class fondo implements Border{
    public BufferedImage back;
 
    public fondo(){
        try {
            URL imagePath = new URL(getClass().getResource("../imagenes/ferre.jpg").toString());
            back = ImageIO.read(imagePath);
        } catch (Exception ex) {            
        }
    }
     public fondo(String direccion){
        try {
            URL imagePath = new URL(getClass().getResource(direccion).toString());
            back = ImageIO.read(imagePath);
        } catch (Exception ex) {            
        }
    }

    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawImage(back, (x + (width - back.getWidth())/2),(y + (height - back.getHeight())/2), null);
    }
 
    public Insets getBorderInsets(Component c) {
        return new Insets(0,0,0,0);
    }
 
    public boolean isBorderOpaque() {
        return false;
    }
 
}