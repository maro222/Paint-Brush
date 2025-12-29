
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class PaintBrushPanel extends JPanel {

    private ArrayList<Shape> list;
    private Shape currentShape;
    private Color currentcolor;
    private BasicStroke currentstroke;
    private float[] dashPattern = {10f, 5f};
    private boolean currentfillflag;
    private BufferedImage uploadedImage = null;

    PaintBrushPanel() {
        list = new ArrayList<Shape>();
        currentcolor = Color.BLACK;
        currentfillflag = true;
        currentstroke = new BasicStroke(2);
        currentShape = new Line();

        addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                currentShape.onPress(e);
                currentShape.setColor(currentcolor);
                currentShape.setFillflag(currentfillflag);
                if (currentfillflag) {
                    currentShape.setStroke(currentstroke);
                } else {
                    currentShape.setStroke(new BasicStroke(
                            3f, // line thickness
                            BasicStroke.CAP_BUTT, // line cap
                            BasicStroke.JOIN_MITER, // line join
                            10f, // miter limit
                            dashPattern, // dash array
                            0f // dash phase (start offset)
                    ));
                }
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                currentShape.onRelease(e);
                PaintBrushPanel.this.list.add(currentShape);
                repaint();
                createNewShape();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

        });

        addMouseMotionListener(new MouseMotionListener() {

            @Override
            public void mouseDragged(MouseEvent e) {
                currentShape.onDrag(e);
                repaint();
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }

        });

    }

    public void setUploadedImage(BufferedImage img) {
        this.uploadedImage = img;
//        list.clear();
        this.repaint(); // This tells the panel to redraw itself immediately
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        if (uploadedImage != null) {
            g2d.drawImage(uploadedImage, 0, 0, null);
        }

        for (Shape item : list) {
            item.draw(g2d);
        }

        if (currentShape != null) {
            currentShape.draw(g2d);
        }
    }

    public void createNewShape() {
        if (currentShape instanceof Rectangle) {
            currentShape = new Rectangle();
        } else if (currentShape instanceof Oval) {
            currentShape = new Oval();
        } else if (currentShape instanceof Line) {
            currentShape = new Line();
        } else if (currentShape instanceof Pencil) {
            currentShape = new Pencil();
        } else if (currentShape instanceof Eraser) {
            currentShape = new Eraser();
        } else {
            currentShape = null;
        }
    }

    public ArrayList<Shape> getList() {
        return list;
    }

    public void setList(ArrayList<Shape> list) {
        this.list = list;
    }

    public Shape getCurrentShape() {
        return currentShape;
    }

    public void setCurrentShape(Shape currentShape) {
        this.currentShape = currentShape;
    }

    public Color getCurrentcolor() {
        return currentcolor;
    }

    public void setCurrentcolor(Color currentcolor) {
        this.currentcolor = currentcolor;
    }

    public BasicStroke getCurrentstroke() {
        return currentstroke;
    }

    public void setCurrentstroke(BasicStroke currentstroke) {
        this.currentstroke = currentstroke;
    }

    public float[] getDashPattern() {
        return dashPattern;
    }

    public void setDashPattern(float[] dashPattern) {
        this.dashPattern = dashPattern;
    }

    public boolean isCurrentfillflag() {
        return currentfillflag;
    }

    public void setCurrentfillflag(boolean currentfillflag) {
        this.currentfillflag = currentfillflag;
    }

}
