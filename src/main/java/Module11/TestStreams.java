package Module11;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStreams {
    public static void main(String[] args) {
        System.out.println(WorkingWithStreams.oddNames());
        System.out.println(WorkingWithStreams.sortedNames());
        String[] array = {"1, 2, 0", "4, 5"};
        System.out.println(WorkingWithStreams.sortedNumbers(array));
        System.out.println(WorkingWithStreams.randomStream(25214903917L, 11L, 281474976710656L).limit(25).collect(Collectors.toList()));
        Stream<String> c1 = Stream.of("A", "B", "C", "D");
        Stream<String> c2 = Stream.of("1", "2", "3");
        System.out.println(WorkingWithStreams.zip(c1, c2).collect(Collectors.toList()));
    }
}
