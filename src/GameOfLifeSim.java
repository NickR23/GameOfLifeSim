import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;

public class GameOfLifeSim
{

    private JFrame frame;
    private JPanel buttonPanel;
    private JButton startButton;
    private GameWorld world;
    
    public GameOfLifeSim()
    {
        frame = new JFrame("Game Of Life");
        startButton = new JButton("Start");
        buttonMaker();
        world = new GameWorld();        
        frame.setSize(800, 820);
        buttonPanel = new JPanel();
        buttonPanel.add(startButton);
        buttonPanel.setSize(50,20);

        frame.add(world);
        frame.add(buttonPanel,BorderLayout.PAGE_END);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    private void buttonMaker()
    {
        startButton.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    world.startTimer();
                }

            }
        );
    }
    
    
    public static void main(String args[])
    {
        new GameOfLifeSim();
        System.out.println("Init...");
    }
}
