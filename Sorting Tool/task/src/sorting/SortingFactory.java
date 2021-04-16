package sorting.algorithms;

public class SortingFactory {

    public static <E extends Comparable<? super E>> Sorting<E> getSorting(SortingType sortingType) {
        return sortingType == SortingType.NATURAL ? new NaturalSorting<>() : new ByCountSorting<>();
    }

}
