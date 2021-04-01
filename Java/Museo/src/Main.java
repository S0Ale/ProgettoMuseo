import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {//poi diventerà il dbcontroller
    public static void main(String[] args){
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost/museo/x.php?prova=1")).build();
        client.sendAsync(/*gli dico cosa inviare*/request, /*indico il formato in cui lo voglio (stringa in questo caso)*/HttpResponse.BodyHandlers.ofString())
            .thenApply(HttpResponse::body)//dopo che ricevo l'http "guardo" il body
            .thenAccept(System.out::println)//e dopo lo printo
            .join();
    }
}