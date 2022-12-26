package Module10;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WorkWithFiles {
    public static void phoneFileValidate() {
        char[] buf = new char[256];
        try (FileReader reader = new FileReader(".\\src\\main\\resources\\file.txt")) {
            int c;
            int count = 0;
            while ((c = reader.read(buf)) > 0) {
                count++;
                if (c < 256) {
                    buf = Arrays.copyOf(buf, c + 1);
                }
            }
            if (count == 0) {
                throw new IOException("It's an empty file");
            }
            buf[buf.length - 1] = '\n';
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return;
        }

        StringBuilder result = new StringBuilder();
        ArrayList<String> numbers = new ArrayList<String>();
        int count = 0;
        for (char item : buf) {
            if ((item != '\r') && (item != '\n')) {
                result.append(item);
                count++;
            } else if (count > 0) {
                String number = result.toString();
                result.delete(0, result.length());
                numbers.add(number);
                count = 0;
            }
        }

        String patterns
                = "^\\(\\d{3}\\) \\d{3}\\-\\d{4}$"
                + "|^\\d{3}[-]\\d{3}[-]\\d{4}$";
        Pattern pattern = Pattern.compile(patterns);
        for (String number : numbers) {
            Matcher matcher = pattern.matcher(number);
            if (matcher.matches()) {
                System.out.println("number = " + number);
            }
        }
    }
}
