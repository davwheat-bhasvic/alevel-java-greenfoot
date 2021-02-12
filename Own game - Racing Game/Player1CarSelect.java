import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Player1CarSelect extends CarSelect {
    public Player1CarSelect(Sound buildUpSound, GameData gameData) {
        super(1, buildUpSound, gameData);
    }
    
    @Override
    protected void nextScreen() {
        Greenfoot.setWorld(new Player2CarSelect(buildUpSound, gameData));
    }
}
