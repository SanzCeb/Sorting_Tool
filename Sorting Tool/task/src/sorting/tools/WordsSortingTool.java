package sorting.tools;

import java.util.*;

import sorting.algorithms.SortingFactory;


class WordsSortingTool extends SortingTool {
    @Override
    public String sort(Scanner scanner) {
        var words = new ArrayList<String>();
        var sorting = SortingFactory.<String>getSorting(sortingType);
        while (scanner.hasNextLine()) {
            var lineWords = parseLine(scanner.nextLine());
            words.addAll(lineWords);
        }

        return getSummary(words.size(), sorting.sort(words));
    }

    @Override
    protected String getSizeLine(int size) {
        return String.format("Total words: %d%n", size);
    }

    private static List<String> parseLine(String nextLine) {
        return Arrays.asList(nextLine.split("\\s+"));
    }

}
