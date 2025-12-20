import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.awt.BasicStroke;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PaintBrushPanel extends JPanel{

    ArrayList<Shape> list;
    Tool currenttool;
    Color currentcolor;
    BasicStroke currentstroke;
    float[] dash = { 5.0f };
    boolean currentfillflag;
    JButton rectanglebutton, linebutton, ovalbutton, pencilbutton, eraserbutton;
    JButton red, black, blue, green;


    PaintBrushPanel(){
        list = new ArrayList<Shape>();
        currentcolor = Color.BLACK;
        currentfillflag = true;
        currentstroke = new BasicStroke(2);

        rectanglebutton = new JButton("Rectangle");
        linebutton = new JButton("Line");
        ovalbutton = new JButton("Oval");
        pencilbutton = new JButton("Pencil");
        eraserbutton = new JButton("Erase");

        red = new JButton("Red");
        red.setBackground(Color.RED);
        black = new JButton("Black");
        black.setBackground(Color.BLACK);
        blue = new JButton("Blue");
        blue.setBackground(Color.BLUE);
        green = new JButton("Green");
        green.setBackground(Color.GREEN);


        // rectanglebutton.addActionListener(null);
    }

    public void paint(Graphics g){
        super.paint(g);
        for (Shape item : list){
            item.draw((Graphics2D)g);
        }

    }
    // logic of handlig and buttuons
}
