import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrame extends JFrame {

    PaintBrushPanel panel; 
    FunctionController myFunctionController;
    PaintColorController myPaintColorController;
    PaintModeController myPaintModeController;
    PaintStyleController myPaintStyleController;

    public MyFrame() {
        // 1. Initialize the drawing panel (The Canvas)
        panel = new PaintBrushPanel();
        panel.setBackground(Color.WHITE);

        // 2. Initialize the controllers
        myFunctionController = new FunctionController(panel);
        myPaintColorController = new PaintColorController(panel);
        myPaintModeController = new PaintModeController(panel);
        myPaintStyleController = new PaintStyleController(panel);

        // 3. Create the Save Button
        JButton saveBtn = new JButton("Save Drawing");
        saveBtn.addActionListener(e -> {
            ImageSaver.savePanelAsPng(panel); 
        });

        // 4. Create a TOP TOOLBAR to hold all buttons
        // This keeps the "drawing area" free of obstructions
        JPanel topToolbar = new JPanel();
        topToolbar.setLayout(new FlowLayout(FlowLayout.LEFT)); // Buttons line up left-to-right
        
        topToolbar.add(saveBtn);
        topToolbar.add(myPaintColorController);
        topToolbar.add(myPaintModeController);
        topToolbar.add(myPaintStyleController);
        topToolbar.add(myFunctionController);

        // 5. Arrange the Frame
        this.setLayout(new BorderLayout());
        
        // Add the toolbar to the NORTH (top)
        this.add(topToolbar, BorderLayout.NORTH); 
        
        // Add the drawing panel to the CENTER (fills all remaining space)
        this.add(panel, BorderLayout.CENTER); 

        // 6. Window settings
        this.setTitle("Paint Brush - Drawing Everywhere");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1000, 700); // Made it a bit wider to fit all controllers
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}