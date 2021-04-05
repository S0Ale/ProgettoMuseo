/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.io.File;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

/**
 *
 * @author andre
 */
public class SoundPlayer {
    private boolean isStarted;
    private long lastPos;//indica il punto in cui è arrivato
    private static Clip clip;
    private boolean isActive;
    private File musicPath;//percorso file da riprodurre
    
    public SoundPlayer(String path){
        //System.out.println("FILE---C:\\Users\\andre\\Desktop\\ProgettoMuseo\\ProgettoMuseo-netbeans\\src\\main\\resources /n---> " + path);
        musicPath =  new File(path);
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
        System.out.println("time : "+time + " frametime = "+ this.clip.getMicrosecondPosition());
    }
    
    public void playMusic(){
        try{
            if(this.musicPath.exists()){
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
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
        System.out.println("Resumed");
        this.clip.setMicrosecondPosition(lastPos);
        this.clip.start();
    }
    
    public void pause(){
        System.out.println("Paused");
        this.setLastPos(this.clip.getMicrosecondPosition());
        this.clip.stop();
        isActive = false;
        
    }
    
    public void stop(){
        System.out.println("Stopped");
        this.clip.close();
        this.clip.stop();
        this.isStarted = false;
        isActive = false;
    }

}
