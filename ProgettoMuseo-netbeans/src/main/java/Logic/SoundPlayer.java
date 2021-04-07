/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

/**
 *
 * @author andre
 */
public class SoundPlayer {
    private boolean isStarted;
    private long lastPos;
    private Clip clip;
    private boolean isActive;
    private File musicPath;
    private AudioInputStream audioInput;
    
    public SoundPlayer(String path) throws MalformedURLException, URISyntaxException{
        musicPath =  new File(/*getClass().getResource(*/path/*).toURI()*/);
        lastPos = 0;
        clip = null;
        isActive = false;
        isStarted = false;
    }
    
    public boolean isStarted(){
        return isStarted;
    }
    
    public boolean isActive(){
        return isActive;
    }
    
    public Clip getClip(){
        return clip;
    }
    
    public File getMusicPath(){
        return musicPath;
    }
    
    public long getLastPos(){
        return lastPos;
    }
    
    public void setLastPos(long time){
        this.lastPos = time;
        this.clip.setMicrosecondPosition(time);
    }
    
    public void playMusic(){
        try{
            if(this.musicPath.exists()){
                audioInput = AudioSystem.getAudioInputStream(musicPath);
                this.clip = (Clip) AudioSystem.getClip();
                this.clip.open(audioInput);
                this.clip.start();
                System.out.println(this.clip.getLevel());
                isStarted = true;
                isActive = true;
            }
            else{
                System.out.print("url sbagliato");
            }
        }catch(Exception e){
            System.out.print("Errore nel caricamento");
            e.printStackTrace();
        }
    }
    
    public void resume(){
        isActive = true;
        this.clip.setMicrosecondPosition(lastPos);
        this.clip.start();
    }
    
    public void pause(){
        if(this.clip == null) System.out.println("clip null");
        this.setLastPos(this.clip.getMicrosecondPosition());
        this.clip.stop();
        isActive = false;   
    }
    
    public void stop(){
        if(isStarted){
            try {
                audioInput.close();
            } catch (IOException ex) {
                Logger.getLogger(SoundPlayer.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.clip.stop();
            this.clip.close();
            clip = null;
            this.isStarted = false;
            isActive = false;
        }
    }

}
