import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageSaver {

    public static void savePanelAsPng(PaintBrushPanel panel) {
         JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save Drawing as PNG");

         int userSelection = fileChooser.showSaveDialog(panel);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            String path = fileToSave.getAbsolutePath();

             if (!path.toLowerCase().endsWith(".png")) {
                fileToSave = new File(path + ".png");
            }

            try {
                 BufferedImage image = new BufferedImage(
                    panel.getWidth(), 
                    panel.getHeight(), 
                    BufferedImage.TYPE_INT_RGB
                );

                // 4. Render the panel to the image
                Graphics2D g2d = image.createGraphics();
                
                // Use printAll to ensure children (buttons) don't get messy 
                // and everything is captured correctly.
                panel.printAll(g2d);
                
                g2d.dispose();

                // 5. Write to disk
                ImageIO.write(image, "png", fileToSave);
                
                JOptionPane.showMessageDialog(panel, "Saved successfully to: " + fileToSave.getName());

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(panel, "Error saving file: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }
}