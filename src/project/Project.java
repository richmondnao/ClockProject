/* Project.java */

package project;

import clock.Clock;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

import javax.swing.*;

/** Main program for CPS122 Individual Project 2
 *
 *  @author Russell C. Bjork
 *  
 *  MODIFIED BY: Richmond Obeng.
 */
public class Project extends JPanel {
    
     
// project background image
    @Override
    protected void paintComponent(Graphics g) {
     BufferedImage img = null;
        try {
            img = ImageIO.read(getClass().getResource("backgroundtest.jpg"));
               } catch (IOException ex) {
            Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
        }
    super.paintComponent(g);
    g.drawImage(img, 0, 0, this);
    }
    
    
     
    
    /** Start execution 
     */
    
    
    public void start()  {
        setLayout(null);
       
        //start of clocks
        
        
        //Brazil SaoPaulo Clock        
                Clock sao_paulo = new Clock(PX_POSITION,
		                       PY_POSITION,
        		               PFACE_DIAMETER,
                		       PLABEL,
		                       PFACE_COLOR,
        		               PHOUR_HAND_COLOR,
                		       PMINUTE_HAND_COLOR,
		                       PSECOND_HAND_COLOR,
        		               PLABEL_LINE_COLOR,
                		       PTIMEZONE_OFFSET);
		add(sao_paulo);
		sao_paulo.start();
        
        //Boston Clock      
                
		Clock boston = new Clock(BX_POSITION,
		                       BY_POSITION,
        		               BFACE_DIAMETER,
                		       BLABEL,
		                       BFACE_COLOR,
        		               BHOUR_HAND_COLOR,
                		       BMINUTE_HAND_COLOR,
		                       BSECOND_HAND_COLOR,
        		               BLABEL_LINE_COLOR,
                		       BTIMEZONE_OFFSET);
		add(boston);
		boston.start();
        
                
	//Ghana Clock	

                Clock ghana = new Clock(GX_POSITION,
		                       GY_POSITION,
        		               GFACE_DIAMETER,
                		       GLABEL,
		                       GFACE_COLOR,
        		               GHOUR_HAND_COLOR,
                		       GMINUTE_HAND_COLOR,
		                       GSECOND_HAND_COLOR,
        		               GLABEL_LINE_COLOR,
                		       GTIMEZONE_OFFSET);
		add(ghana);
		ghana.start();
                
        //China Clock        
                
                Clock china = new Clock(CX_POSITION,
		                       CY_POSITION,
        		               CFACE_DIAMETER,
                		       CLABEL,
		                       CFACE_COLOR,
        		               CHOUR_HAND_COLOR,
                		       CMINUTE_HAND_COLOR,
		                       CSECOND_HAND_COLOR,
        		               CLABEL_LINE_COLOR,
                		       CTIMEZONE_OFFSET);
		add(china);
		china.start();
                
        //Paris Clock        
                Clock paris = new Clock(SPX_POSITION,
		                       SPY_POSITION,
        		               SPFACE_DIAMETER,
                		       SPLABEL,
		                       SPFACE_COLOR,
        		               SPHOUR_HAND_COLOR,
                		       SPMINUTE_HAND_COLOR,
		                       SPSECOND_HAND_COLOR,
        		               SPLABEL_LINE_COLOR,
                		       SPTIMEZONE_OFFSET);
		add(paris);
		paris.start();
                
                
    }
    
    /** Main method for running this as an application
     */
    public static void main (String [] args) {
        
    JFrame frame = new JFrame();
    frame.setSize(APPLICATION_WIDTH, APPLICATION_HEIGHT);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Project project = new Project();
    project.start();
    frame.add(project);
    frame.setVisible(true);
    }
                
    
    
    // Overall dimensions.

// Dimentions for Application
    private static final int APPLICATION_WIDTH = 800;
    private static final int APPLICATION_HEIGHT = 622;
    
    
        //Constants for Boston Clock
	private static final int BX_POSITION = 27;					
	private static final int BY_POSITION = 20;				
	private static final int BFACE_DIAMETER = 152;			
	private static final String BLABEL = "BOSTON MA";
        private static final Color BFACE_COLOR = Color.WHITE;
	private static final Color BHOUR_HAND_COLOR = Color.BLUE;	
	private static final Color BMINUTE_HAND_COLOR = Color.CYAN;	
	private static final Color BSECOND_HAND_COLOR = Color.RED;	
	private static final Color BLABEL_LINE_COLOR = Color.BLUE;	
	private static final String BTIMEZONE_OFFSET = "GMT-05:00";
        
        //Constants for Ghana Clock
        private static final int GX_POSITION = 20;					
	private static final int GY_POSITION = 369;				
	private static final int GFACE_DIAMETER = 153;			
	private static final String GLABEL = "GHANA";
       	private static final Color GFACE_COLOR = Color.WHITE;
       	private static final Color GHOUR_HAND_COLOR = Color.BLUE;	
	private static final Color GMINUTE_HAND_COLOR = Color.CYAN;	
	private static final Color GSECOND_HAND_COLOR = Color.RED;	
	private static final Color GLABEL_LINE_COLOR = Color.YELLOW;	
	private static final String GTIMEZONE_OFFSET = "GMT00:00";

        
        //Brazil SaoPaulo clock
        private static final int PX_POSITION = 595;					
	private static final int PY_POSITION = 20;				
	private static final int PFACE_DIAMETER = 150;			
	private static final String PLABEL = "SAO PAULO";
       	private static final Color PFACE_COLOR = Color.WHITE;
      	private static final Color PHOUR_HAND_COLOR = Color.BLUE;	
	private static final Color PMINUTE_HAND_COLOR = Color.CYAN;	
	private static final Color PSECOND_HAND_COLOR = Color.RED;	
	private static final Color PLABEL_LINE_COLOR = Color.GREEN;	
	private static final String PTIMEZONE_OFFSET = "GMT-03:00";
        
        
        //China clock
        
        private static final int CX_POSITION = 595;					
	private static final int CY_POSITION = 369;				
	private static final int CFACE_DIAMETER = 151;			
	private static final String CLABEL = "CHINA";
	private static final Color CFACE_COLOR = Color.WHITE;
	private static final Color CHOUR_HAND_COLOR = Color.BLUE;	
	private static final Color CMINUTE_HAND_COLOR = Color.CYAN;	
	private static final Color CSECOND_HAND_COLOR = Color.RED;	
	private static final Color CLABEL_LINE_COLOR = Color.RED;	
	private static final String CTIMEZONE_OFFSET = "GMT+08:00";
        
        
        //Paris Clock
        private static final int SPX_POSITION = 295;					
	private static final int SPY_POSITION = 290;				
	private static final int SPFACE_DIAMETER = 200;			
	private static final String SPLABEL = "PARIS";
	private static final Color SPFACE_COLOR = Color.WHITE;
	private static final Color SPHOUR_HAND_COLOR = Color.BLUE;	
	private static final Color SPMINUTE_HAND_COLOR = Color.CYAN;	
	private static final Color SPSECOND_HAND_COLOR = Color.RED;	
	private static final Color SPLABEL_LINE_COLOR = Color.WHITE;	
	private static final String SPTIMEZONE_OFFSET = "GMT+01:00";
              
}
