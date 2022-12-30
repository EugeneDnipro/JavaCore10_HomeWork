package Module11;

import java.util.stream.Collectors;

public class TestStreams {
    public static void main(String[] args) {
        System.out.println(WorkingWithStreams.oddNames());
        System.out.println(WorkingWithStreams.sortedNames());
        String[] array = {"1, 2, 0", "4, 5"};
        System.out.println(WorkingWithStreams.sortedNumbers(array));
        System.out.println(WorkingWithStreams.randomStream(25214903917L, 11L, 281474976710656L).limit(25).collect(Collectors.toList()));
    }
}
