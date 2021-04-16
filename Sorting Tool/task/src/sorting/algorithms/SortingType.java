package sorting.algorithms;

public enum SortingType {

    NATURAL, BY_COUNT;

    public static SortingType parse(String sortingType) {
        switch (sortingType) {
            case "byCount":
                return BY_COUNT;
            default:
                return NATURAL;
        }
    }
}
