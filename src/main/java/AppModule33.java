import impl.education.Student;
import impl.education.University;
import impl.enums.ComparatorsOfStudent;
import impl.enums.ComparatorsOfUniversity;
import impl.util.ComparatorSelector;
import impl.util.ParseExcel;
import interf.StudentComparator;
import interf.UniversityComparator;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Logger;

public class AppModule33 {

    /*
       В "Run/Debug Configurations", в VM-options прописал путь:
       -Djava.util.logging.config.file=/home/ivan/Programming/
       IdeaProjects/educatinformsystem/src/main/resources/log.properties
     */

    private static final Logger logger = Logger
            .getLogger(AppModule33.class.getName());

    public static void main(String[] args) throws IOException {

        logger.info("The application has started successfully");

        LinkedList<Student> listOfStudents = ParseExcel
                .readStudents("src"
                        + File.separator
                        + "main"
                        + File.separator
                        + "resources"
                        + File.separator
                        + "US.xlsx");
        LinkedList<University> listOfUniversities = ParseExcel
                .readUniversities("src"
                        + File.separator
                        + "main"
                        + File.separator
                        + "resources"
                        + File.separator
                        + "US.xlsx");
        StudentComparator studentComparator = ComparatorSelector
                .getStudentComparator(ComparatorsOfStudent.FULL_NAME);
        UniversityComparator universityComparator = ComparatorSelector
                .getUniversityComparator(ComparatorsOfUniversity.SHORT_NAME);
        listOfStudents.stream()
                .sorted(studentComparator)
                .forEach(s->logger.info(s.toString()));
        listOfUniversities.stream()
                .sorted(universityComparator)
                .forEach(s->logger.info(s.toString()));

        logger.info("The application has exited successfully");
    }
}
