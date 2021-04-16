package sorting;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class ByCountSorting<E> implements Sorting<E>{
    @Override
    public String sort(Collection<E> c) {
        var multiSet = getMultiSet(c);
        int multiSetSize = multiSet.size();

        return multiSet.entrySet()
                .stream()
                .map(entry ->  toEntryLine(entry, multiSetSize))
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private long getRate(Long value, int size) {
        return (long) ((double) value / size * 100);
    }

    private Map<String, Long> getMultiSet(Collection<E> c) {
        return c.stream()
                .collect(groupingBy(E::toString, HashMap::new, counting()));
    }

    private String toEntryLine(Map.Entry<String, Long> entry, int multiSetSize) {
        long entryValue = entry.getValue();
        return String.format("%s : %d time(s), %d%%", entry.getKey(), entryValue, getRate(entryValue, multiSetSize));
    }
}
