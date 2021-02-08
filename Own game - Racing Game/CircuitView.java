
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
    
/**
 * Write a description of class CircuitView here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CircuitView extends Actor {
    protected final int desiredWidth = 350;
    protected final int desiredHeight = 150;
    
    protected int originalX;
    protected int originalY;
    
    protected int targetX;
    protected int targetY;
    
    protected final int animationSteps = 10;
    
    public final String circuitName;
        
    public CircuitView(String circuitName) {
        this.circuitName = circuitName;
        
        setImage("circuits/" + circuitName + ".png");
        GreenfootImage image = getImage();
        
        final double widthScaleMultiplier = (double)desiredWidth / image.getWidth();
        final double heightScaleMultiplier = (double)desiredHeight / image.getHeight();
        
        final double finalMultiplier = Math.min(widthScaleMultiplier, heightScaleMultiplier);
        
        image.scale((int)((double)image.getWidth() * finalMultiplier), (int)((double)image.getHeight() * finalMultiplier));
        setImage(image);
    }
    
    public void addedToWorld() {
        targetX = getX();
        targetY = getY();

        originalX = getX();
        originalY = getY();
    }
    
    /**
     * Act - do whatever the CircuitView wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        int currentX = getX();
        int currentY = getY();
        
        int newX = currentX;
        int newY = currentY;
        
        if (currentX != targetX) {
            // we need to animate to targetX
            int xOriginalDiff = originalX - targetX;
            int xCurrentDiff = currentX - targetX;
            
            // get the step size needed
            int step = xOriginalDiff / animationSteps;
            
            // apply transformation
            if (Math.abs(xCurrentDiff) < Math.abs(step)) {
                // If the step would move it past the target, just set it as the target
                newX = targetX;
            } else {
                newX += step;
            }
        }
    }
    
    public void animateTo(int x, int y) {
       originalX = getX();
       originalY = getY();
       
       targetX = x;
       targetY = y;
    }
}
