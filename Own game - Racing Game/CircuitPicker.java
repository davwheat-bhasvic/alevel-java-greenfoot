import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CircuitPicker extends World {
    private Sound themeSong;
    private GameData gameData = new GameData();
    
    private int selectedItem = 0;
    private int selectedCircuit = 0;
    
    private MenuItem continueButton;
    private TextBox menuInstructions;
    
    private Logo logo;
    
    private List<CircuitView> circuitOptions;
    
    private int delay = 0;
    private static final int maxDelay = 12;
    
    private TextBox rules;
    
    private LeftArrowIndicator leftArrow;
    private RightArrowIndicator rightArrow;
    
    private CircuitView c1 = null;
    private CircuitView c2 = null;
    private CircuitView c3 = null;
    
    public CircuitPicker() {
        // False allows actors to leave screen
        super(1000, 800, 1, false);
        themeSong = new Sound("buildUp.mp3", 50);
        themeSong.playSound(true);
        
        addObject(new TextBox("Choose your circuit.", 215, 40), 500, 250);

        continueButton = new MenuItem("Confirm track");
        menuInstructions = new TextBox("Use UP/DOWN to navigate, LEFT/RIGHT to choose a circuit, and ENTER to select.", 855, 30);
        
        logo = new Logo();
        circuitOptions = new ArrayList();
        
        addObject(continueButton, 500, 625);
        addObject(menuInstructions, 500, 725);
        
        addObject(logo, 500, 100);
        
        setBackground("dark-background.png");
        
        circuitOptions.add(new CircuitView("monza"));
        circuitOptions.add(new CircuitView("spa"));
        
        c2 = circuitOptions.get(0);
        c3 = circuitOptions.get(1);
        
        addObject(c2, 500, 400);
        addObject(c3, 950, 400);
        
        leftArrow = new LeftArrowIndicator();
        rightArrow = new RightArrowIndicator();
        
        addObject(leftArrow, 300, 400);
        addObject(rightArrow, 700, 400);
    }
        
    private void animateCircuits() {
        if (c1 != null) { removeObject(c1); }
        if (c2 != null) { removeObject(c2); }
        if (c3 != null) { removeObject(c3); }
        
        if (selectedCircuit == 0) {
            c1 = null;
            c2 = circuitOptions.get(selectedCircuit);
            c3 = circuitOptions.get(selectedCircuit + 1);
            
            addObject(c2, 500, 400);
            addObject(c3, 950, 400);
        } else if (selectedCircuit == circuitOptions.size() - 1) {
            c1 = circuitOptions.get(selectedCircuit - 1);
            c2 = circuitOptions.get(selectedCircuit);
            c3 = null;
            
            addObject(c1, 50, 400);
            addObject(c2, 500, 400);
        } else {
            c1 = circuitOptions.get(selectedCircuit - 1);
            c2 = circuitOptions.get(selectedCircuit);
            c3 = circuitOptions.get(selectedCircuit + 1);
            
            addObject(c1, 50, 400);
            addObject(c2, 500, 400);
            addObject(c3, 950, 400);
        }
        
        gameData.circuitName = c2.circuitName;
    }
    
    public void act() {
        if (delay == 0) {
            handleMenuNavigation();
            handleCircuitPickerNavigation();
            
            if (selectedItem == 1) {
                removeObject(leftArrow);
                removeObject(rightArrow);
                continueButton.select();
            } else {
                addObject(leftArrow, 300, 400);
                addObject(rightArrow, 700, 400);
                continueButton.deselect();
            }
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
            selectedItem = 1;
        } else if (selectedItem > 1) {
            selectedItem = 0;
        }
    }
    
    private void handleMenuSelection() {
        if (Greenfoot.isKeyDown("enter")) {
            if (selectedItem == 1) {
                nextScreen();
            }
        }
    }
    
    private void handleCircuitPickerNavigation() {
        if (selectedItem != 0) return;
        
        boolean changed = false;
        
        if (Greenfoot.isKeyDown("left") && selectedCircuit != 0) {
            selectedCircuit--;
            changed = true;
            delay = maxDelay;
        }
        
        if (Greenfoot.isKeyDown("right") && selectedCircuit != circuitOptions.size() - 1) {
            selectedCircuit++;
            changed = true;
            delay = maxDelay;
        }
        
        if (changed) {
            animateCircuits();
        }
    }
    
    private void nextScreen() {
        Greenfoot.setWorld(new Player1CarSelect(themeSong, gameData));
    }
}
