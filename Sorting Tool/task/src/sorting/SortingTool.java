package sorting;

import java.util.Scanner;

abstract class SortingTool {

    protected SortingType sortingType;

    abstract String sort(Scanner input);

    void setSorting(SortingType sortingType) {
        this.sortingType = sortingType;
    }
}
