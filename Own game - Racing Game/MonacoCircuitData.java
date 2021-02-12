public class MonacoCircuitData extends CircuitData {
    public MonacoCircuitData() {
        this.player1Start = new Coord2D(73, 318);
        this.player2Start = new Coord2D(124, 341);
        
        this.overlayPos = new Coord2D(710, 37);
        this.lightsPos = new Coord2D(710, 37);
        
        this.startingRotation = 32;
        
        this.sector1bounds = new Tuple<Coord2D, Coord2D>(new Coord2D(0, 0), new Coord2D(817, 291));
        this.sector2bounds = new Tuple<Coord2D, Coord2D>(new Coord2D(817, 0), new Coord2D(1420, 771));
        this.sector3bounds = new Tuple<Coord2D, Coord2D>(new Coord2D(0, 291), new Coord2D(817, 771));
    }
}
