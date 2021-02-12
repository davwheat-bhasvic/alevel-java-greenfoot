import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class TextBox extends Common {
    private GreenfootImage image;
    protected static final Font textFont = new Font("Bahnschrift", false, false, 24);
    
    public TextBox(String text, int width, int height) {
        image = new GreenfootImage(width, height);
        image.setColor(Color.WHITE);
        image.setFont(textFont);
        image.drawString(text, 0, 20);
        
        setImage(image);
    } 
}
