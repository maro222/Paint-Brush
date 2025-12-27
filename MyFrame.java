import java.awt.Color;

import javax.swing.JFrame;

public class MyFrame extends JFrame{

    PaintBrushPanel panel;

    public MyFrame(){

        panel = new PaintBrushPanel();
        panel.setBackground(Color.WHITE);

        this.setTitle("Paint Brush");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(600, 600);
        this.setContentPane(panel);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    } 
}
