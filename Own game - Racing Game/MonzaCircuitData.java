public class MonzaCircuitData extends CircuitData {
    public MonzaCircuitData() {
        this.player1Start = new Coord2D(856, 681);
        this.player2Start = new Coord2D(856, 714);
        
        this.overlayPos = new Coord2D(710, 37);
        this.lightsPos = new Coord2D(710, 37);
        
        this.startingRotation = 270;
        
        this.sector1bounds = new Tuple<Coord2D, Coord2D>(new Coord2D(0, 771), new Coord2D(845, 523));
        this.sector2bounds = new Tuple<Coord2D, Coord2D>(new Coord2D(0, 523), new Coord2D(845, 0));
        this.sector3bounds = new Tuple<Coord2D, Coord2D>(new Coord2D(845, 0), new Coord2D(1420, 771));
    }
}
