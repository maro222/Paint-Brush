
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
public class PaintColorController extends JPanel{
    private Button redButton;
    private Button blackButton;
    private Button greenButton;
    private Button blueButton;
  
    
    private PaintBrushPanel paintBrushPanel;
    
     public PaintColorController(PaintBrushPanel paintBrushPanel ) {
         this.redButton=new Button("Red");
         this.blackButton=new Button("Black");
         this.greenButton=new Button("Green");
         this.blueButton=new Button("Blue");
         
         this.paintBrushPanel=paintBrushPanel;

        
        redButton.addActionListener(new PaintColorListener(Color.red  ) );
        blackButton.addActionListener(new PaintColorListener(Color.black  ) );
        greenButton.addActionListener(new PaintColorListener(Color.green  ) );
        blueButton.addActionListener( new PaintColorListener(Color.blue  ));
         
        add(redButton); 
        add(blackButton); 
        add(greenButton); 
        add(blueButton); 
         
    }
    
    public class PaintColorListener implements ActionListener{
    private Color color;
 
    public PaintColorListener(Color color ) {
        this.color=color;
     }

    @Override
    public void actionPerformed(ActionEvent e) {

         paintBrushPanel.currentcolor = this.color;
         paintBrushPanel.repaint();
 
    }

    
  
}
    
}
