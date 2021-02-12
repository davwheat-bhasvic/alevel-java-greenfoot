import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;

public class Menu extends World {
    private Sound themeSong;
    
    private int selectedItem = 0;
    private List<MenuItem> allItems = new ArrayList();
    
    private MenuItem playButton;
    private MenuItem exitButton;
    private TextBox menuInstructions;
    
    private Logo logo;
    
    private int delay = 0;
    private static final int maxDelay = 12;
    
    private TextBox rules;
    
    public Menu() {
        super(1000, 800, 1);
        themeSong = new Sound("theme.mp3", 50);
        
        showMainMenu();
    }
    
    public void act() {
        if (!themeSong.isPlaying()) {
            themeSong.playSound(true);
        }
        
        if (delay == 0) {
            handleMenuNavigation();
            
            for (MenuItem item : allItems) {
                item.deselect();
            }
            
            allItems.get(selectedItem).select();
        } else {
            delay--;
        }
        
        handleMenuSelection();
    }
    
    private void handleMenuNavigation() {
        if (Greenfoot.isKeyDown("up")) {
            selectedItem--;
            delay = maxDelay;
        }
        if (Greenfoot.isKeyDown("down")) {
            selectedItem++;
            delay = maxDelay;
        }
        
        if (selectedItem < 0) {
            selectedItem = allItems.size() - 1;
        } else if (selectedItem > allItems.size() - 1) {
            selectedItem = 0;
        }
    }
    
    private void handleMenuSelection() {
        if (Greenfoot.isKeyDown("enter") && delay == 0) {
            if (selectedItem == 1) {
                Greenfoot.stop();
                themeSong.stopSound();
                return;
            } else if (rules != null) {
                // Rules shown
                delay = maxDelay;
                Greenfoot.setWorld(new CircuitPicker());
                themeSong.stopSound();
            } else {
                // Rules not shown
                delay = maxDelay;
                showRules();
            }
        }
    }
    
    private void showRules() {
        removeObject(playButton);
        removeObject(exitButton);
        removeObject(menuInstructions);
        
        rules = new TextBox("Your display must be 1080p or higher to show the track correctly.\n\nPlayer 1 drives using WASD.\n\nPlayer 2 drives with arrow keys.\n\nYou must stay on the circuit.\n\nDriving over the grass is impossible.", 700, 300);
        
        addObject(rules, 500, 400);
        
        playButton = new MenuItem("Next");
        addObject(playButton, 300, 700);
        
        allItems.clear();
        allItems.add(playButton);
        
        selectedItem = 0;
        playButton.select();
    }
    
    private void showMainMenu() {
        playButton = new MenuItem("Start");
        exitButton = new MenuItem("Exit");
        menuInstructions = new TextBox("Use UP/DOWN to navigate, and ENTER to select.", 510, 30);
        rules = null;
        
        logo = new Logo();
        
        addObject(playButton, 300, 450);
        addObject(exitButton, 300, 550);
        addObject(menuInstructions, 500, 725);
        
        addObject(logo, 500, 100);
        
        setBackground("dark-background.png");
        
        playButton.select();
        
        allItems.clear();
        allItems.add(playButton);
        allItems.add(exitButton);
    }
}
