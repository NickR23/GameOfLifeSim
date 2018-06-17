
public class Game
{
    //The position of each cell
    private Cell board[][];
    
    public Game(int width, int length)
    {
        board = new Cell[width][length];
        
        board[60][60] = new Cell(60,60);
        board[61][61] = new Cell(61,61);
    }
    public void update()
    {
        
    }
    public Cell[][] getBoard()
    {
        return board;
    }
    public static int getNeighbors(int x, int y)
    {
        int numNeighbors = 0;
        return numNeighbors;
    }
    

}
