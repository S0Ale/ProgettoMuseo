package Logic;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class DbController {//poi diventerà il dbcontroller
    public static String urlSito = "http://localhost/museo";
    private HttpClient client;
    private String idSessione;

    public DbController(){
        this.client= HttpClient.newHttpClient();
        this.idSessione = null;
    }

    public static boolean download(String file_url, String file_name){
        try (BufferedInputStream in = new BufferedInputStream(new URL(file_url).openStream());
            FileOutputStream fileOutputStream = new FileOutputStream(file_name)) {
            byte dataBuffer[] = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
        } catch (IOException e) {
            return false;
        }
        
        try {
            InputStream in = new URL(file_url).openStream();
            Files.copy(in, Paths.get(file_name), StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (IOException e) {
            return false;
        }
        
    }

    public CompletableFuture<String> richiedi(String campi, String tabelle, String predicato, String altro){
        if(this.idSessione == null)
            return null;
        String s = urlSito+"/x.php?pull=1&s="+this.idSessione+"&campi="+campi+"&tabelle="+tabelle+"&predicato="+predicato+"&altro="+altro;
        s = DbController.levaSpazi(s);
        return this.sendRequest(this.creaHttpRequest(s));
    }

    public boolean login(String id, String psw){//imposta idSessione
        try{
            CompletableFuture<String> login = this.loginSupporter(id, psw);

            if(login.get().trim().length() == 0) return false;
            this.idSessione= login.get().trim();
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public boolean logout(){//metodo che esegue l'autenticazione, restituisce l'id sessione associato (oppure null se le credenziali non combaciano)
        try{
            CompletableFuture<String> x = this.sendRequest(this.creaHttpRequest(urlSito+ "/x.php?logout=1&s="+this.idSessione));
            String risultato = x.get().trim();
            if(risultato.equalsIgnoreCase("sessione non trovata")){// il server http nel caso non trovi la sessione restituisce "sessione non trovata"
                return false;
            }
            this.idSessione= null;
            return true;
        }catch(Exception e){
            return false;
        }
    }

    private CompletableFuture<String> loginSupporter(String id, String psw) throws ExecutionException{
        //metodo che esegue l'autenticazione, restituisce l'id sessione associato (oppure null se le credenziali non combaciano)
        //da utilizzare solo all'interno del metodo login
        return this.sendRequest(this.creaHttpRequest(urlSito+"/x.php?id="+id+"&psw="+psw));
    }
    
    private static String levaSpazi(String s){
        return s = s.replace(" ", "%20");
    }
    public HttpRequest creaHttpRequest(String url){
        //metodo che permette di creare un HttpRequest usando l'url come parametro
        return HttpRequest.newBuilder().uri(URI.create(url)).build();
    }

    public CompletableFuture<String> sendRequest(HttpRequest daInviare){
        //medoto che invia l'httpRequest indicato
        return client.sendAsync(/*gli dico cosa inviare*/daInviare, /*indico il formato in cui lo voglio (stringa in questo caso)*/HttpResponse.BodyHandlers.ofString()).thenApply(HttpResponse::body);//dopo che ricevo l'http "guardo" il body
    }

    public HttpClient getClient() {
        return this.client;
    }

    public void setClient(HttpClient client) {
        this.client = client;
    }

    public String getIdSessione() {
        return this.idSessione;
    }

    public void setIdSessione(String idSessione) {
        this.idSessione = idSessione;
    }

}
