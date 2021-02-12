import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class StartingLights extends Actor {
    public StartingLights() {
        setStage(1);
    }
    
    public void setStage(int stage) {
        if (stage > 7) stage = 7;
        if (stage < 1) stage = 1;

        GreenfootImage i = new GreenfootImage("lights" + stage + ".png");
        i.scale(185, 75);
        
        setImage(i);
    }
}
