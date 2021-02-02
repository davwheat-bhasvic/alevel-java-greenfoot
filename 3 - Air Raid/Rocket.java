import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rocket here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rocket extends Actor
{    
    /**
     * Act - do whatever the Rocket wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {        
        final AirRaidWorld world = (AirRaidWorld) getWorld();
        
        setRotation(270); // face up
        move(10);
        
        if (getY() <= 0) {
            world.removeObject(this);
            return;
        }
        
        final java.util.List<Crate> crates = getObjectsInRange(20, Crate.class);
        
        if (!crates.isEmpty()) {
            final Crate crate = (Crate) crates.toArray()[0];
           
            world.removeObject(crate);
            world.removeObject(this);
            world.incrementScore();
            return;
        }    
        
        final java.util.List<Plane> planes = getObjectsInRange(20, Plane.class);
        
        if (!planes.isEmpty()) {
            final Plane plane = (Plane) planes.toArray()[0];
           
            world.removeObject(plane);
            world.removeObject(this);
            world.incrementScore();
            return;
        }    
    }
}
