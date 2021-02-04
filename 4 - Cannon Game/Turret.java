import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Turret here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Turret extends Actor
{
    protected int rotation = 270;
    
    private static int maxRotation = 340;
    private static int minRotation = 200;
    
    protected int power = 100;
    
    private static int maxPower = 100;
    private static int minPower = 1;
    
    protected StatusBoard statusBoard;
    
    public Turret(StatusBoard sb) {
        setRotation(rotation);
        
        statusBoard = sb;
    }
    
    /**
     * Act - do whatever the Turret wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        CannonWorld world = (CannonWorld) getWorld();
        
        
        java.util.List x = world.getObjects(Cannonball.class);
        boolean cannonBallsExist = !x.isEmpty();
        
        handleRotation();
        handlePower();
        handleCannonBallShoot(cannonBallsExist, world);
        
        setRotation(rotation);
        
        statusBoard.setValues(rotation - 270, power);
    }
    
    private void handleRotation() {
        if (Greenfoot.isKeyDown("left")) {
            rotation--;
        }
        if (Greenfoot.isKeyDown("right")) {
            rotation++;
        }
        
        if (rotation < minRotation) {
            rotation = minRotation;
        } else if (rotation > maxRotation) {
            rotation = maxRotation;
        }
    }
    
    private void handlePower() {
        if (Greenfoot.isKeyDown("up")) {
            power++;
        }
        if (Greenfoot.isKeyDown("down")) {
            power--;
        }
        
        if (power < minPower) {
            power = minPower;
        } else if (power > maxPower) {
            power = maxPower;
        }
    }
    
    private void handleCannonBallShoot(boolean cannonBallsExist, CannonWorld world) {
        if (Greenfoot.isKeyDown("space") && !cannonBallsExist) {
            world.addObject(new Cannonball(rotation, power), getX(), getY());
        }
    }
}
