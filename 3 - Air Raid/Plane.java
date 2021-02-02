import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Plane here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Plane extends Actor
{
    final float percentageChanceOfCrateDrop = 1;
    
    /**
     * Act - do whatever the Plane wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        final World world = getWorld();
        
        move(5);
        int x = getX();
        
        if (x <= 0 || x >= world.getWidth() - 1) {
            turn(180);
        }
        
        if (Greenfoot.getRandomNumber(1000) <= percentageChanceOfCrateDrop * 10) {
            dropCrate();
        }
    }
    
    private void dropCrate() {
        final int x = getX();
        final int y = getY();
        
        getWorld().addObject(new Crate(), x, y);
    }
}
