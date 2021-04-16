package sorting;

public enum SortingType {
    NATURAL, BY_COUNT;

    static SortingType parse(String sortingType) {
        switch (sortingType) {
            case "byCount":
                return BY_COUNT;
            default:
                return NATURAL;
        }
    }
}
