import javax.swing.JFrame;


public class GameOfLifeSim
{
    private JFrame frame;
    
    public GameOfLifeSim()
    {
        frame = new JFrame("Game Of Life");
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    
    public static void main(String args[])
    {
        new GameOfLifeSim();
        System.out.println("Init...");
    }
}
