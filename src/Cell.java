
public class Cell
{
    private boolean status;
    private int xPos;
    private int yPos;
    
    public Cell(int xPos, int yPos)
    {
        status = true;
        this.xPos = xPos;
        this.yPos = yPos;
    }
    public int getY()
    {
        return yPos;
    }
    public int getX()
    {
        return xPos;
    }
    public boolean isAlive()
    {
        return status;
    }
    
    public void setStatus(boolean newStat)
    {
        status = newStat;
    }
}
