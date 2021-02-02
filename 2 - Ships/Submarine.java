import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Submarine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Submarine extends Actor
{
    /**
     * Act - do whatever the Submarine wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        handleMovement();
    }
    
    private void handleMovement() {
        move(5);
        
        final World world = getWorld();
        final int maxX = world.getWidth() - 1;
        final int maxY = world.getHeight() - 1;
        
        final int x = getX();
        final int y = getY();
        
        if (x <= 0 || x >= maxX) {
            turn(180 + (Greenfoot.getRandomNumber(90) - 45));
        }
        
        if (y <= 0 || y >= maxY) {
            turn(180 + (Greenfoot.getRandomNumber(90) - 45));
        }
    }
}
