package sorting;

import java.util.*;
import sorting.algorithms.SortingType;
import sorting.tools.*;


public class Main {

    public static void main(final String[] args) {
        var scanner = new Scanner(System.in);
        var argsList = Arrays.asList(args);
        SortingType sortingType = getSortingType(argsList);
        String dataType = getDataType(argsList);
        SortingTool sortingTool = SortingToolFactory.getSortingTool(sortingType, dataType);
        System.out.println(sortingTool.sort(scanner));
    }

    private static String getDataType(List<String> argsList) {
        int argsIndex = argsList.indexOf("-dataType");
        return argsIndex != -1 ? argsList.get(argsIndex + 1) : "word";
    }

    private static SortingType getSortingType(List<String> argsList) {
        int argsIndex = argsList.indexOf("-sortingType");
        return argsIndex != -1 ? SortingType.parse(argsList.get(argsIndex + 1)) : SortingType.NATURAL;
    }

}
