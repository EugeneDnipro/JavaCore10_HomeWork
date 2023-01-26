package Module13;

import java.net.http.HttpResponse;

import static Module13.WebInteraction.methodName;

public class OutputUtils {
    public static void printResponseCodeAndBody(HttpResponse<String> response) {
        System.out.println(methodName + " response code: " + response.statusCode());
        System.out.println(response.body());
        System.out.println("=========================================");
    }

    public static void printResponseCode(HttpResponse<String> response) {
        System.out.println(methodName + " response code: " + response.statusCode());
        System.out.println("=========================================");
    }
}
