package Module13;

import java.io.IOException;

public class TestWebInteraction {
    public static void main(String[] args) throws IOException, InterruptedException {
        WebInteraction.sendPOST();
        WebInteraction.sendPUT();
        WebInteraction.sendDELETE();
        WebInteraction.sendGET();
        WebInteraction.sendGETbyID("2");
        WebInteraction.sendGETbyUserName("Samantha");
    }
}
