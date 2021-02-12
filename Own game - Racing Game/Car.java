import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Car here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Car extends SmoothMover {
    public final int carNumber;
    
    public Car(int carNumber) {
        this.carNumber = carNumber;
        
        GreenfootImage image = new GreenfootImage("cars/car" + carNumber + ".png");
        
        setRotation(90);
        
        setImage(image);
    }
    
    /**
     * Sets the rotation of the car, with 0 being directly up (North).
     */
    protected void setRot(int rot) {
        if (rot > 90) setRotation(rot - 90);
        else setRotation(rot + 270);
    }
    
    /**
     * Returns the rotation of the car, with 0 being directly up (North).
     */
    protected int getRot() {
        int rot = getRotation();
        
        if (rot < 270) return rot + 90;
        else return rot - 270;
    }
}
