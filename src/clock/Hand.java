/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clock;

import java.awt.*;

/**
 *
 * @author richmond
 */
public class Hand extends java.lang.Object {
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
    
    public Hand(int centerX, 
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
        graphics.drawLine(centerX, centerY,
                    (int)((length * Math.sin(Math.toRadians(angle))) + centerX ) ,
                    (int)((-length * Math.cos(Math.toRadians(angle))) + centerY)) ;        
    }
    
    
    
    /** Set the angle for this hand
     * @param angle the angle (in degrees relative to vertical) for this hand
     */
    
    public void setAngle(long angle){
        this.angle = angle;
        
        
    }
}
