package sorting;

import java.io.*;
import java.util.*;
import sorting.algorithms.SortingType;
import sorting.tools.*;


public class Main {

    public static void main(final String[] args) throws Exception {
        var argsList = Arrays.asList(args);
        var fileNameOptional = tryGetFileOutputName(argsList);
        try (Scanner scanner = getInput(argsList);
             var output = new PrintStreamWrapper(fileNameOptional)){

            SortingType sortingType = getSortingType(argsList);
            String dataType = getDataType(argsList);
            SortingTool sortingTool = SortingToolFactory.getSortingTool(sortingType, dataType);
            output.println(sortingTool.sort(scanner));

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    private static Optional<String> tryGetFileOutputName(List<String> argsList) throws IOException {
        int outputArgIndex = argsList.indexOf("-outputFile");
        Optional<String> optional = Optional.empty();

        if (outputArgIndex != - 1) {
            optional = Optional.of(argsList.get(outputArgIndex + 1));
        }

        return optional;
    }

    private static Scanner getInput(List<String> args) throws IOException {
        int inputArgIndex = args.indexOf("-inputFile");
        InputStream inputStream;

        if (inputArgIndex == - 1) {
            inputStream = System.in;
        } else {
            var fileName = args.get(inputArgIndex + 1);
            inputStream = new FileInputStream(fileName);
        }

        return new Scanner(inputStream);
    }

    private static String getDataType(List<String> argsList) throws IllegalArgumentException {
        int argsIndex = argsList.indexOf("-dataType");

        if (argsIndex == - 1) {
            return "word";
        } else if (argsIndex + 1 >= argsList.size()) {
            throw new IllegalArgumentException("No data type defined!");
        }

        return argsList.get(argsIndex + 1);
    }

    private static SortingType getSortingType(List<String> argsList) {
        int argsIndex = argsList.indexOf("-sortingType");

        if (argsIndex == - 1) {
            return SortingType.NATURAL;
        } else if (argsIndex + 1 >= argsList.size()) {
            throw new IllegalArgumentException("No sorting type defined!");
        }

        return SortingType.parse(argsList.get(argsIndex + 1));
    }

}
