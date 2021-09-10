package impl.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import impl.rest.StructOfDoc;

import java.io.*;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JavaClassWriterToJsonFile {

    private static final Logger logger = Logger
            .getLogger(JavaClassWriterToXmlFile
                    .class
                    .getName());

    public static void writeObjectToJson(StructOfDoc structOfDoc, String... directories) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Optional<File> optional = FileCreator.createFile("json", directories);

        if (optional.isPresent()) {

            try (Writer fileWriter = new FileWriter(optional.get())) {
                gson.toJson(structOfDoc
                        , structOfDoc.getClass()
                        ,fileWriter);
            } catch (IOException e) {
               logger.log(Level.SEVERE, "Error writing to file");
            }
        }
    }
}
