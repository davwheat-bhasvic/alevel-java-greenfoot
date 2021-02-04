import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cannonball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cannonball extends Actor
{
    protected int xSpeed = 0;
    protected int ySpeed = 0;
    
    protected static final int GRAVITY = 1;
    
    public Cannonball(int angle, int power) {
        power = power / 3;
        xSpeed = (int)(power * Math.cos(Math.toRadians(angle)));
        ySpeed = (int)(power * Math.sin(Math.toRadians(angle)));
    }
    
    /**
     * Act - do whatever the Cannonball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        CannonWorld world = (CannonWorld) getWorld();
        
        setLocation(getX() + xSpeed, getY() + ySpeed);
        ySpeed += GRAVITY;
        
        if (getY() >= world.getHeight() - 1) {
            world.removeObject(this);
            return;
        }
        
        collisionDetection(world);
    }
    
    private void collisionDetection(CannonWorld world) {
        Actor wall = getOneIntersectingObject(Wall.class);
        if (wall != null) {
            world.removeObject(this);
            return;
        }
        
        Actor target = getOneIntersectingObject(Target.class);
        if (target != null) {
            world.removeObject(this);
            return;
        }
    }
}
