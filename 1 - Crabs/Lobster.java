import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lobster here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lobster extends Actor
{
    /**
     * Act - do whatever the Lobster wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        handleMovement();
    }
    
    public void handleMovement() {
        move(4);
        
        // 1 in 10 chance
        if (Greenfoot.getRandomNumber(100) < 10) {
            turn(Greenfoot.getRandomNumber(90) - 45);
        }
        
        World world = getWorld();
        
        if (getX() <= 5 || getX() >= world.getWidth() - 5) {
            turn(180);
        }
        
        if (getY() <= 5 || getY() >= world.getWidth() - 5) {
            turn(180);
        }
    }
}
