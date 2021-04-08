/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Logic.DbController;
import Logic.JSon;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author user
 * Questa classe è una versione custom di un normale JButton per comporre la lista di reperti
 * se premuto, questo bottone deve portare alla visualizzazione del reperto.
 */
public class ViewButton extends JButton{
    
    private int idReperto;
    
    public ViewButton(AppWindow window, int x, int y, int idReperto){
        init(window);
        setLocation(x, y);
        this.idReperto = idReperto; 
    }
    
    private String[] ottieniFoto(String json){
        String[] foto = JSon.splitJSON(json);
        int i = 0;
        for(String fotografia : foto){
                        String t = ", ";
                        if(i == foto.length - 1) t = "."; 
                        foto[i++] = DbController.urlSito + JSon.richiediJson(fotografia, "percorso");
        }
        
        return foto;
    }
    
    private void init(AppWindow window){
        setPreferredSize(new Dimension(85, 22));
        setSize(new Dimension(85, 22));
        setText("View");
        setBackground(ColorManager.getInstance().getColor("boxColor"));
        setForeground(ColorManager.getInstance().getColor("txtInactive"));
        setBorder(new LineBorder(ColorManager.getInstance().getColor("border")));
        setActionCommand("viewItem");
        setRolloverEnabled(false);
        
        //azioni al click
        addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(e.getActionCommand().equals("viewItem")){
                    //richiesta al db dei dati del reperto selezionato
                    String ricercatoriJson = null;
                    String[] ricercatori = null;
                    String stringaRicercatori = "";
                    try {
                        ricercatoriJson = window.getController().richiedi(
                                "ritrovamento.ID,ricercatore.nome,ricercatore.cognome",
                                "ricercatore,ritrovamento,ricercatoreritrovamenti,reperto",
                                "reperto.ID="+idReperto+"%20and%20reperto.IDRitrovamento=ritrovamento.ID%20and%20ricercatoreritrovamenti.IDRicercatore=ricercatore.ID",
                                "").get();
                        ricercatori = JSon.splitJSON(ricercatoriJson);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ViewButton.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ExecutionException ex) {
                        Logger.getLogger(ViewButton.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    for(int i = 0; i < ricercatori.length; i++){
                        if(ricercatori[i] != "" && ricercatori[i] != null){
                            String t = ", ";
                            if(i == ricercatori.length - 1) t = "."; 
                            stringaRicercatori += JSon.richiediJson(ricercatori[i], "nome") +" "+JSon.richiediJson(ricercatori[i], "cognome")+t;
                        }
                    }
                    String categorieJson = null;
                    String[] specie = null;
                    try {
                        categorieJson = window.getController().richiedi(
                                "reperto.ID,categoria.ID,categoria.livello,categoria.nomeCategoria,categoria.valore,probabilita",
                                "categoria,reperto,repertohacategorie",
                                "reperto.id="+idReperto+"%20and%20repertohacategorie.IDReperto=reperto.ID%20and%20categoria.ID=repertohacategorie.IDCategoria",
                                "ORDER%20by%20probabilita%20DESC").get();
                        specie = JSon.splitJSON(categorieJson);
                        
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ViewButton.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ExecutionException ex) {
                        Logger.getLogger(ViewButton.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    String[] foto = null;
                    try {
                        foto = ottieniFoto(window.getController().richiedi(
                                "foto.percorso",
                                "foto,reperto,fotoreperto",
                                "reperto.ID="+idReperto+"%20and%20fotoreperto.IDReperto=reperto.ID%20and%20fotoreperto.idfoto=foto.id",
                                "").get());
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ViewButton.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ExecutionException ex) {
                        Logger.getLogger(ViewButton.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    for(int i = 0; i < specie.length; i++){
                        String s = JSon.richiediJson(specie[i], "nomeCategoria") +" : "+ JSon.richiediJson(specie[i], "valore")+" Probabilità stimata: "+JSon.richiediJson(specie[i], "probabilita")+"%";
                        specie[i] = new String(s);
                    }
                    
                    String sJsonDesc = null, sJsonRitr  = null, sJsonMesh  = null, sJsonAudio  = null;
                    try {
                        sJsonDesc = window.getController().richiedi(
                                "reperto.nome,reperto.descrizione",
                                "reperto",
                                "reperto.id="+idReperto,
                                "").get();
                        sJsonRitr = window.getController().richiedi(
                                "data,continente,stato",
                                "reperto,ritrovamento,luogo",
                                "reperto.id="+idReperto+"%20and%20idRitrovamento=ritrovamento.ID%20and%20ritrovamento.idLuogo=luogo.ID%20",
                                "").get();
                        sJsonMesh = window.getController().richiedi(
                                "mesh.percorsom",
                                "reperto,mesh",
                                "reperto.id="+idReperto+"%20and%20IDMesh=mesh.ID",
                                "").get();
                        sJsonAudio = window.getController().richiedi(
                                "audio.percorso",
                                "reperto,audio",
                                "reperto.id="+idReperto+"%20and%20IDAudio=audio.ID",
                                "").get();
                        sJsonDesc = sJsonDesc.replace("~", "");
                        sJsonRitr = sJsonRitr.replace("~", "");
                        sJsonMesh = sJsonMesh.replace("~", "");
                        sJsonAudio = sJsonAudio.replace("~", "");
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ViewButton.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ExecutionException ex) {
                        Logger.getLogger(ViewButton.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    String
                        path = "",
                        nomeReperto = JSon.richiediJson(sJsonDesc, "nome"),
                        descrizione = JSon.richiediJson(sJsonDesc, "descrizione"),
                        data = JSon.richiediJson(sJsonRitr, "data"),
                        stato = JSon.richiediJson(sJsonRitr, "stato"),
                        continente= JSon.richiediJson(sJsonRitr, "continente"),
                        mesh= DbController.urlSito + JSon.richiediJson(sJsonMesh, "percorsom"),
                        audio= DbController.urlSito + JSon.richiediJson(sJsonAudio, "percorso");


                        File dirMuseo = new File(FileSystemView.getFileSystemView().getDefaultDirectory().getPath()+"\\museo");
                        path = dirMuseo.getPath();
                        if (!dirMuseo.exists()){
                            dirMuseo.mkdirs();
                        }

                        File f = new File(path+"\\"+String.valueOf(idReperto)+".obj");//download mesh
                        if(!f.exists()) {
                            if(!DbController.download(mesh, path+"\\"+String.valueOf(idReperto)+".obj"))
                                System.out.println("Errore nel download della mesh");
                        }

                        f= new File(path + "\\"+String.valueOf(idReperto)+".wav");//download audio
                        if(!f.exists()) {
                            if(!DbController.download(audio, path + "\\"+String.valueOf(idReperto)+".wav"))
                                System.out.println("Errore nel download della traccia audio");
                        }

                        for(int i = 0; i < foto.length; i++){//download foto
                            try{
                                f= new File(path + "\\"+String.valueOf(idReperto)+foto[i].substring(foto[i].lastIndexOf(".")));
                            }catch(Exception ex){
                                f = new File("");
                                break;
                            }
                            
                            if(!f.exists()) {
                                if(!DbController.download(foto[i], path + "\\"+String.valueOf(idReperto)+"_"+ String.valueOf(i) +foto[i].substring(foto[i].lastIndexOf("."))))
                                    System.out.println("Errore nel download di una foto");
                                foto[i] = path + "\\" + String.valueOf(idReperto) + "_" + String.valueOf(i) + foto[i].substring(foto[i].lastIndexOf("."));
                            }
                        
                    }
                        /*DbController.download(mesh, String.valueOf(idReperto)+".obj");
                        DbController.download(audio, String.valueOf(idReperto)+".wav");*/

                    window.updateViewPanel(nomeReperto, descrizione, data, stato, continente, specie, stringaRicercatori, foto, path + "\\" +String.valueOf(idReperto)+".obj", path + "\\" +String.valueOf(idReperto)+".wav");
                    window.showViewPanel();
                }
            }
        });
        
        //listener per gli effetti di hover
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                setBackground(ColorManager.getInstance().getColor("btnHover"));
                setForeground(ColorManager.getInstance().getColor("txt"));
                setBorder(new LineBorder(ColorManager.getInstance().getColor("color1")));
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                setBackground(ColorManager.getInstance().getColor("boxColor"));
                setForeground(ColorManager.getInstance().getColor("txtInactive"));
                setBorder(new LineBorder(ColorManager.getInstance().getColor("border")));
            }
        });
    }
}
