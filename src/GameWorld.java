import javax.swing.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class GameWorld extends JPanel
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Game game;
    //Cell bodies
    private Rectangle body;
    
    public GameWorld(int width,int length)
    {
        game = new Game(width, length);
        game.update();
        body = new Rectangle(10,10);
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        //Draw grid
        for(int i = 0; i <= 800; i = i + 10)
        {
            g2d.drawLine(i, 0, i, 800);
            g2d.drawLine(0, i, 800, i);
        }
        g2d.setColor(Color.MAGENTA);
        //Draw cells
        for(int r = 0; r < game.getBoard().length; r++)
        {
            for(int c = 0; c < game.getBoard()[r].length; c++)
            {
                if (game.getBoard()[r][c] != null)
                {
                    System.out.println(game.getBoard()[r][c].getX());
                    body.setLocation(game.getBoard()[r][c].getX() * 10, game.getBoard()[r][c].getY() * 10);
                    g2d.fill(body);
                }
            }
        }
    }
}
