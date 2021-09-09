import impl.education.*;
import impl.util.ParseExcel;
import impl.util.JsonUtil;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Logger;

public class AppModule34 {

    private static final Logger logger = Logger
            .getLogger(AppModule34.class.getName());

    public static void main(String[] args) throws IOException {

        logger.info("The application has started successfully");

        LinkedList<Student> listOfStudents = ParseExcel
                .readStudents("src/main/resources/US.xlsx");
        LinkedList<University> listOfUniversities = ParseExcel
                .readUniversities("src/main/resources/US.xlsx");

        logger.info("\n++++++++++++++++" +
                "Collections serialization to JSON+++++++++++++++++++");

        String studentsListJson = JsonUtil
                .studentsCollectionSerializer(listOfStudents);
        String universitiesListJson = JsonUtil
                .universitiesCollectionSerializer(listOfUniversities);

        logger.info("\n" + studentsListJson);
        logger.info("\n" + universitiesListJson);

        logger.info("\n+++++++++++++++" +
                "Collections deserialization from JSON++++++++++++++++");

        LinkedList<Student> listOfStudents2 = new LinkedList<>(JsonUtil
                .studentsCollectionDeserializer(studentsListJson));
        LinkedList<University> listOfUniversities2 = new LinkedList<>(JsonUtil
                .universitiesCollectionDeserializer(universitiesListJson));

        for (Student student : listOfStudents2) {
            logger.info("\n" + student);
        }
        for (University university : listOfUniversities2) {
            logger.info("\n" + university);
        }

        logger.info("\n==========================" +
                "Streams===================================");

        listOfStudents.stream()
                .forEach(s -> {
                    String str = JsonUtil.studentSerializer(s);
                    logger.info(str);
                    s = JsonUtil.studentDeserializer(str);
                    logger.info(s.toString());
                });

        listOfUniversities.stream()
                .forEach(u -> {
                    String str = JsonUtil.universitySerializer(u);
                    logger.info(str);
                    u = JsonUtil.universityDeserializer(str);
                    logger.info(u.toString());
                });

        logger.info("The application has exited successfully");
    }
}
