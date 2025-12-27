
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// import java.util.ArrayList;
import javax.swing.JPanel;


public class FunctionController extends JPanel{
    private Button clearButton;
    private Button undoButton;
    
    
    private PaintBrushPanel paintBrushPanel;

    public FunctionController(PaintBrushPanel paintBrushPanel) {
       clearButton=new Button("Clear");
       undoButton=new Button("Undo");
  
       this.paintBrushPanel=paintBrushPanel; 
        
       clearButton.addActionListener(new ClearListener());
       undoButton.addActionListener(new UnDoListener()); 
       add(clearButton); 
       add(undoButton); 
 
    }
    
    
    public class ClearListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            paintBrushPanel.list.clear();
            paintBrushPanel.repaint();
        }
    }
    
    public class UnDoListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int size=paintBrushPanel.list.size();
            if(size>0)
                paintBrushPanel.list.remove(size-1);
            paintBrushPanel.repaint();
        }
    }
}
