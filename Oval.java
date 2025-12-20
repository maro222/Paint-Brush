import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.BasicStroke;

public class Oval extends Shape{

    int width, height;
    Oval(int x1, int x2, int y1, int y2, Boolean fillflag, BasicStroke stroke, Color color){
        super(x1,x2,y1,y2,fillflag,stroke,color);
        width = x2 - x1;
        height = y2 - y1;
    }

    public void draw(Graphics2D g){
        System.out.println("Oval");
        g.setBackground(color);
        g.setStroke(stroke);
        if (fillflag){
            g.fillOval(getX1(), getY1(), width, height);
        }else{
            g.drawOval(getX1(), getY1(), width, height);
        }

    }
}
