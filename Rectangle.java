import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.BasicStroke;



public class Rectangle extends Shape{

    int width, height;
    Rectangle(int x1, int x2, int y1, int y2, Boolean fillflag, BasicStroke stroke, Color color){
        super(x1,x2,y1,y2,fillflag,stroke,color);
        width = x2 - x1;
        height = y2 - y1;
    }

    public void draw(Graphics2D g){
        System.out.println("Rectangle");
        g.setBackground(color);
        g.setStroke(stroke);
        if (fillflag){
            g.fillRect(getX1(), getY1(), width, height);
        }else{
            g.drawRect(getX1(), getY1(), width, height);
        }
    }

}
