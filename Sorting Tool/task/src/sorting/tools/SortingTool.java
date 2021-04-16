package sorting.tools;

import sorting.algorithms.SortingType;

import java.util.Scanner;

public abstract class SortingTool {

    protected SortingType sortingType;

    public abstract String sort(Scanner input);

    void setSortingType(SortingType sortingType) {
        this.sortingType = sortingType;
    }

    protected abstract String getSizeLine(int size);

    protected String getSummary(int size, String sortedDataLine) {
        String totalNumbersLine = getSizeLine(size);
        return totalNumbersLine + sortedDataLine;
    }
}
