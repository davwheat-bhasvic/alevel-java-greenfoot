import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Launcher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Launcher extends Actor
{
    private int delay = 0;
    
    /**
     * Act - do whatever the Launcher wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        handleMovement();
    }
    
    private void handleMovement() {
        final int movementFactor = 5;
        
        if (Greenfoot.isKeyDown("right")) {
            move(movementFactor);
        }
        if (Greenfoot.isKeyDown("left")) {
            move(-movementFactor);
        }
        
        if (Greenfoot.isKeyDown("space") && delay == 0) {
            getWorld().addObject(new Rocket(), getX(), getY());
            delay = 25;
        }
        
        if (delay > 0) {
            delay--;
        }
    }
}
