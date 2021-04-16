package sorting.tools;

import sorting.algorithms.SortingFactory;

import java.util.*;

class LinesSortingTool extends SortingTool {

    @Override
    public String sort(Scanner scanner) {
        List<String> lines = new ArrayList<>();
        var sorting = SortingFactory.<String>getSorting(sortingType);

        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            lines.add(line);
        }

        return getSummary(lines.size(), sorting.sort(lines));
    }

    @Override
    protected String getSizeLine(int size) {
        return String.format("Total lines: %d%n", size);
    }

}
