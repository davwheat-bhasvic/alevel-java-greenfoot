import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;

class CarSelect extends World {
    protected GameData gameData;
    
    protected Sound buildUpSound;
    protected int playerNumber = 1;
    
    private int selectedItem = 0;
    private int selectedCar = 0;
    
    private MenuItem continueButton;
    private TextBox menuInstructions;
    
    private Logo logo;
    
    private List<Car> carOptions;
    
    private int delay = 0;
    private static final int maxDelay = 12;
    
    private TextBox rules;
    
    private LeftArrowIndicator leftArrow;
    private RightArrowIndicator rightArrow;
    
    private Car c1 = null;
    private Car c2 = null;
    private Car c3 = null;
    private Car c4 = null;
    private Car c5 = null;
    
    private int c1pos = 100;
    private int c2pos = 225;
    private int c3pos = 500;
    private int c4pos = 775;
    private int c5pos = 900;

    public CarSelect(int playerNumber, Sound buildUpSound, GameData gameData) {
        super(1000, 800, 1);
        
        this.buildUpSound = buildUpSound;
        this.playerNumber = playerNumber;
        
        this.gameData = gameData;
        
        addObject(new TextBox("Choose car for Player " + playerNumber + ".", 250, 40), 500, 250);
        
        render();
    }
    
    private void render() {
        continueButton = new MenuItem("Confirm car");
        menuInstructions = new TextBox("Use UP/DOWN to navigate, LEFT/RIGHT to choose a car, and ENTER to select.", 855, 30);
        
        logo = new Logo();
        carOptions = new ArrayList();
        
        addObject(continueButton, 500, 625);
        addObject(menuInstructions, 500, 725);
        
        addObject(logo, 500, 100);
        
        setBackground("dark-background.png");
        
        for (int i = 1; i <= 18; i++) {
            if (playerNumber == 1 || i != gameData.player1car) {
                carOptions.add(new Car(i));
            }
        }
        
        c3 = carOptions.get(0);
        c4 = carOptions.get(1);
        c5 = carOptions.get(2);
        
        if (playerNumber == 1) gameData.player1car = c3.carNumber;
        else gameData.player2car = c3.carNumber;
        
        addObject(c3, c3pos, 400);
        addObject(c4, c4pos, 400);
        addObject(c5, c5pos, 400);
        
        leftArrow = new LeftArrowIndicator();
        rightArrow = new RightArrowIndicator();
        
        addObject(rightArrow, 620, 400);
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
                continueButton.deselect();
            }
        } else {
            delay--;
        }
        
        handleMenuSelection();
    }
    
    private void animateCircuits() {
        if (c1 != null) { removeObject(c1); }
        if (c2 != null) { removeObject(c2); }
        if (c3 != null) { removeObject(c3); }
        if (c4 != null) { removeObject(c4); }
        if (c5 != null) { removeObject(c5); }
        
        if (selectedCar == 0) {
            c1 = null;
            c2 = null;
            c3 = carOptions.get(selectedCar);
            c4 = carOptions.get(selectedCar + 1);
            c5 = carOptions.get(selectedCar + 2);
            
            addObject(c3, c3pos, 400);
            addObject(c4, c4pos, 400);
            addObject(c5, c5pos, 400);
        } else if (selectedCar == 1) {
            c1 = null;
            c2 = carOptions.get(selectedCar - 1);
            c3 = carOptions.get(selectedCar);
            c4 = carOptions.get(selectedCar + 1);
            c5 = carOptions.get(selectedCar + 2);
            
            addObject(c2, c2pos, 400);
            addObject(c3, c3pos, 400);
            addObject(c4, c4pos, 400);
            addObject(c5, c5pos, 400);
        } else if (selectedCar == carOptions.size() - 2) {
            c1 = carOptions.get(selectedCar - 2);
            c2 = carOptions.get(selectedCar - 1);
            c3 = carOptions.get(selectedCar);
            c4 = carOptions.get(selectedCar + 1);
            c5 = null;
            
            addObject(c1, c1pos, 400);
            addObject(c2, c2pos, 400);
            addObject(c3, c3pos, 400);
            addObject(c4, c4pos, 400);
        } else if (selectedCar == carOptions.size() - 1) {
            c1 = carOptions.get(selectedCar - 2);
            c2 = carOptions.get(selectedCar - 1);
            c3 = carOptions.get(selectedCar);
            c4 = null;
            c5 = null;
            
            addObject(c1, c1pos, 400);
            addObject(c2, c2pos, 400);
            addObject(c3, c3pos, 400);
        } else {
            c1 = carOptions.get(selectedCar - 2);
            c2 = carOptions.get(selectedCar - 1);
            c3 = carOptions.get(selectedCar);
            c4 = carOptions.get(selectedCar + 1);
            c5 = carOptions.get(selectedCar + 2);
            
            addObject(c1, c1pos, 400);
            addObject(c2, c2pos, 400);
            addObject(c3, c3pos, 400);
            addObject(c4, c4pos, 400);
            addObject(c5, c5pos, 400);
        }
        
        if (playerNumber == 1) gameData.player1car = c3.carNumber;
        else gameData.player2car = c3.carNumber;
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
        
        updateArrows();
        
        if (Greenfoot.isKeyDown("left") && selectedCar != 0) {
            selectedCar--;
            changed = true;
            delay = maxDelay;
        }
        
        if (Greenfoot.isKeyDown("right") && selectedCar != carOptions.size() - 1) {
            selectedCar++;
            changed = true;
            delay = maxDelay;
        }
        
        if (changed) {
            animateCircuits();
            updateArrows();
        }
    }
    
    private void updateArrows() {
        addObject(leftArrow, 380, 400);
        addObject(rightArrow, 620, 400);
    
        if (selectedCar == 0) {
            removeObject(leftArrow);
        } else if (selectedCar == carOptions.size() - 1) {
            removeObject(rightArrow);
        }
    }
    
    protected void nextScreen() {
        // dummy function to be overridden in subclasses
    }
}
