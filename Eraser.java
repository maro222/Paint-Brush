import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.BasicStroke;

public class Eraser extends Oval{

    int width, height;
    Eraser(int x1, int x2, int y1, int y2, Boolean fillflag, BasicStroke stroke, Color color){
        super(x1,x2,y1,y2,fillflag,stroke,color);
        width = x2 - x1;
        height = y2 - y1;
    }

    @Override
    public void draw(Graphics2D g){
        System.out.println("Erase");
        g.setBackground(Color.WHITE);
        // g.setStroke(stroke);
        g.fillOval(getX1(), getY1(), getX1()+5, getY1()+5);
    }
}
