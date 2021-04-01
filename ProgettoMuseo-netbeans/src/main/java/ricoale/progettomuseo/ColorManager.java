/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ricoale.progettomuseo;

import java.awt.Color;
import java.util.HashMap;

/**
 *
 * @author user
 */
public class ColorManager {
    private static ColorManager instance;
            
    private HashMap<String, Color> colors;
    
    public ColorManager(){
        colors = new HashMap<>();
        
        colors.put("border", new Color(211, 215, 225));
        colors.put("txtInactive", new Color(112, 121, 138));
        colors.put("txt", new Color(69, 75, 93));

        colors.put("boxColor", new Color(246, 248, 254));
        colors.put("bgnd", new Color(231, 233, 242));
        
        colors.put("btnHover", new Color(238, 240, 250));
        
        colors.put("color1", new Color(230, 190, 96));
        colors.put("color2", new Color(103, 144, 201));
    }
    
    public static ColorManager getInstance(){
        if(instance == null) instance = new ColorManager();
        return instance;
    }
    
    public Color getColor(String str){
        return colors.get(str);
    }
}
