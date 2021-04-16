package sorting.algorithms;

import java.util.*;
import java.util.stream.Collectors;

class NaturalSorting<E extends Comparable<? super E>> implements Sorting<E> {
    @Override
    public String sort(Collection<E> c) {
        return c.stream()
                .sorted(Comparator.naturalOrder())
                .map(String::valueOf)
                .collect(Collectors.joining(" ", "Sorted data: ", System.lineSeparator()));
    }
}
