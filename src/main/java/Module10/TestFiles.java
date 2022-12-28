package Module10;

public class TestFiles {
    public static void main(String[] args) {
        WorkWithFiles.phoneFileValidate();
        System.out.println("==================");

        WorkWithFiles.wordCounter();
        System.out.println("==================");

        UserToJson item = new UserToJson();
        item.fileToUser();
    }

}
