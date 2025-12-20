import java.awt.event.MouseEvent;


public class RectangleTool implements Tool{

    PaintBrushPanel panel;
    Rectangle rectangle;

    RectangleTool(PaintBrushPanel panel){
        this.panel = panel;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        rectangle = new Rectangle(e.getX(), e.getX(), e.getY(), e.getY(), panel.currentfillflag, panel.currentstroke, panel.currentcolor);
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // logic
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // logic
        
    }

}
