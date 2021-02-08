import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Car here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Car extends Actor {
    public final int carNumber;
    
    public Car(int carNumber) {
        this.carNumber = carNumber;
        
        GreenfootImage image = new GreenfootImage("cars/car" + carNumber + ".png");
        
        setImage(image);
    }
    
    public void act() {
        
    }    
}
