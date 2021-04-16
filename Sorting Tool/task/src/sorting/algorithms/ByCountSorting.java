package sorting.algorithms;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.*;

class ByCountSorting<E extends Comparable<? super E>> implements Sorting<E> {
    private final Comparator<Map.Entry<E, Long>> byValueThenByKeyComparator = Map.Entry.<E, Long>comparingByValue()
                    .thenComparing(Map.Entry.comparingByKey());

    @Override
    public String sort(Collection<E> collection) {
        Map<E, Long> multiSet = getMultiSet(collection);
        int multiSetSize = multiSet.size();

        return multiSet.entrySet()
                .stream()
                .sorted(byValueThenByKeyComparator)
                .map(entry ->  toEntryLine(entry, multiSetSize))
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private long getRate(Long value, int size) {
        return (long) ((double) value / size * 100);
    }

    private Map<E, Long> getMultiSet(Collection<E> c) {
        return c.stream()
                .collect(groupingBy(Function.identity(), HashMap::new, counting()));
    }

    private String toEntryLine(Map.Entry<E, Long> entry, int multiSetSize) {
        long entryValue = entry.getValue();
        return String.format("%s: %d time(s), %d%%", entry.getKey(), entryValue, getRate(entryValue, multiSetSize));
    }
}
