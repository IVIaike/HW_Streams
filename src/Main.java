import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        Stream<String> streamOfSomeData = Stream.of("a", "b", "d", "c", "z", "xy", "xv", "yz");
        Comparator<String> comparator = Comparator.comparing(String::length);
        BiConsumer<String, String> consumer = (min,max) -> System.out.println(min + ";  " + max + ";");
        findMinMax(streamOfSomeData, comparator, consumer);

        System.out.println("*****************************************\n");

        foundCountEvenNumbers (List.of(1, 3,34,57,235,346,457,568,679,789,1121,2346));

    }

    private static void findMinMax(Stream<String> streamOfSomeData, Comparator<String> order, BiConsumer<String, String> minMaxConsumer) {
        List<String> list = streamOfSomeData.collect(Collectors.toList());
        if (list.isEmpty()) {
            minMaxConsumer.accept(null, null);
        } else {
            list.sort(order);
            minMaxConsumer.accept(list.get(0), list.get(list.size()-1));
        }
    }

    public static void foundCountEvenNumbers (List<Integer>list) {
        Stream<Integer>stream = list.stream();
        Predicate<Integer>predicate = i -> i%2 ==0;
        Stream<Integer>integerEvenStream = stream.filter(predicate);
        System.out.println("Количество четных чисел:" + integerEvenStream.count());
    }
}