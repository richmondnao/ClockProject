/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clock;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author richmond
 */
public class FancyHourHand extends java.lang.Object {
    private final int centerX;
    private final int centerY;
    private final int length;
    private final Color color;
    private long angle;
    
    
    /** Constructor
     *
     *  @param centerX - the X coordinate of the center of the clock of 
     *           which this is a part relative to upper left corner of clock
        @param centerY - the Y coordinate of the center of the clock of 
        *        which this is a part relative to upper left corner of clock
        @param length - the length of this hand
        @param color - the color of this hand 
     *
     */
    
    public FancyHourHand(int centerX, 
                int centerY, 
                int length, 
                Color color){
        
        
        this.centerX = centerX;
        this.centerY = centerY;
        this.length = length;
        this.color = color;
        
    }
    
    /** Draw this hand
     *
     *  @param graphics the graphics object on which to draw
     */
    
    public void draw(Graphics graphics) {
        graphics.setColor(color);
        int cent =(int)((length * Math.sin(Math.toRadians(angle))) + centerX ) ;
        int cant = (int)((-length * Math.cos(Math.toRadians(angle))) + centerY);
        
        drawHand(graphics,centerX,centerY,cent,cant,8,8);
    }
    
    
    
    /** Set the angle for this hand
     * @param angle the angle (in degrees relative to vertical) for this hand
     */
    
    public void setAngle(long angle){
        this.angle = angle;
        
        
    }
    
    //double clockRadius;
   /**
    * 
    * @param g the graphics component.
    * @param xpoint1 x-position of first point.
    * @param ypoint1 y-position of first point.
    * @param xpoint2 x-position of second point.
    * @param ypoint2 y-position of second point.
    * @param width  the width of the arrow.
    * @param height  the height of the arrow.
    */
    
    protected void drawHand (Graphics g, int xpoint1, int ypoint1,
                            int xpoint2, int ypoint2, int width, int height) {
       
    
    Graphics2D gr = (Graphics2D) g;       //java graphics 
    int midpointx = xpoint2 - xpoint1;     //midpoint
    int midpointy = ypoint2 - ypoint1;
    double squareroot = Math.sqrt(midpointx*midpointx + midpointy*midpointy);     //squareroot
    double newwidth = squareroot - width;
    double widthvalue = newwidth;
    double pheightvalue = height;
    double nheightvalue = - height;
    double x;
    double sin = midpointy / squareroot;            //sine
    double cos = midpointx / squareroot;            //cosine

    
    x = newwidth*cos - pheightvalue*sin + xpoint1;            //positive height value *sine
    pheightvalue = newwidth*sin + pheightvalue*cos + ypoint1;
    newwidth = x;

    x = widthvalue*cos - nheightvalue*sin + xpoint1;
    nheightvalue = widthvalue*sin + nheightvalue*cos + ypoint1;
    widthvalue = x;

    int[] xpoints = {xpoint2, (int) newwidth, (int) widthvalue};
    int[] ypoints = {ypoint2, (int) pheightvalue, (int) nheightvalue};

    gr.setStroke(new BasicStroke(3));                          //increasing the width/amount of the line
    gr.drawLine(xpoint1, ypoint1, xpoint2, ypoint2);           // drawing line 
    g.fillPolygon(xpoints, ypoints, 3);                       // drawing arrow (polygon)
    }
}
