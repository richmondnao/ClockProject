/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clock;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author richmond
 */
public class FancySecondHand extends java.lang.Object {
    private final int centerX;
    private final int centerY;
    private final int length;
    private Color color;
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
    
    FancySecondHand(int centerX, 
                int centerY, 
                int length, 
                Color hourHandColor){
        
        
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
       
        drawTransparent(graphics, 1.0f);
      
        }
    
    
    
    /**Setting Transparency
     * 
     * @param graphics the java graphics. 
     * @param alpha the amount of transparency.
     */
    
    private void drawTransparent(Graphics graphics, float alpha){
        Graphics2D gr = (Graphics2D) graphics;
        //center
        int newcenter = (int)((length * Math.sin(Math.toRadians(angle))) + centerX );
        int nextcenter = (int)((-length * Math.cos(Math.toRadians(angle))) + centerY);
        //color
        gr.setPaint(Color.GREEN);
        
            AlphaComposite alcom = AlphaComposite.getInstance(
                    AlphaComposite.SRC_OVER, alpha);
            gr.setComposite(alcom);                          //setting alpha
            gr.fillRect(newcenter, nextcenter, 5,5);        //drawing small rectangle
    }
    
    
    
    /** Set the angle for this hand
     * @param angle the angle (in degrees relative to vertical) for this hand
     */
    
    public void setAngle(long angle){
        this.angle = angle;
    }
    
}
