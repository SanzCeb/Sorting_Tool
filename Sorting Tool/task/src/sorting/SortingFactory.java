package sorting;

public class SortingFactory {

    static <E extends Comparable<E>> Sorting<E> getSorting(SortingType sortingType) {
        return sortingType == SortingType.NATURAL ? new NaturalSorting<>() : new ByCountSorting<>();
    }

}
