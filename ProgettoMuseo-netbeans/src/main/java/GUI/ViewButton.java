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
                        JsonElement sJson = new JsonParser().parse(ricercatori[i]);
                        String t = ", ";
                        if(i == ricercatori.length - 1) t = "."; 
                        stringaRicercatori += sJson.getAsJsonObject().get("nome").getAsString() +" "+sJson.getAsJsonObject().get("cognome").getAsString()+t;
                        //
                    }
                    System.out.println(stringaRicercatori);
                    //String[] categorie = null;
                    String categorieJson = null;
                    String[] specie = null;
                    try {
                        categorieJson = window.getController().richiedi(
                                "reperto.ID,categoria.ID,categoria.livello,categoria.nomeCategoria,categoria.valore,probabilita",
                                "categoria,reperto,repertohacategorie",
                                "reperto.id="+idReperto+"%20and%20repertohacategorie.IDReperto=reperto.ID%20and%20categoria.ID=repertohacategorie.IDCategoria",
                                "ORDER%20by%20probabilita").get();
                        specie = JSon.splitJSON(categorieJson);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ViewButton.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ExecutionException ex) {
                        Logger.getLogger(ViewButton.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    for(int i = 0; i < specie.length; i++){
                        JsonElement sJson = new JsonParser().parse(specie[i]);
                        String s = sJson.getAsJsonObject().get("nomeCategoria").getAsString() +" : "+sJson.getAsJsonObject().get("valore").getAsString()+" Probabilità stimata: "+sJson.getAsJsonObject().get("probabilita").getAsString();
                        //System.out.println("STRINGA= "+s);
                        specie[i] = new String(s);
                    }
                    
                    String sJson = null;
                    try {
                        sJson = window.getController().richiedi(
                                "reperto.descrizione,data,continente,stato,mesh.percorsom,audio.percorso",
                                "reperto,ritrovamento,luogo,mesh,audio",
                                "reperto.id="+idReperto+"%20and%20idRitrovamento=ritrovamento.ID%20and%20ritrovamento.idLuogo=luogo.ID%20and%20IDMesh=mesh.ID%20and%20IDAudio=audio.ID",
                                "").get();
                        sJson = sJson.replace("~", "");
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ViewButton.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ExecutionException ex) {
                        Logger.getLogger(ViewButton.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    //System.out.println(sJson);
                    JsonElement elJson = new JsonParser().parse(sJson);
                    
                    String descrizione = elJson.getAsJsonObject().get("descrizione").getAsString(),
                            data = elJson.getAsJsonObject().get("data").getAsString(),
                            stato = elJson.getAsJsonObject().get("stato").getAsString(),
                            continente= elJson.getAsJsonObject().get("continente").getAsString(),
                            mesh= DbController.urlSito + elJson.getAsJsonObject().get("percorsom").getAsString(),
                            audio= DbController.urlSito + elJson.getAsJsonObject().get("percorso").getAsString();
                    
                    System.out.println("Mesh "+mesh);
                    System.out.println("Audio "+audio);
                    String d = "/src/main/resources/download";
                    
                    File dirMuseo = new File(FileSystemView.getFileSystemView().getDefaultDirectory().getPath()+"\\museo");
                    String path = dirMuseo.getPath();
                    if (!dirMuseo.exists()){
                        //System.out.println("creo la directory "+ path);
                        dirMuseo.mkdirs();
                    }
                    
                    File f = new File(path+"\\"+String.valueOf(idReperto)+".obj");
                    if(!f.exists()) {
                        //System.out.println("S mesh");
                        if(!DbController.download(mesh, path+"\\"+String.valueOf(idReperto)+".obj"))
                            System.out.println("Errore nel download della mesh");
                    }
                    f = null;
                    f= new File(path + "\\"+String.valueOf(idReperto)+".wav");
                    if(!f.exists()) {
                        //System.out.println("S audio");
                        if(!DbController.download(audio, path + "\\"+String.valueOf(idReperto)+".wav"))
                            System.out.println("Errore nel download della traccia audio");
                    }
                    /*DbController.download(mesh, String.valueOf(idReperto)+".obj");
                    DbController.download(audio, String.valueOf(idReperto)+".wav");*/
                    
                    //System.out.println(d+"\\"+String.valueOf(idReperto)+".obj");
                    window.updateViewPanel(descrizione, data, stato, continente, specie, stringaRicercatori, path + "\\" +String.valueOf(idReperto)+".obj", path + "\\" +String.valueOf(idReperto)+".wav");
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
