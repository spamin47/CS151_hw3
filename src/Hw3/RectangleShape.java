package Hw3;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class RectangleShape {
    private int x;
        private int y;
        private int width;
        private int height;
    public RectangleShape(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    public void draw(Graphics2D g2){
        Rectangle2D.Double bar = new Rectangle2D.Double(x,y,width,height);
        g2.draw(bar);
        g2.fill(bar);
    }
}
