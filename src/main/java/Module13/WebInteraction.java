package Module13;

import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Paths;

public class WebInteraction {
    private static final String USERS_URL = "https://jsonplaceholder.typicode.com/users";
    private static final String USER1_URL = "https://jsonplaceholder.typicode.com/users/1";

    static void sendPOST() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(USERS_URL))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofFile(Paths.get("src/main/resources/existingUserJSON.json")))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("POST response code: " + response.statusCode());
        System.out.println(response.body());
        System.out.println("=========================================");
    }

    static void sendPUT() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(USER1_URL))
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofFile(Paths.get("src/main/resources/existingUserJSON.json")))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("PUT response code: " + response.statusCode());
        System.out.println(response.body());
        System.out.println("=========================================");
    }

    static void sendDELETE() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(USER1_URL))
                .DELETE()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("DELETE response code: " + response.statusCode());
        System.out.println("=========================================");
    }

    static void sendGET() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(USERS_URL))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("GET response code: " + response.statusCode());
        System.out.println(response.body());
        System.out.println("=========================================");
    }

    static void sendGETbyID(String id) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(USERS_URL + "?id=" + id))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("GETbyID response code: " + response.statusCode());
        System.out.println("id = " + id);
        System.out.println(response.body());
        System.out.println("=========================================");
    }

    static void sendGETbyUserName(String name) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(USERS_URL + "?username=" + name))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("GETbyUserName response code: " + response.statusCode());
        System.out.println("name = " + name);
        System.out.println(response.body());
        System.out.println("=========================================");
    }
}
