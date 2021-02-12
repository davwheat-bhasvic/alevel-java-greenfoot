import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Player2CarSelect extends CarSelect {
    public Player2CarSelect(Sound buildUpSound, GameData gameData) {
        super(2, buildUpSound, gameData);
    }
    
    @Override
    protected void nextScreen() {
        Greenfoot.setWorld(new RaceCircuit(buildUpSound, gameData));
    }
}
