import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)



/**
 * Write a description of class ShipGameWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ShipGameWorld extends World
{

    /**
     * Constructor for objects of class ShipGameWorld.
     * 
     */
    public ShipGameWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        
        final int width = getWidth();
        final int height = getWidth();
        
        addObject(new Ship(), width / 2, height / 2);
        
        addObject(new Crate(), 100, 300);
        addObject(new Crate(), 420, 100);
        addObject(new Crate(), 300, 220);
        
        addObject(new Submarine(), 100, 250);
    }
}
