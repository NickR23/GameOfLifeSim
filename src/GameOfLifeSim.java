import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class GameOfLifeSim
{
    public static final int BOARD_WIDTH = 80;
    public static final int BOARD_LENGTH = 80;  
    private JFrame frame;
    private Grid grid;
    private GameWorld world;
    
    public GameOfLifeSim()
    {
        frame = new JFrame("Game Of Life");
        grid = new Grid();
        world = new GameWorld(BOARD_WIDTH, BOARD_LENGTH);        
        frame.setSize(800, 800);

        frame.add(world);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    
    public static void main(String args[])
    {
        new GameOfLifeSim();
        System.out.println("Init...");
    }
}
