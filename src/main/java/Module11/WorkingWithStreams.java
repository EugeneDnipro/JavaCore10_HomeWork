package Module11;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WorkingWithStreams {
    public static List<String> names = Arrays.asList("Jeremy", "Bill", "Richard", "John", "James", "Tom");

    public static String oddNames() {
        AtomicInteger i = new AtomicInteger(1);
        AtomicInteger j = new AtomicInteger(0);
        return names.stream()
                .map(name -> (i.getAndIncrement()) + ". " + name)
                .filter(e -> ((j.getAndIncrement()) % 2 == 0))
                .collect(Collectors.joining(", "));
    }

    public static List<String> sortedNames() {
        return names.stream()
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    public static String sortedNumbers(String[] array) {
        return Stream.of(array)
                .map(n -> n.replace("\"", ""))
                .sorted()
                .collect(Collectors.joining(", "));
    }

    public static <T> long generator(T n1, long a1, long c1, long m1) {
        return (a1 * (long) n1 + c1) % m1;
    }

    public static Stream<Long> randomStream(long a, long c, long m) {
        return Stream.iterate(7L, n -> generator(n, a, c, m));
    }

}

