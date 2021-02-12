import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class DataOverlay extends Actor {
    protected static final Font textFont = new Font("Bahnschrift", true, false, 24);
    protected final int totalLaps;
    
    protected int p1Laps = 0;
    protected int p2Laps = 0;
    
    protected int p1Sector = 1;
    protected int p2Sector = 1;
    
    public DataOverlay(int totalLaps) {
        this.totalLaps = totalLaps;
        
        GreenfootImage image = generateImage("P1: 0/" + totalLaps + "\nP2: 0/" + totalLaps);
        
        setImage(image);
    }
    
    protected GreenfootImage generateImage(String text) {
        GreenfootImage image = new GreenfootImage(160, 75);
        
        // black bg
        image.setColor(Color.BLACK);
        image.fill();
        
        // white text
        image.setColor(Color.WHITE);
        image.setFont(textFont);
        image.drawString(text, 15, 32);
        
        return image;
    }
    
    public void setLapsPlayer1(int currentLap) {
        p1Laps = currentLap;
        
        GreenfootImage image = generateImage("P1: " + p1Laps + "/" + totalLaps + " (S" + p1Sector + ")\nP2: " + p2Laps + "/" + totalLaps + " (S" + p2Sector + ")");
        setImage(image);
    }
    
    public void setLapsPlayer2(int currentLap) {
        p2Laps = currentLap;
        
        GreenfootImage image = generateImage("P1: " + p1Laps + "/" + totalLaps + " (S" + p1Sector + ")\nP2: " + p2Laps + "/" + totalLaps + " (S" + p2Sector + ")");
        setImage(image);
    }
    
    public void setLaps(int p1, int p2) {
        p1Laps = p1;
        p2Laps = p2;
        
        GreenfootImage image = generateImage("P1: " + p1Laps + "/" + totalLaps + " (S" + p1Sector + ")\nP2: " + p2Laps + "/" + totalLaps + " (S" + p2Sector + ")");
        setImage(image);
    }
    
    public void setSectors(int p1, int p2) {
        p1Sector = p1;
        p2Sector = p2;
        
        GreenfootImage image = generateImage("P1: " + p1Laps + "/" + totalLaps + " (S" + p1Sector + ")\nP2: " + p2Laps + "/" + totalLaps + " (S" + p2Sector + ")");
        setImage(image);
    }
}
