package sda.remote28.springexample;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class MyClass {

    public static Stream<String> fetchFilesAsList(List<String> fileNames) throws IOException {
        Stream<String> fileStream = Stream.empty();
        for (String fileName : fileNames) {
            final String filePath = "./blog-url/" + fileName;
            final URL resource = MyClass.class.getClassLoader()
                .getResource(filePath);
            if (resource == null) {
                throw new IllegalArgumentException("Cannot find resource " + filePath);
            }
            final File file = new File(resource.getPath());
            fileStream = Stream.concat(fileStream, Files.lines(Paths.get(file.getAbsolutePath())));
        }
        return fileStream;
    }

}
