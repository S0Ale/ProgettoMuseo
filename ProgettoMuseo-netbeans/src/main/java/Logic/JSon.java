/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

/**
 *
 * @author andre
 */
public class JSon {
    public static int nTuple(String json){
        int t = 0;
        for(int i = 0; i < json.length(); i++){
            if(json.charAt(i) == '}')
                t++;
        }
        return t;
    }

    public static String[] splitJSON(String json){
        String[] s = null;
        s = json.split("~");
        return s;
    }
    
    public static String richiediJson(String json, String par){
        String r = "";
        try{
            JsonElement elJson = new JsonParser().parse(json);
            r = elJson.getAsJsonObject().get(par).getAsString();
        }catch(Exception e){
            if(par == "id")
                r = "-1";
            else
                r = par+" non disponibile";
        }
        
        return r;
    }
}
