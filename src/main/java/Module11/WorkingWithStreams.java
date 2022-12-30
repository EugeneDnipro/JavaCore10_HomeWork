package Module11;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class WorkingWithStreams {
    public static List<String> names = Arrays.asList("Jeremy", "Bill", "Richard", "John", "James", "Tom");

    public static void oddNames() {
        AtomicInteger i = new AtomicInteger(1);
        AtomicInteger j = new AtomicInteger(0);
        String oddNamesString = names.stream()
                .map(name -> (i.getAndIncrement()) + ". " + name)
                .filter(e -> ((j.getAndIncrement()) % 2 == 0))
                .collect(Collectors.joining(", "));

        System.out.println(oddNamesString);
    }

    public static void sortedNames() {
        List<String> sortedNamesStringList = names.stream()
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        System.out.println(sortedNamesStringList);
    }

}

