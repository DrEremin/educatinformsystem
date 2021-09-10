package impl.util;

import impl.rest.StructOfDoc;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JavaClassWriterToXmlFile {

    private static final Logger logger = Logger
            .getLogger(JavaClassWriterToXmlFile
                    .class
                    .getName());

    public static void writeObjectToXml(StructOfDoc structOfDoc, String... directories) {

        Optional<File> optional = FileCreator.createFile("xml", directories);

        try {
            if (optional.isPresent()) {
                JAXBContext context = JAXBContext.newInstance(StructOfDoc.class);
                Marshaller marshaller = context.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT
                        , Boolean.TRUE);
                marshaller.marshal(structOfDoc, optional.get());
            }
        } catch (JAXBException e) {
            logger.log(Level.SEVERE
                    , "There was an error converting the java class to .xml"
                    , e);
        }
    }
}
