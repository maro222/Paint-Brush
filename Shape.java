import java.awt.BasicStroke;
import java.awt.Color;
// import java.awt.Font;
import java.awt.Graphics2D;

import java.awt.event.MouseEvent;
// import java.awt.event.MouseListener;
// import java.awt.event.MouseMotionListener;

public abstract class Shape {

    private int x1,y1;
    private int x2,y2;
    private Color color;
    private Boolean fillflag;
    private BasicStroke stroke;

    public Shape(){
        this(0,0,0,0,true,new BasicStroke(2),Color.BLUE);
    }

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

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
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

    public int getX() { return Math.min(x1, x2); }
    public int getY() { return Math.min(y1, y2); }
    public int getWidth() { return Math.abs(x2 - x1); }
    public int getHeight() { return Math.abs(y2 - y1); }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Boolean getFillflag() {
        return fillflag;
    }

    public void setFillflag(Boolean fillflag) {
        this.fillflag = fillflag;
    }

    public BasicStroke getStroke() {
        return stroke;
    }

    public void setStroke(BasicStroke stroke) {
        this.stroke = stroke;
    }

    public abstract void onDrag(MouseEvent e);
    public abstract void onPress(MouseEvent e);
    public abstract void onRelease(MouseEvent e);
}
