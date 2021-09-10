package impl.util;

import impl.rest.StructOfDoc;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JavaClassWriterToXmlFile {

    private static File file;
    private static LinkedList<String> directoriesNames;

    private static final Logger logger = Logger
            .getLogger(JavaClassWriterToXmlFile
            .class
            .getName());

    private static String getCurrentDate() {
        return LocalDate.now().toString();
    }

    public static void createDirectoriesList(String[] args) {
        directoriesNames = new LinkedList<>();
        directoriesNames.addAll(Arrays.asList(args));
    }

    private static boolean createFile() {

        StringBuilder stringBuilder = new StringBuilder(System
                .getProperty("user.home"));
        for (String directoryName : directoriesNames) {
            stringBuilder.append(File.separator);
            stringBuilder.append(directoryName);
            file = new File(stringBuilder.toString());
            if (!file.exists()) {
                if (!file.mkdir()) {
                    logger.severe("Error creating directory "
                            + stringBuilder);
                    return false;
                }
            }
        }
        stringBuilder.append(File.separator);
        stringBuilder.append(getCurrentDate());
        stringBuilder.append("-req");
        stringBuilder.append(".xml");
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
                return false;
            }
        }
        return true;
    }

    public static void writeObjectToXml(StructOfDoc structOfDoc, String... args) {

        createDirectoriesList(args);
        try {
            if (createFile()) {
                JAXBContext context = JAXBContext.newInstance(StructOfDoc.class);
                Marshaller marshaller = context.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT
                        , Boolean.TRUE);
                marshaller.marshal(structOfDoc, file);
            }
        } catch (JAXBException e) {
            logger.log(Level.SEVERE
                    , "There was an error converting the java class to .xml"
                    , e);
        } finally {
            file = null;
        }
    }
}
