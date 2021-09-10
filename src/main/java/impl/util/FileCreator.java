package impl.util;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileCreator {

    private static LinkedList<String> directoriesNames;

    private static final Logger logger = Logger
            .getLogger(JavaClassWriterToXmlFile
                    .class
                    .getName());

    private static String getCurrentDate() {
        return LocalDate.now().toString();
    }

    private static void createDirectoriesList(String[] args) {
        directoriesNames = new LinkedList<>();
        directoriesNames.addAll(Arrays.asList(args));
    }

    public static Optional<File> createFile(String postfixWithoutDot
            , String[] directories) {

        createDirectoriesList(directories);

        StringBuilder stringBuilder = new StringBuilder(System
                .getProperty("user.home"));
        File file;

        for (String directoryName : directoriesNames) {
            stringBuilder.append(File.separator);
            stringBuilder.append(directoryName);
            file = new File(stringBuilder.toString());
            if (!file.exists()) {
                if (!file.mkdir()) {
                    logger.severe("Error creating directory "
                            + stringBuilder);
                    return Optional.empty();
                }
            }
        }

        stringBuilder.append(File.separator);
        stringBuilder.append(getCurrentDate());
        stringBuilder.append("-req.");
        stringBuilder.append(postfixWithoutDot);
        file = new File(stringBuilder.toString());

        if (!file.exists()) {
            try {
                if (!file.createNewFile()) {
                    logger.severe("Error creating file "
                            + stringBuilder);
                }
            } catch (IOException e) {
                logger.log(Level.SEVERE
                        , "Error input/output"
                        , e);
                return Optional.empty();
            }
        }
        return Optional.of(file);
    }
}
