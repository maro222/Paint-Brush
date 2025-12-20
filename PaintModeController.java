
import java.awt.BasicStroke;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author abdallah
 */
public class PaintModeController extends JPanel{
    
    
    private Button lineButton;
    private Button rectangleButton;
    private Button ovalButton;
    private Button pencilButton;
    private Button eraserButton;
    
    private PaintBrushPanel paintBrushPanel;

    public PaintModeController(PaintBrushPanel paintBrushPanel ) {
       lineButton=new Button("line");
       rectangleButton=new Button("Rectangle");
       ovalButton=new Button("Oval");
       pencilButton=new Button("Pencil");
       eraserButton=new Button("Eraser");
       
         
        this.paintBrushPanel=paintBrushPanel;
 
        
        lineButton.addActionListener(new PaintModeListener( "Line"));
        rectangleButton.addActionListener(new PaintModeListener( "Rectangle" ));
        ovalButton.addActionListener(new PaintModeListener( "Oval"));
        pencilButton.addActionListener(new PaintModeListener( "Pencil" ));
        eraserButton.addActionListener(new PaintModeListener( "Eraser"));
        
        add(lineButton); 
        add(rectangleButton); 
        add(ovalButton); 
        add(pencilButton); 
        add(eraserButton); 
        
    }
    
    
    
    
    public class PaintModeListener implements ActionListener {

        private String Shape;

        public PaintModeListener(String Shape ) {
            this.Shape = Shape;
         }

        @Override
        public void actionPerformed(ActionEvent e) {

            paintBrushPanel.currentShape = Shape;
            paintBrushPanel.repaint();
        }

    }
    
    
    

    
    
    
    
    
}
