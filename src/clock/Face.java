/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clock;

import java.awt.*;
import javax.swing.JFrame;

/**
 *
 * @author richmond
 */

/**
 * Draws the Face of a Clock
 *
 */
public class Face extends JFrame{
    
    private final int leftX;
    private final int upperY;
    private final int faceDiameter;
    private final Color color;
    
    /** Constructor
     *
     *  @param leftX the X coordinate of the upper left corner of the bounding
     *         rectangle for the face relative to upper left corner of clock
     *  @param upperY the Y coordinate of the upper left corner of the bounding
     *         rectangle for the face relative to upper left corner of clock
     *  @param faceDiameter  the diameter of the face
     *  @param color  the color of the face
     *
     */
    
    public Face(int leftX, 
                int upperY, 
                int faceDiameter, 
                Color color) {
        
        this.leftX = leftX;
        this.upperY = upperY;
        this.faceDiameter = faceDiameter;
        this.color = color;  
    }
    
    
    
    /**Draw the face 
     * @param graphics the graphics object on which to draw
    */
    
    public void draw(Graphics graphics){
        Graphics2D gr = (Graphics2D) graphics;
        int radius = faceDiameter/2;   //radius of the face
        
        int centerX = leftX + radius;    //center X of the face
        int centerY = upperY + radius;    //center Y of the face
        
        //oval
        graphics.fillOval(centerX-6,centerY-6,faceDiameter/13,faceDiameter/13);  
        
        //first layer background
        gr.setPaint(GRADIENT_PAINT);
        graphics.fillOval(leftX-9, upperY-9, (int)(faceDiameter*1.1), (int)(faceDiameter*1.1));
 
        //image transparency 
        drawTransparent(graphics,0.8f);
        
        // second layer face background
        graphics.setColor(color);
        graphics.fillOval(leftX, upperY, faceDiameter, faceDiameter);
        
        
        // Images for various clocks
        Image img = Toolkit.getDefaultToolkit().getImage("paris.png");
        Image chinaimg = Toolkit.getDefaultToolkit().getImage("china.png");
        Image ghanaimg = Toolkit.getDefaultToolkit().getImage("ghana.png");
        Image brazilimg = Toolkit.getDefaultToolkit().getImage("brazil.png");
        Image bostonimg = Toolkit.getDefaultToolkit().getImage("ma.png");
        
        // if statement checks for drawing the clocks
        if (faceDiameter == 200){
        graphics.drawImage(img, centerX-96, centerY-100, radius*2, radius*2, this);
        }
        else if (faceDiameter == 151){
        graphics.drawImage(chinaimg, centerX-75, centerY-77, (int)(radius *2.05), (int)(radius*2.05), this);
        }
        else if (faceDiameter == 153){
        graphics.drawImage(ghanaimg, centerX-75, centerY-77, (int)(radius *2.05), (int)(radius*2.05), this);
        }
        else if (faceDiameter == 150){
        graphics.drawImage(brazilimg, centerX-75, centerY-77, (int)(radius *2.05), (int)(radius*2.05), this);
        }
        else if (faceDiameter == 152){
        graphics.drawImage(bostonimg, centerX-75, centerY-77, (int)(radius *2.05), (int)(radius*2.05), this);
        }
        
 
        // Actual Clock face 
        graphics.setColor(Color.YELLOW);
        graphics.drawOval(leftX, upperY, faceDiameter, faceDiameter);
        
        //inner circle 
        graphics.setColor(Color.RED);
        graphics.drawOval(leftX + 9, upperY +9, (int)(faceDiameter*0.9), (int)(faceDiameter*0.9));
        
        graphics.setColor(Color.BLACK);
        
        //loop for numbers and tick marks
        
        for (int x = 1; x < 61; x++){       
            if(x % 5 == 0) {
                String number = "" + x/5;
                int width = graphics.getFontMetrics().stringWidth(number);
                int height = graphics.getFontMetrics().getAscent();
                
                ////////////////////////////////////////////////////////////////
               graphics.drawString(number,                                       ///////// Got help from TA
                    (int)(centerX + Math.sin(Math.PI*x/30)*(radius*0.7) - width/2), ///////Got help from TA
                    (int)(centerY - Math.cos(Math.PI*x/30)*(radius*0.7) + height/2));///////Got help from TA
                ////////////////////////////////////////////////////////////////////
            }            
            int ticks;
            if (x % 5 == 0){
                ticks = radius - 10;             
            }
            else{
                ticks = radius - 5;
            }
            drawRadius((Graphics2D) graphics, x / 60.0, ticks, radius);           
        }
    }
   
    
    /** Draw the HashMarks
     * 
     * @param graphics the java graphics
     * @param percent a fraction of the direction clockwise from 12
     * @param minRadius the number of ticks
     * @param maxRadius amount of required radius
     */
    
    private void drawRadius(Graphics graphics, double percent, int minRadius, int maxRadius) {
        double radians = (1.0 - percent) * (2.0 * (double)Math.PI);
        double sine   = Math.sin(radians);
        double cosine = Math.cos(radians);
        
        int xmin = leftX + faceDiameter/2 + (int)(minRadius * sine);
        int ymin = upperY +faceDiameter/2 + (int)(minRadius * cosine);
        
        int xmax = leftX +faceDiameter/2 + (int)(maxRadius * sine);
        int ymax = upperY + faceDiameter/2 + (int)(maxRadius * cosine);
        graphics.drawLine(xmin, ymin, xmax, ymax);
    }
    
    
    /**Setting Transparency
     * 
     * @param graphics the java graphics. 
     * @param alpha the amount of transparency.
     */
    
    private void drawTransparent(Graphics graphics, float alpha){
        Graphics2D gr = (Graphics2D) graphics;
        gr.setPaint(GRADIENT_PAINT);
        
            AlphaComposite alcom = AlphaComposite.getInstance(
                    AlphaComposite.SRC_OVER, alpha);
            gr.setComposite(alcom);
            //gr.fillRect(leftX, upperY, 10, 10);
    
    }
    
    // instance variables
    private static final Color COLOR_1 = Color.blue;
    private static final Color COLOR_2 = Color.red;
    private static final Paint GRADIENT_PAINT = new GradientPaint(0, 0, COLOR_1, 20, 20, COLOR_2, true);
 }
