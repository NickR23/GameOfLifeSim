import java.util.ArrayList;


public class Game
{
    public static final int BOARD_HEIGHT = 80;
    public static final int BOARD_LENGTH = 80;  
    //The position of each cell
    private Cell board[][];
    private ArrayList<Cell> cells;
    private ArrayList<BabyCell> babyCells;
    
    public Game()
    {
        board = new Cell[BOARD_HEIGHT][BOARD_LENGTH];
        cells = new ArrayList<Cell>();
        

    }
    
    //Adds cells to game. x is the c pos of cell. y is the r pos of cell.
    public void addCell(int x, int y)
    {
        if(x >= BOARD_LENGTH)
        {
            x -= BOARD_LENGTH;
        }
        else if (x < 0)
        {
            x += BOARD_LENGTH - 1;
        }
        if(y >= BOARD_HEIGHT)
        {
            y -= BOARD_HEIGHT;
        }
        else if (y < 0)
        {
            y += BOARD_HEIGHT - 1;
        }
        
        board[x][y] = new Cell(x,y);
        cells.add(board[x][y]);

        
        //System.out.println("New Cell!\nX Pos = " + x + " Y Pos = " + y);

    }
    
    //Runs with every cycle...
    //Game Logic
    public void update()
    {
        babyCells = new ArrayList<BabyCell>();
        for(Cell cell: cells)
        {
            int neighborCount = getNeighbors(cell);

            if (cell.getStatus() == true)
            {
                if(neighborCount < 2)
                {
                    cell.setFutureStatus(false);
                }
                else if(neighborCount > 3)
                {
                    cell.setFutureStatus(false);
                }
            }
            else
            {
                if(neighborCount == 3)
                {
                    cell.setFutureStatus(true);
                }
            }
        }
        
        //Making babies!
        for(Cell cell: cells)
        {
            for(int r = cell.getX() - 1; r < cell.getX() + 2; r++)
            {
                for(int c = cell.getY() - 1; c < cell.getY() + 2; c++)
                {
                    makingBabiesHelp(r, c, babyCells);
                }
           }
        }            

        for(BabyCell babies: babyCells)
        {
            int x = babies.getX();
            int y = babies.getY();
            if(x >= BOARD_LENGTH)
            {
                x -= BOARD_LENGTH;
            }
            else if(x < 0)
            {
                x += BOARD_LENGTH;
            }
            
            if (y >= BOARD_HEIGHT)
            {
                y -= BOARD_HEIGHT;
            }
            else if (y < 0)
            {
                y += BOARD_HEIGHT;
            }
            if (board[x][y] == null)
            {
                addCell(x, y);
            }
            else if (board[x][y].getStatus() == false)
            {
                board[x][y].setFutureStatus(true);
               
            }
        }
        //System.out.println(getNeighbors(board[12][12]));
        for(int i = 0; i < cells.size(); i++)
        {
            if(!cells.get(i).getFutureStatus())
            {                
                board[cells.get(i).getX()][cells.get(i).getY()] = null;
                cells.remove(cells.get(i));

                //System.out.println(cells.get(i));
            }
            else
            {
                cells.get(i).updateStatus();
            }
        }
    }
    
    private boolean inBounds(int x, int y)
    {
        if (x >= BOARD_LENGTH || x < 0 || y >= BOARD_HEIGHT || y < 0)
        {
            return false;
        }
        return true;
    }
    private void makingBabiesHelp(int r, int c, ArrayList<BabyCell> babyCells)
    { 
        int numNeighbors = 0;
        for(int i = r - 1; i < r + 2; i++)
        {
            for(int j = c - 1; j < c + 2; j++)
            {
                if(i >= 0 && j >= 0 && i < board.length && j < board[i].length)
                {
                    if (board[i][j] != null && board[i][j].getStatus())
                    {
                        numNeighbors++;
                    }
                }
            }
        }
        if(numNeighbors == 3)
        {
            babyCells.add(new BabyCell(r, c));
        }
    }
    
    public ArrayList<Cell> getCells()
    {
        return cells;
    }
    public Cell[][] getBoard()
    {
        return board;
    }
    
    //returns number of neighboring  LIVE cells
    public int getNeighbors(Cell subject)
    {
        int numNeighbors = 0;
        //System.out.println(board[1][0]);
        for(int r = subject.getX() - 1; r < subject.getX() + 2; r++)
        {
            for(int c = subject.getY() - 1; c < subject.getY() + 2; c++)
            {
                //System.out.println("Checking x=" + r + "y=" + c);
                if(r >= 0 && c >= 0 && r < board.length && c < board[r].length)
                {
                    if (board[r][c] != null && board[r][c].getStatus())
                    {
                        numNeighbors++;
                        //System.out.println("YES");
                    }
                }
            }
        }
        if(subject.getStatus() == true)
        {
            numNeighbors--;
        }
        return numNeighbors;
    }
    

}
