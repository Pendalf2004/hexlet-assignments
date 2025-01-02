package exercise;

import java.io.IOException;
import java.nio.file.*;
import java.util.Locale;
import java.util.concurrent.CompletableFuture;
import java.util.Arrays;
import java.io.File;
import java.util.concurrent.ExecutionException;

class App {

    // BEGIN
    public static CompletableFuture<String> unionFiles(String firstPath, String secondPath, String resultPath) {

        CompletableFuture<String> getFirstFileData = CompletableFuture.supplyAsync(() -> {
            try {
                Path normalizedPath = Path.of(firstPath);
                return Files.readAllLines(normalizedPath).toString();
            } catch (IOException e) {
                throw new RuntimeException(e.getMessage());
            }

        }).exceptionally(ex -> {
            System.out.println(ex.getMessage());
            return ex.getMessage();
        });

        CompletableFuture<String> getSecondFileData = CompletableFuture.supplyAsync(() -> {
            Path normalizedPath = Paths.get(secondPath);
            try {
                return Files.readString(normalizedPath);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }).exceptionally(ex -> {
            System.out.println(ex.getMessage());
            return ex.getMessage();
        });

        CompletableFuture<String> combineData = getFirstFileData.thenCombine(getSecondFileData,
                (firstData, secondData) -> {
                String result = firstData + secondData;
                Path resultingPath = Path.of(resultPath);
                File resultFile = resultingPath.toFile();
                try {
                    resultFile.createNewFile();
                    Files.writeString(resultingPath, result);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                return result;
        }).exceptionally(Throwable::getMessage);

        return combineData;

    };
    // END

    public static void main(String[] args) throws Exception {
        // BEGIN
        unionFiles("/home/john/Hexlet/hexlet-assignments/java-advanced-ru/asynchrony/build/resources/main/file1.txt",
                "/home/john/Hexlet/hexlet-assignments/java-advanced-ru/asynchrony/build/resources/main/file2.txt",
                "/home/john/Hexlet/hexlet-assignments/java-advanced-ru/asynchrony/build/resources/main/file3.txt");
        // END
    }
}

