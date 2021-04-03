import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class dbController {//poi diventerà il dbcontroller
    static String urlSito = "http://localhost/museo/x.php";
    HttpClient client;
    String idSessione;

    public dbController(){
        this.client= HttpClient.newHttpClient();
        this.idSessione = null;
    }
    public static void main(String[] args) throws InterruptedException, ExecutionException{
        dbController x = new dbController();
        x.login("2", "paolo");
        CompletableFuture<String> s=x.richiedi("dipendente.nome,dipendente.cognome,sala.periodo", "dipendente,sala", "dipendente.idSala=sala.id%20and%20sala.id=3", "ORDER%20BY%20dipendente.cognome");
        System.out.println(s.get());
        //System.out.println(s.get());
    }

    public CompletableFuture<String> richiedi(String campi, String tabelle, String predicato, String altro){
        if(this.idSessione == null)
            return null;
        String s = urlSito+"?pull=1&s="+this.idSessione+"&campi="+campi+"&tabelle="+tabelle+"&predicato="+predicato+"&altro="+altro;
        //System.out.println("URL CAZZOZOZOAOSOOA = " + s);
        return this.sendRequest(this.creaHttpRequest(s));
    }

    public boolean login(String id, String psw){//imposta idSessione
        try{
            CompletableFuture<String> login = this.loginSupporter(id, psw);

            if(login.get().trim().length() == 0) return false;
            this.idSessione= login.get().trim();
            //System.out.println("id della sessione: "+idSessione);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public boolean logout(){//metodo che esegue l'autenticazione, restituisce l'id sessione associato (oppure null se le credenziali non combaciano)
        try{
            CompletableFuture<String> x = this.sendRequest(this.creaHttpRequest(urlSito+ "?logout=1&s="+this.idSessione));
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
        return this.sendRequest(this.creaHttpRequest(urlSito+"?id="+id+"&psw="+psw));
    }

    public HttpRequest creaHttpRequest(String url){
        //metodo che permette di creare un HttpRequest usando l'url come parametro
        return HttpRequest.newBuilder().uri(URI.create(url)).build();
    }

    public CompletableFuture<String> sendRequest(HttpRequest daInviare){
        //medoto che invia l'httpRequest indicato
        return client.sendAsync(/*gli dico cosa inviare*/daInviare, /*indico il formato in cui lo voglio (stringa in questo caso)*/HttpResponse.BodyHandlers.ofString()).thenApply(HttpResponse::body);//dopo che ricevo l'http "guardo" il body
    }
}
