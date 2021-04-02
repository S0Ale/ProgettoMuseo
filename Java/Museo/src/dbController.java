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
    private static CompletableFuture<Void> thenAccept;

    public dbController(){
        this.client= HttpClient.newHttpClient();
        this.idSessione = null;
    }
    public static void main(String[] args) throws InterruptedException, ExecutionException{
        dbController x = new dbController();
        //String stringaFurtura = x.sendRequest(x.creaHttpRequest("http://localhost/museo/x.php?login=marco")).get();
        //String stringaFurtura1 = x.sendRequest(x.creaHttpRequest("http://localhost/museo/x.php?prova=1")).get();
        //String stringaFurtura2 = x.sendRequest(x.creaHttpRequest("http://localhost/museo/x.php?login=marco")).get();
        x.stabilisciIdSessione("2", "paolo");
        System.out.println(x.idSessione);
        x.logout();
        System.out.println(x.idSessione);
    }

    public CompletableFuture<String> richiedi(){
        return null;
    }

    public boolean stabilisciIdSessione(String id, String psw){//imposta idSessione
        try{
            CompletableFuture<String> login = this.login(id, psw);

            if(login.get().trim().length() == 0) return false;
            this.idSessione= login.get().trim();
            //System.out.println("id della sessione: "+idSessione);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public void logout(){//metodo che esegue l'autenticazione, restituisce l'id sessione associato (oppure null se le credenziali non combaciano)
        this.sendRequest(this.creaHttpRequest(urlSito+ "?logout=1&s="+idSessione));
        this.idSessione= null;
    }

    private CompletableFuture<String> login(String id, String psw) throws ExecutionException{//metodo che esegue l'autenticazione, restituisce l'id sessione associato (oppure null se le credenziali non combaciano)
        return this.sendRequest(this.creaHttpRequest(urlSito+"?id="+id+"&psw="+psw));
    }

    public HttpRequest creaHttpRequest(String url){
        return HttpRequest.newBuilder().uri(URI.create(url)).build();
    }

    public CompletableFuture<String> sendRequest(HttpRequest daInviare){
        return client.sendAsync(/*gli dico cosa inviare*/daInviare, /*indico il formato in cui lo voglio (stringa in questo caso)*/HttpResponse.BodyHandlers.ofString()).thenApply(HttpResponse::body);//dopo che ricevo l'http "guardo" il body
    }
}
