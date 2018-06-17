import javax.swing.*;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class Grid extends JPanel
{
    /**
     * 
     */
    private static final long serialVersionUID = 2892865424401791072L;

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        //Draw lines parallel to y-axis
        for(int i = 0; i < 800; i = i + 4)
        {
            g2d.drawLine(i, 0, i, 800);
        }
        
        //Draw lines parallel to x-axis
        for(int i = 0; i < 800; i = i + 4)
        {
            g2d.drawLine(0, i, 800, i);
        }
    }
}
