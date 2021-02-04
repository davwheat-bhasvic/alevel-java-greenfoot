import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CannonWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CannonWorld extends World
{
    private StatusBoard sb;
    private Turret turret;
    private Target target;
    
    public CannonWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        int wallY = Greenfoot.getRandomNumber(5) + 1;
        
        sb = new StatusBoard();
        turret = new Turret(sb);
        target = new Target();
        
        addObject(sb, 50, 25);
        addObject(turret, 20 + Greenfoot.getRandomNumber(200), 380);
        
        addObject(target, 360 + Greenfoot.getRandomNumber(200), 380);
        
        sb.setValues(0, 100);
        
        for (int i = 0; i < wallY; i++) {
            addObject(new Wall(), 295, 380 - (50 * i));
        }
    } 
}

