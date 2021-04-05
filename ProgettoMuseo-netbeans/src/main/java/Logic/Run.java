/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import javax.swing.JSlider;

/**
 *
 * @author andre
 */
public class Run implements Runnable{
    
    private static SoundPlayer player;
    private JSlider slider;
    
    public Run(SoundPlayer player, JSlider slider){
        this.player = player;
        this.slider = slider;
        System.out.println("Run creato");
    }
    
    @Override
    public synchronized void run(){
        long durata = player.getClip().getMicrosecondLength();
        int maxV = slider.getMaximum();
        //System.out.println("run() richiamata");
        while(true){
            System.out.println(player.isActive());
            if(player.isActive()){
                
                System.out.println(player.getClip().getMicrosecondPosition());
                //this.player.setTime(player.getClip().getFramePosition());
                long secondaggio = player.getClip().getMicrosecondPosition();
        
                long r = secondaggio * maxV / durata;
                slider.setValue((int)r);
            }
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }
    
}
