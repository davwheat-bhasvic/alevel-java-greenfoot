import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Crate here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Crate extends Actor
{
    /**
     * Act - do whatever the Crate wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setRotation(90);
        move(1);
        
        final AirRaidWorld world = (AirRaidWorld) getWorld();
        
        if (getY() >= world.getHeight() - 1) {
            world.removeObject(this);
            world.loseLife();
        }
    }    
}
