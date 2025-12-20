import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.BasicStroke;



public class Rectangle extends Shape{


    Rectangle(int x1, int x2, int y1, int y2, Boolean fillflag, BasicStroke stroke, Color color){
        super(x1,x2,y1,y2,fillflag,stroke,color);
    }

    public void draw(Graphics2D g){
        System.out.println("not yet");
    }


}
