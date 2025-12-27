import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.BasicStroke;


public class Pencil extends Shape{

    private ArrayList<int[]> points;
    public Pencil(){
        this(0,0,0,0,true,new BasicStroke(5), Color.BLACK);
    }
    public Pencil(int x1, int x2, int y1, int y2, Boolean fillflag, BasicStroke stroke, Color color){
        super(x1,x2,y1,y2,fillflag,stroke,color);
        points = new ArrayList<>();
    }

    @Override
    public void draw(Graphics2D g){
        System.out.println("Pencil");
        g.setColor(getColor());
        g.setStroke(getStroke());
        for (int i = 1; i < points.size(); i++){
            g.drawLine(points.get(i-1)[0], points.get(i-1)[1], points.get(i)[0], points.get(i)[1]);
        }

    }
    @Override
    public void onDrag(MouseEvent e) {
        points.add(new int[]{e.getX(), e.getY()});
    }

    @Override
    public void onPress(MouseEvent e) {
        points.add(new int[]{e.getX(), e.getY()});
    }

    @Override
    public void onRelease(MouseEvent e) {
        points.add(new int[]{e.getX(), e.getY()});
    }

}
