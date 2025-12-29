import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;

public class PaintBrushPanel extends JPanel{

     ArrayList<Shape> list;
    Shape currentShape;
    Color currentcolor;
    BasicStroke currentstroke;
    float[] dashPattern = {10f, 5f};
    boolean currentfillflag;

    FunctionController myFunctionController;
    PaintColorController myPaintColorController;
    PaintModeController myPaintModeController;
    PaintStyleController myPaintStyleController;




    PaintBrushPanel(){
        list = new ArrayList<Shape>();
        currentcolor = Color.BLACK;
        currentfillflag = true;
        currentstroke = new BasicStroke(2);
        currentShape = new Line();



        addMouseListener(new MouseListener() {
                
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {
                currentShape.onPress(e);
                currentShape.setColor(currentcolor);
                currentShape.setFillflag(currentfillflag);
                if (currentfillflag)
                    currentShape.setStroke(currentstroke);
                else
                {
                    currentShape.setStroke(new BasicStroke(
                            3f,                   // line thickness
                            BasicStroke.CAP_BUTT,       // line cap
                            BasicStroke.JOIN_MITER,     // line join
                            10f,            // miter limit
                            dashPattern,                // dash array
                            0f              // dash phase (start offset)
                    ));
                }
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                currentShape.onRelease(e);
                PaintBrushPanel.this.list.add(currentShape);
                repaint();
                createNewShape();
            }

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
            
        });

        addMouseMotionListener(new MouseMotionListener() {

            @Override
            public void mouseDragged(MouseEvent e) {
                currentShape.onDrag(e);
                repaint();
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                
            }
            
        });

        

    }

    public void paint(Graphics g){
        super.paint(g);
        for (Shape item : list){
            item.draw((Graphics2D)g);
        }

        // drawing current item
        currentShape.draw((Graphics2D)g);

    }

    public void createNewShape(){
        if (currentShape instanceof Rectangle)
            currentShape = new Rectangle();
        else if (currentShape instanceof Oval)
            currentShape = new Oval();
        else if (currentShape instanceof Line)
            currentShape = new Line();
        else if (currentShape instanceof Pencil)
            currentShape = new Pencil();
        else if (currentShape instanceof Eraser)
            currentShape = new Eraser();
        else
            currentShape = null;
    }
}
