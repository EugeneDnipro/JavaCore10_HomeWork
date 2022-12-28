package Module10;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WorkWithFiles {

    public static char[] dataFromFileReader(String path) {
        char[] buf = new char[256];
        int count = 0;
        try (FileReader reader = new FileReader(path)) {
            int c;
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
            return null;
        }
        return buf;
    }

    private static ArrayList<String> getNumbers(char[] buf) {
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
        return numbers;
    }

    private static void printData(ArrayList<String> numbers) {
        String patterns
                = "^\\(\\d{3}\\) \\d{3}\\-\\d{4}$"
                + "|^\\d{3}[-]\\d{3}[-]\\d{4}$";
        Pattern pattern = Pattern.compile(patterns);
        for (String number : numbers) {
            Matcher matcher = pattern.matcher(number);
            if (matcher.matches()) {
                System.out.println(number);
            }
        }
    }

    public static void phoneFileValidate() {
        String path = ".\\src\\main\\resources\\file.txt";
        char[] buf = dataFromFileReader(path);
        if (buf != null) {
            printData(getNumbers(buf));
        }
    }

    public static void printSortedWordsNumber(Map<String, Integer> map) {
        for (Map.Entry<String, Integer> entry : map.entrySet())
            System.out.println(entry.getKey() + " " + entry.getValue());
    }

    public static Map<String, Integer> sorter(Map<String, Integer> wordsNumber) {
        List<Map.Entry<String, Integer>> wordsNumberList = new ArrayList(wordsNumber.entrySet());
        wordsNumberList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
                return b.getValue() - a.getValue();
            }
        });

        Map<String, Integer> sortedWordsNumber = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : wordsNumberList) {
            sortedWordsNumber.put(entry.getKey(), entry.getValue());
        }
        return sortedWordsNumber;
    }

    public static ArrayList<String> getWords(char[] buf) {
        StringBuilder result = new StringBuilder();
        ArrayList<String> words = new ArrayList<String>();
        int count = 0;
        for (char item : buf) {
            if ((item != '\r') && (item != '\n') && (item != ' ')) {
                result.append(item);
                count++;
            } else if (count > 0) {
                String word = result.toString();
                result.delete(0, result.length());
                words.add(word);
                count = 0;
            }
        }
        return words;
    }

    public static void wordCounter() {
        String path = ".\\src\\main\\resources\\words.txt";
        char[] buf = dataFromFileReader(path);
        if (buf == null) {
            return;
        }

        ArrayList<String> words = getWords(buf);

        Map<String, Integer> wordsNumber = new HashMap<>();
        for (String elem : words) {
            if (wordsNumber.containsKey(elem))
                wordsNumber.put(elem, wordsNumber.get(elem) + 1);
            else wordsNumber.put(elem, 1);
        }

        printSortedWordsNumber(sorter(wordsNumber));
    }
}
