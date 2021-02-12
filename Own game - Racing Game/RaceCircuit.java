import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class RaceCircuit extends World {
    protected GameData gameData;
    protected CircuitData circuitData;
    
    protected Sound buildUpSound;
    
    protected DataOverlay dataOverlay;
    protected StartingLights startingLights;
    
    protected GreenfootImage background;
    protected LoadingSpinner loadingSpinner;
    
    protected CarWithLogic player1;
    protected CarWithLogic player2;
    
    private int lightsStage = 0;
    private final int lightsNextStageDelay = 60; // 60 fps
    private int currentDelay = lightsNextStageDelay;
    
    public CircuitData getCircuitData() { return circuitData; }

    /**
     * Constructor for objects of class RaceCircuit.
     * 
     */
    public RaceCircuit(Sound buildUpSound, GameData gameData) {
        super(1420, 771, 1);
        
        if (gameData.circuitName == null) throw new IllegalStateException("GameData's circuitName field is not set");
        
        this.gameData = gameData;
        this.buildUpSound = buildUpSound;
        this.circuitData = gameData.getCircuitData();
        
        background = new GreenfootImage("circuits/" + gameData.circuitName + ".png");
        background.scale(getWidth(), getHeight());
        
        loadingSpinner = new LoadingSpinner();
        
        setBackground(background);
        startLoading();
        
        setUpCircuit();
    }
    
    public void act() {        
        if (currentDelay == 0) {
            currentDelay = lightsNextStageDelay;
            incrementStage();
        } else if (currentDelay > 0) {
            currentDelay--;
        }
        
        int p1Laps = player1.getCurrentLap();
        int p2Laps = player2.getCurrentLap();
        
        dataOverlay.setLaps(p1Laps, p2Laps);
        dataOverlay.setSectors(player1.getCurrentSector(), player2.getCurrentSector());
        
        if (p1Laps == gameData.totalLaps) {
            endGame(1);
        } else if (p2Laps == gameData.totalLaps) {
            endGame(2);
        }
    }
    
    protected void setUpCircuit() {
        dataOverlay = new DataOverlay(gameData.totalLaps);
        addObject(dataOverlay, circuitData.overlayPos.x, circuitData.overlayPos.y);
        
        player1 = new CarWithLogic(gameData.player1car, 1);
        player2 = new CarWithLogic(gameData.player2car, 2);
        
        player1.setRot(circuitData.startingRotation);
        player2.setRot(circuitData.startingRotation);
        
        addObject(player1, circuitData.player1Start.x, circuitData.player1Start.y);
        addObject(player2, circuitData.player2Start.x, circuitData.player2Start.y);
        
        stopLoading();

        buildUpSound.stopSound();
        
        startingLights = new StartingLights();
        addObject(startingLights, circuitData.lightsPos.x, circuitData.lightsPos.y);
    }
    
    protected void incrementStage() {
        if (lightsStage == 7) {
            // we need to hide the lights now
            currentDelay = -1;
            removeObject(startingLights);
        }
        
        lightsStage++;
        startingLights.setStage(lightsStage);
        
        if (lightsStage == 6) {
            currentDelay = Greenfoot.getRandomNumber(lightsNextStageDelay * 4) + lightsNextStageDelay;
        } else if (lightsStage == 7) {
            currentDelay = lightsNextStageDelay * 3;
            
            startingLights.setStage(lightsStage);
            
            player1.enableMovement();
            player2.enableMovement();
        }
    }
    
    protected void startLoading() {
        addObject(loadingSpinner, getWidth() / 2, getHeight() / 2);
        
        GreenfootImage newBg = new GreenfootImage(getBackground());
        newBg.setColor(new Color(0, 0, 0, 128));
        newBg.fill();
        
        setBackground(newBg);
    }
    
    protected void stopLoading() {
        removeObject(loadingSpinner);
        setBackground(background);
    }
    
    protected void endGame(int winningPlayer) {
        player1.disableMovement();
        player2.disableMovement();
        
        GreenfootImage newBg = new GreenfootImage(getBackground());
        newBg.setColor(new Color(0, 0, 0, 128));
        newBg.fill();
        
        setBackground(newBg);
        
        addObject(new TextBox("Player " + winningPlayer + " won the race!", 240, 26), 710, 385);
        
        Greenfoot.stop();
    }
}
