package Module10;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class UserToJson {

    class User {
        private String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }


    public void fileToUser() {
        String path = ".\\src\\main\\resources\\fileUsers.txt";
        char[] buf = WorkWithFiles.dataFromFileReader(path);
        if (buf == null) {
            return;
        }

        ArrayList<String> words = WorkWithFiles.getWords(buf);
        ArrayList<User> users = new ArrayList<User>();

        for (int i = 2; i < words.size(); i += 2) {
            User user = new User(words.get(i), Integer.parseInt(words.get(i + 1)));
            users.add(user);
        }

        jsonMakerAndPrinter(users);
    }

    private void jsonMakerAndPrinter(ArrayList<User> users) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(users);

        System.out.println(json);
    }
}
