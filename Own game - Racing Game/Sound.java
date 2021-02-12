import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sound here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sound  
{
    private GreenfootSound music;

    /**
     * Constructor for objects of class Sound
     * 
     * @param {String} path - Path to the sound (e.g. "theme.mp3")
     */
    public Sound(String path)
    {
        music = new GreenfootSound(path);  
        music.setVolume(100);  
    }

    /**
     * Constructor for objects of class Sound
     * 
     * @param {String} path - Path to the sound (e.g. "theme.mp3")
     * @param {int} volume - volume of the audio (0-100)
     */
    public Sound(String path, int volume)
    {
        if (volume < 0 || volume > 100) {
            throw new java.lang.IllegalArgumentException("Volume must be between 0 and 100 inclusive.");
        }
        
        music = new GreenfootSound(path);  
        music.setVolume(volume);  
    }
    
    public void playSound() {
        music.play();
    }
    
    public void playSound(boolean loop) {
        if (loop){
            music.playLoop();
        } else {
            music.play();
        }
    }
    
    public boolean isPlaying() {
        return music.isPlaying();
    }
    
    public void pauseSound() {
        music.pause();
    }
    
    public void stopSound() {
        music.stop();
    }
    
    public int getVolume() {
        return music.getVolume();
    }
    
    public void setVolume(int volume) {
        music.setVolume(volume);
    }
}
