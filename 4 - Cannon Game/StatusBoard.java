import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StatusBoard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StatusBoard extends Actor
{
    private GreenfootImage background;
    
    public StatusBoard() {
        background = new GreenfootImage(100, 50);
        background.setColor(Color.WHITE);
        background.fillRect(0, 0, 100, 50);
        
        setImage(background);
    }
    
    /**
     * Act - do whatever the StatusBoard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    
    public void setValues(int angle, int power) {
        GreenfootImage foreground = new GreenfootImage(background);
        foreground.setColor(Color.BLACK);
        
        foreground.drawString("Angle: " + angle, 10, 20);
        foreground.drawString("Power: " + power, 10, 35);
        
        setImage(foreground);
    }
}
