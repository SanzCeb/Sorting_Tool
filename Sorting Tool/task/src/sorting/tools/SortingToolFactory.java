package sorting.tools;

import sorting.algorithms.SortingType;

public class SortingToolFactory {

    public static SortingTool getSortingTool(SortingType sortingType, String dataType) {
        var newSorter = getSorter(dataType);
        newSorter.setSortingType(sortingType);
        return newSorter;
    }

    private static SortingTool getSorter(String dataType) {
        SortingTool newSorter;

        switch (dataType) {
            case "long":
                newSorter = new NumbersSortingTool();
                break;
            case "line":
                newSorter = new LinesSortingTool();
                break;
            default:
                newSorter = new WordsSortingTool();
                break;
        }

        return newSorter;
    }
}
