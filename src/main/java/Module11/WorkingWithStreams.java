package Module11;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class WorkingWithStreams {
    public static List<String> names = Arrays.asList("Jeremy", "Bill", "Richard", "John", "James", "Tom");

    public static void oddNames() {
        AtomicInteger i = new AtomicInteger(1);
        AtomicInteger j = new AtomicInteger(0);
        Stream<String> nameStream = names.stream()
                .map(name -> (i.getAndIncrement()) + ". " + name)
                .filter(e -> ((j.getAndIncrement()) % 2 == 0));

        List<String> filteredNames = nameStream.collect(toList());

        System.out.println(filteredNames);
    }

}

