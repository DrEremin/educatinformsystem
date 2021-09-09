package impl.util;

import impl.rest.StructOfDoc;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JavaClassWriterToXmlFile {

    private static final Logger logger = Logger
            .getLogger(JavaClassWriterToXmlFile
            .class
            .getName());

    private static File createFile(String filePath) throws IOException {
        File file = new File(filePath);
        file.createNewFile();
        return file;
    }

    public static void writeObjectToXml(StructOfDoc structOfDoc
            , String filePath) {

        try {
            File file = createFile(filePath);
            JAXBContext context = JAXBContext.newInstance(StructOfDoc.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT
                    , Boolean.TRUE);
            marshaller.marshal(structOfDoc, file);
        } catch (JAXBException jaxbe) {
            logger.log(Level.SEVERE
                    , "There was an error converting the java class to .xml"
                    , jaxbe);
        } catch (IOException ioe) {
            logger.log(Level.SEVERE
                    , "An error occurred while outputting to file "
                            + filePath
                    , ioe);
        }
    }
}
