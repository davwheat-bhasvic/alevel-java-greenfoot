import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Crab extends Actor
{
    /**
     * Act - do whatever the Crab wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        handleMovement();
        handleWormCollision();
    }
    
    public void handleMovement() {
        move(3);
        
        if (Greenfoot.isKeyDown("left")) turn(-3);
        if (Greenfoot.isKeyDown("right")) turn(3);
    }
    
    public void handleWormCollision() {
        Actor worm;
        worm = getOneObjectAtOffset(0,0,Worm.class);
        
        // If worm found below crab
        if (worm != null) {
            // Remove the worm
            World world = getWorld();
            world.removeObject(worm);
            Greenfoot.playSound("eating.wav");
        }
    }
}
