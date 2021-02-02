import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ship here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ship extends Actor
{
    /**
     * Act - do whatever the Ship wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        handleMovement();
        handleCollisions();
    }
    
    private void handleMovement() {
        final int turnAngle = 5;
        final int movementFactor = 5;
        
        if (Greenfoot.isKeyDown("left")) {
            turn(-turnAngle);
        }
        if (Greenfoot.isKeyDown("right")) {
            turn(turnAngle);
        }
        
        
        if (Greenfoot.isKeyDown("up")) {
            move(movementFactor);
        }
        if (Greenfoot.isKeyDown("down")) {
            move(-movementFactor);
        }
        
        // Quick turn button
        if (Greenfoot.isKeyDown("space")) {
            turn(180);
        }
    }
    
    private void handleCollisions() {
        final Actor crate = getOneIntersectingObject(Crate.class);
        final Actor sub = getOneIntersectingObject(Submarine.class);
        
        final World world = getWorld();
        
        if (crate != null) world.removeObject(crate);
        if (sub != null) {
            world.removeObject(this);
            Greenfoot.stop();
        }
    }
}
