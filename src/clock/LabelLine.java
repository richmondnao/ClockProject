/* LabelLine.java */

package clock;

import java.awt.*;

/**
 * Display of the label line beneath a clock
 *
 * @author Russell C. Bjork
 *
 * MODIFIED BY: Richmond Obeng.
 */
public class LabelLine {


    /** Constructor
     *
     *  @param leftX the X coordinate of the upper left corner of the bounding
     *         rectangle for the line relative to upper left corner of clock
     *  @param upperY the Y coordinate of the upper left corner of the bounding
     *         rectangle for the line relative to upper left corner of clock
     *  @param lineWidth the width available for the line - displayed line will
     *         be centered within this width
     *  @param label the descriptive text to be displayed in this line
     *  @param color the color of the line
     */
    public LabelLine(int leftX, 
                     int upperY,
                     int lineWidth,
                     String label,
                     Color color) {

        this.leftX = leftX;
        this.upperY = upperY;
        this.lineWidth = lineWidth;
        this.label = label;
        this.color = color;
    }

    /** Draw this line
     *
     *  @param graphics the graphics object on which to draw
     */
    public void draw(Graphics graphics) {

        graphics.setColor(color);

        // This may seem like an unnecessary step - but later the content of the
        // line will include information in addition to the label
        
        String content = label;

        // Calculate padding needed to center content if possible

        int contentWidth = graphics.getFontMetrics().stringWidth(content);
        int paddingToCenter;
        if (contentWidth < lineWidth)
            paddingToCenter = (lineWidth - contentWidth) / 2;
        else
            // Not enough room to center
            paddingToCenter = 0;

        // Draw the content - note that, for drawString(), the method requires
        // the Y parameter to be the font baseline.  The getAscent() method
        // of the font metrics gives the distance from the baseline to the
        // height of the tallest character, which is what upperY specifies

        graphics.drawString(content,
                            leftX + paddingToCenter,
                            upperY + graphics.getFontMetrics().getAscent());
        
        }
    

    // Values passed to the constructor

    private final int leftX;
    private final int upperY;
    private final int lineWidth;
    public String label;
    private final Color color;
    
}
