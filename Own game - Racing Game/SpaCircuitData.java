public class SpaCircuitData extends CircuitData {
    public SpaCircuitData() {
        this.player1Start = new Coord2D(339, 593);
        this.player2Start = new Coord2D(368, 622);
        
        this.overlayPos = new Coord2D(710, 734);
        this.lightsPos = new Coord2D(710, 37);
        
        this.startingRotation = 227;
        
        this.sector1bounds = new Tuple<Coord2D, Coord2D>(new Coord2D(0, 0), new Coord2D(315, 771));
        this.sector2bounds = new Tuple<Coord2D, Coord2D>(new Coord2D(315, 0), new Coord2D(1420, 353));
        this.sector3bounds = new Tuple<Coord2D, Coord2D>(new Coord2D(315, 353), new Coord2D(1420, 771));
    }
}
