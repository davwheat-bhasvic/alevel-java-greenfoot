import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MenuItem extends MenuItems {
    private GreenfootImage image;
    private GreenfootImage foreground;
    
    protected static final int width = 300;
    protected static final int height = 70;

    protected static final Color buttonBackground = new Color(30, 30, 30);
    protected static final Color buttonSelectedBackground = new Color(45, 45, 45);
    
    protected static final Font textFont = new Font("Bahnschrift", false, false, 36);
    
    public MenuItem(String text) {        
        foreground = new GreenfootImage(width, height);
        foreground.setColor(Color.WHITE);
        foreground.setFont(textFont);
        foreground.drawString(text, 24, 48);
        
        deselect();
    }
    
    public void select() {
        image = new GreenfootImage(width, height);
        
        // Set background
        image.setColor(buttonSelectedBackground);
        image.fill();
        
        // White outline
        image.setColor(new Color(128, 128, 128));
        image.drawRect(0, 0, width-1, height-1);
        
        // Draw text
        image.drawImage(foreground, 0, 0);
        
        setImage(image);
    }
    
    public void deselect() {
        image = new GreenfootImage(width, height);
        
        image.setColor(buttonBackground);
        image.fill();
        image.drawImage(foreground, 0, 0);
        
        setImage(image);
    }
}
