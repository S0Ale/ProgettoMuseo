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
        
        colors.put("border", new Color(131, 142, 159));
        colors.put("txt", new Color(119, 152, 199));

        colors.put("btnTxt1", new Color(199, 213, 229));
        colors.put("btnTxt2", new Color(236, 192, 192));
        
        colors.put("btn", new Color(86, 96, 112));
        colors.put("btn2", new Color(205, 107, 107));
        
        colors.put("color1", new Color(90, 128, 182));
        colors.put("color2", new Color(199, 73, 73));
    }
    
    public static ColorManager getInstance(){
        if(instance == null) instance = new ColorManager();
        return instance;
    }
    
    public Color getColor(String str){
        return colors.get(str);
    }
}
