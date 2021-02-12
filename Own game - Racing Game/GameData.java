public class GameData {
    public String circuitName;
    public int player1car;
    public int player2car;
    public int totalLaps = 3;

    /**
     * Constructor for objects of class GameData
     */
    public GameData() {
    }
    
    public CircuitData getCircuitData() {
        switch (circuitName) {
            default:
            case "monza": {
                return CircuitData.Monza();
            }
            case "spa": {
                return CircuitData.Spa();
            }
            case "monaco": {
                return CircuitData.Monaco();
            }
        }
    }
}
