import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JPanel;


public class PaintStyleController extends JPanel{
    
    Checkbox solid;
    Checkbox dashed;
    CheckboxGroup stylegroup;
    

    public PaintStyleController(PaintBrushPanel panel){
        stylegroup = new CheckboxGroup();

        solid = new Checkbox("Solid", stylegroup, true);
        dashed = new Checkbox("Dashed", stylegroup, false);

        solid.setBounds(50, 50, 150, 30);
        dashed.setBounds(50, 50, 150, 30);



        solid.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e){
                if(solid.getState()){
                    panel.currentfillflag=true;
                }
            }   
        });

        dashed.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                if (dashed.getState()){
                    panel.currentfillflag=false;
                }
            }
            
        });

        panel.add(solid);
        panel.add(dashed);
    }
}
