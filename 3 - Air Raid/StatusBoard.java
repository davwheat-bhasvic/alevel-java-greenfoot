import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * Write a description of class StatusBoard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StatusBoard extends Actor
{
    private static final String scoreLabel = "Score: ";
    private static final String livesLabel = "Lives: ";
    
    private GreenfootImage box;
    
    public StatusBoard()
    {
        box = new GreenfootImage(60, 30);
        
        box.setColor(Color.WHITE);
        box.fillRect(0,0, 100, 30);

        updateStatus(0, 0);
    }
    
    public void updateStatus(int score, int lives)
    {
        GreenfootImage img = new GreenfootImage (box);
        
        img.setColor (Color.BLACK);
        img.drawString(scoreLabel + score, 5, 12);
        img.drawString(livesLabel + lives, 5, 25);
        
        setImage(img);
    }
}
