package Module11;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WorkingWithStreams {
    List<String> names = Arrays.asList("Jeremy", "Bill", "Richard", "John", "James", "Tom");
    Stream<String> nameStream = names.stream();

    List<String> filteredNames = names.stream().collect(Collectors.toList());

    //    System.out.println(filteredNames);
}

