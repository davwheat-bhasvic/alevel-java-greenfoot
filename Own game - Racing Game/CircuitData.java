/**
 * Write a description of class CircuitData here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CircuitData  
{
    public Coord2D player1Start;
    public Coord2D player2Start;
    
    public int startingRotation;
    
    public Coord2D overlayPos;
    public Coord2D lightsPos;
    
    public Tuple<Coord2D, Coord2D> sector1bounds;
    public Tuple<Coord2D, Coord2D> sector2bounds;
    public Tuple<Coord2D, Coord2D> sector3bounds;

    /**
     * Constructor for objects of class CircuitData
     */
    public CircuitData() { }
    
    public static CircuitData Monza() {
        return new MonzaCircuitData();
    }
    
    public static CircuitData Spa() {
        return new SpaCircuitData();
    }
    
    public static CircuitData Monaco() {
        return new MonacoCircuitData();
    }
}
