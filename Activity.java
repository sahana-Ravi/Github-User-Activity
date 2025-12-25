
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;   

public class Activity{
    public static void main(String[] args) {
        System.out.println("Hello, Enter your github username:");
        Scanner scanner = new Scanner(System.in);  
        String username = scanner.nextLine();
        System.out.println("Your github username is: " + username);
        scanner.close();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create("https://api.github.com/users/"+username+"/events"))
        .header("User-Agent", "Java-HttpClient")
        .header("Accept", "application/json")
        .build();
        try{
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
    
        System.out.println("Status Code: " + response.statusCode());
        System.out.println("Body: " + response.body()); 
        }
        catch(Exception e){
            System.out.println("An error occurred while making the HTTP request.");
        } // 👈 direct access to response body


    }
}