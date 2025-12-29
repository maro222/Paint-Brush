import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageLoader {
    public static void uploadToPanel(PaintBrushPanel panel) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select an Image to Upload");

        int result = fileChooser.showOpenDialog(panel);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                BufferedImage img = ImageIO.read(selectedFile);
                if (img != null) {
                    panel.setUploadedImage(img);
                    JOptionPane.showMessageDialog(panel, "Image Loaded!");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(panel, "Error loading image: " + e.getMessage());
            }
        }
    }
}