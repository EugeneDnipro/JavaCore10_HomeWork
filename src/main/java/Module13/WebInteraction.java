package Module13;

import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Paths;

public class WebInteraction {
    private static final String USERS_URL = "https://jsonplaceholder.typicode.com/users";

    public static void main(String[] args) throws IOException, InterruptedException {
        sendPOST();
        sendGET();
        sendPUT();
        sendDELETE();
    }

//    private static void sendPOST() throws IOException {
//        URL url = new URL(USERS_URL);
//        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//        connection.setRequestMethod("POST");
//        connection.setDoOutput(true);
//        connection.setRequestProperty("Content-Type", "application/json");
//        OutputStream os = connection.getOutputStream();
//        os.write(Files.readAllBytes(new File("src/main/resources/userJSON.json").toPath()));
//        os.flush();
//        os.close();
//
//        int responseCode = connection.getResponseCode();
//        System.out.println("POST response code: " + responseCode);
//        if (responseCode == HttpURLConnection.HTTP_CREATED) {
//            BufferedReader in =
//                    new BufferedReader(
//                            new InputStreamReader(connection.getInputStream()));
//            StringBuffer response = new StringBuffer();
//            String inputLine;
//            while ((inputLine = in.readLine()) != null) {
//                response.append(inputLine);
//            }
//            in.close();
//            System.out.println(response.toString());
//        } else {
//            System.out.println("POST request not worked");
//        }
//    }

    private static void sendGET() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(USERS_URL))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
        System.out.println(response.body());
    }

    private static void sendPOST() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(USERS_URL))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofFile(Paths.get("src/main/resources/existingUserJSON.json")))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
        System.out.println(response.body());
    }

    private static void sendPUT() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(USERS_URL))
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofFile(Paths.get("src/main/resources/existingUserJSON.json")))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
        System.out.println(response.body());
    }

    private static void sendDELETE() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(USERS_URL))
                .DELETE()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
        System.out.println(response.body());
    }
}
