package sorting.tools;

import java.util.*;

import sorting.algorithms.SortingFactory;

class NumbersSortingTool extends SortingTool {

    @Override
    public String sort(Scanner input) {
        List<Integer> numbers = new ArrayList<>();
        var sorting = SortingFactory.<Integer>getSorting(sortingType);

        while (input.hasNextInt()) {
            int number = input.nextInt();
            numbers.add(number);
        }

        return getSummary(numbers.size(), sorting.sort(numbers));
    }

    @Override
    protected String getSizeLine(int size) {
        return String.format("Total numbers: %d%n", size);
    }


}
