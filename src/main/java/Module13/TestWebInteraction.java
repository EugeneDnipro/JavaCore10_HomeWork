package Module13;

import java.io.IOException;

public class TestWebInteraction {
    public static void main(String[] args) throws IOException, InterruptedException {
        OutputUtils.printResponseCodeAndBody(WebInteraction.sendPOST());
        OutputUtils.printResponseCodeAndBody(WebInteraction.sendPUT(1));
        OutputUtils.printResponseCode(WebInteraction.sendDELETE(5));
        OutputUtils.printResponseCodeAndBody(WebInteraction.sendGET());
        OutputUtils.printResponseCodeAndBody(WebInteraction.sendGETbyID("2"));
        OutputUtils.printResponseCodeAndBody(WebInteraction.sendGETbyUserName("Samantha"));
    }
}
