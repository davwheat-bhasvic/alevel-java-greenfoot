import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AirRaidWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AirRaidWorld extends World
{
    private int score = 0;
    private int lives = 5;
    
    private StatusBoard sb;

    /**
     * Constructor for objects of class AirRaidWorld.
     * 
     */
    public AirRaidWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        addObject(new Launcher(), 300, 376);
        addObject(new Plane(), 100, 30);
        
        sb = new StatusBoard();
        addObject(sb, 30, 15);
        sb.updateStatus(score, lives);
    }
    
    public void incrementScore() {
        score++;
        sb.updateStatus(score, lives);
    }
    
    public int getScore() {
        return score;
    }
    
    public void loseLife() {
        lives--;
        sb.updateStatus(score, lives);
        
        if (lives <= 0) Greenfoot.stop();
    }
    
    public int getLives() {
        return lives;
    }
}
