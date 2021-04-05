/*import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {//poi diventerà il dbcontroller

    static HttpClient client = HttpClient.newHttpClient();
    public static void main(String[] args){
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost/museo/x.php?login=marco")).build();
        HttpRequest request2 = HttpRequest.newBuilder().uri(URI.create("http://localhost/museo/x.php?prova=1")).build();
        HttpRequest request3 = HttpRequest.newBuilder().uri(URI.create("http://localhost/museo/x.php?logout=1")).build();
        
        send(request2);
        send(request2);
        send(request3);
        send(request2);
    }

    
    public static void send(HttpRequest x){
        client.sendAsync(/*gli dico cosa inviarex, /*indico il formato in cui lo voglio (stringa in questo caso)HttpResponse.BodyHandlers.ofString())
        .thenApply(HttpResponse::body)//dopo che ricevo l'http "guardo" il body
        .thenAccept(System.out::println)//e dopo lo printo
        .join();
    }
}*/