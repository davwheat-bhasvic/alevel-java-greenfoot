/**
 * Write a description of class Coord2D here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coord2D  
{
    public final int x;
    public final int y;
    
    public final double xExact;
    public final double yExact;

    public Coord2D(int x, int y)
    {
        this.x = x;
        this.y = y;
        
        this.xExact = (double) x;
        this.yExact = (double) y;
    }

    public Coord2D(double x, double y)
    {
        this.x = (int) Math.round(x);
        this.y = (int) Math.round(y);
        
        this.xExact = x;
        this.yExact = y;
    }
}
