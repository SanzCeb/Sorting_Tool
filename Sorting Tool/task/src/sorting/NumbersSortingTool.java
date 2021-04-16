package sorting;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumbersSortingTool extends SortingTool {
    @Override
    String sort(Scanner input) {
        List<Integer> numbers = new ArrayList<>();
        var sorting = SortingFactory.<Integer>getSorting(sortingType);

        while (input.hasNextInt()) {
            int number = input.nextInt();
            numbers.add(number);
        }

        return getSummary(numbers.size(), sorting.sort(numbers));
    }

    private String getSummary(int size, String sortedDataLine) {
        String totalNumbersLine = getTotalNumbersLine(size);
        return totalNumbersLine + sortedDataLine;
    }

    private static String getTotalNumbersLine(int size) {
        return String.format("Total numbers: %d%n", size);
    }


}
