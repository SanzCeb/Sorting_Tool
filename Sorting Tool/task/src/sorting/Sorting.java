package sorting.algorithms;

import java.util.Collection;

public interface Sorting <E extends Comparable<? super E>> {

    String sort(Collection<E> c);

}
