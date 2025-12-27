import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.BasicStroke;

public class Oval extends Shape{

    public Oval(){
        this(0,0,0,0,true,new BasicStroke(2), Color.BLACK);
    }
    public Oval(int x1, int x2, int y1, int y2, Boolean fillflag, BasicStroke stroke, Color color){
        super(x1,x2,y1,y2,fillflag,stroke,color);
    }

    public void draw(Graphics2D g){
        System.out.println("Oval");
        g.setColor(getColor());
        g.setStroke(getStroke());
        if (getFillflag()){
            g.fillOval(getX(), getY(), getWidth(), getHeight());
        }else{
            g.drawOval(getX(), getY(), getWidth(), getHeight());
        }

    }

    @Override
    public void onDrag(MouseEvent e) {
        setX2(e.getX());
        setY2(e.getY());
    }
    @Override
    public void onPress(MouseEvent e) {
        setX1(e.getX());
        setY1(e.getY());

        setX2(e.getX());
        setY2(e.getY());
        
    }
    @Override
    public void onRelease(MouseEvent e) {
        setX2(e.getX());
        setY2(e.getY());
    }

    
}
