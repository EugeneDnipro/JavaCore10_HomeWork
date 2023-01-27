package Module13;

import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class WebInteraction {
    private static final String USERS_URL = "https://jsonplaceholder.typicode.com/users";
    private static final String RESPONSE_FILE = ".\\src\\main\\resources\\response.json";
    static String methodName;

    static HttpResponse<String> sendPOST() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(USERS_URL))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofFile(Paths.get("src/main/resources/existingUserJSON.json")))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        methodName = new Object() {
        }.getClass().getEnclosingMethod().getName();
        return response;
    }

    static HttpResponse<String> sendPUT(int userID) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(USERS_URL + "/" + userID))
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofFile(Paths.get("src/main/resources/existingUserJSON.json")))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        methodName = new Object() {
        }.getClass().getEnclosingMethod().getName();
        return response;
    }

    static HttpResponse<String> sendDELETE(int userID) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(USERS_URL + "/" + userID))
                .DELETE()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        methodName = new Object() {
        }.getClass().getEnclosingMethod().getName();
        return response;
    }

    static HttpResponse<String> sendGET() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(USERS_URL))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        methodName = new Object() {
        }.getClass().getEnclosingMethod().getName();
        return response;
    }

    static HttpResponse<String> sendGETbyID(String id) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(USERS_URL + "?id=" + id))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        methodName = new Object() {
        }.getClass().getEnclosingMethod().getName();
        return response;
    }

    static HttpResponse<String> sendGETbyUserName(String name) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(USERS_URL + "?username=" + name))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        methodName = new Object() {
        }.getClass().getEnclosingMethod().getName();
        return response;
    }

    static void commentsToLastPostOfUser(String id) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(USERS_URL + "/" + id + "/posts"))
                .GET()
                .build();

        client.send(request, HttpResponse.BodyHandlers.ofFile(Path.of(RESPONSE_FILE)));

        int postNumber = maxPostFinder();
        request = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/posts/" + postNumber + "/comments"))
                .GET()
                .build();

        client.send(request, HttpResponse.BodyHandlers.ofFile(Path.of(".\\src\\main\\resources\\user-" + id + "-post-" + postNumber + "-comments.json")));
    }

    static int maxPostFinder() {
        int count = 0;
        try (InputStream fis = new FileInputStream(RESPONSE_FILE);
             Scanner scanner = new Scanner(fis)) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                if (line.contains("\"id\"")) {
                    String temp = line.strip().replace(",", "");
                    String[] splitedTemp = temp.split(" ");
                    count = Integer.parseInt(splitedTemp[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }
}
