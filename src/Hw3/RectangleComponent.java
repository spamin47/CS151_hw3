package Hw3;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class RectangleComponent extends JComponent {

    private int x;
    private int y;
    private int width;
    private int height;
    private RectangleShape bar;
    private Color color;
    public RectangleComponent(int x,int y,int width, int height,Color color){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.bar = new RectangleShape(this.x,this.y,this.width,this.height);

    }
    @Override
    public void paintComponent(Graphics g)
    {

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(this.color);

        bar.draw(g2);

    }
    @Override
    public Dimension getPreferredSize(){
        return new Dimension(200,600);
    }

    public void setHeight(int height){
        //max height is 350
        height = (height>350)?350:height;
        //set new height for bar
        this.bar = new RectangleShape(this.x,this.y - height,this.width,this.height+height);
        repaint();
    }
}
