
public class Cell
{
    private boolean status;
    private boolean futureStatus;
    private int xPos;
    private int yPos;
    
    public Cell(int xPos, int yPos)
    {
        futureStatus = true;
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

    public boolean getStatus()
    {
        return status;
    }
    public boolean getFutureStatus()
    {
        return futureStatus;
    }
    public void setStatus(boolean newStat)
    {
        status = newStat;
    }
    public void setFutureStatus(boolean newStat)
    {
        futureStatus = newStat;
    }
    public void updateStatus()
    {
        status = futureStatus;
    }
}
