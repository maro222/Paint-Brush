import java.awt.BasicStroke;
import java.awt.Color;
// import java.awt.Font;
import java.awt.Graphics2D;

public abstract class Shape {

    final int x1,y1;
    public int getX1() {
        return x1;
    }



    public int getY1() {
        return y1;
    }



    public int getX2() {
        return x2;
    }



    public void setX2(int x2) {
        this.x2 = x2;
    }



    public int getY2() {
        return y2;
    }



    public void setY2(int y2) {
        this.y2 = y2;
    }



    public Color getColor() {
        return color;
    }



    public Boolean getFillflag() {
        return fillflag;
    }



    public BasicStroke getStroke() {
        return stroke;
    }



    int x2,y2;
    final Color color;
    // final Font font;
    final Boolean fillflag;
    final BasicStroke stroke;



    public Shape(int x1, int x2, int y1, int y2, Boolean fillflag, BasicStroke stroke, Color color){
        this.x1 = x1;
        this.x2= x2;
        this.y1 = y1;
        this.y2 = y2;
        this.fillflag = fillflag;
        this.stroke = stroke;
        this.color = color;
    }
    


    public abstract void draw(Graphics2D g);
}
