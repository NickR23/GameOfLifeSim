import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameWorld extends JPanel implements ActionListener
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Timer timer = new Timer(250,this);
    private Game game;
    //Cell bodies
    private Rectangle body;
    private MouseListener ml;
    public void startTimer()
    {
        removeMouseListener(ml);
        timer.start();
    }
    public GameWorld()
    {
        game = new Game();
        body = new Rectangle(10,10);

    }
    
    public void makeMouseListener()
    {
        ml = new MouseListener()
            {
            public void mousePressed(MouseEvent e)
            {
                int x = e.getX();
                int y = e.getY();
                if (game.getBoard()[x/10][y/10] == null)
                {
                    game.addCell(x/10, y/10);
                }
                else
                {
                    game.getCells().remove(game.getBoard()[x/10][y/10]);
                    game.getBoard()[x/10][y/10] = null;
                }
                //System.out.println(e.getX()/10 + " " + e.getY()/10);
                repaint();
            }

            @Override
            public void mouseClicked(MouseEvent arg0)
            {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void mouseEntered(MouseEvent arg0)
            {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void mouseExited(MouseEvent arg0)
            {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void mouseReleased(MouseEvent arg0)
            {
                // TODO Auto-generated method stub
                
            }
            };
            
        this.addMouseListener(ml);
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
        makeMouseListener();

        for(Cell cell: game.getCells())
        {
            //System.out.println(cell.getStatus());
            if(cell.getStatus() == true)
            {
                g2d.setColor(Color.red);
            }
            else if(cell.getStatus() == false)
            {
                g2d.setColor(Color.DARK_GRAY);
            }
            body.setLocation(cell.getX() * 10, cell.getY() * 10);
            g2d.fill(body);
        }

    }

    @Override
    public void actionPerformed(ActionEvent arg0)
    {
        game.update();
        repaint();
    }
}
