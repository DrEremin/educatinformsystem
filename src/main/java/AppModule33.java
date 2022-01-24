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

/**
 * In this class, the following events occur in the main function: File US.xlsx
 * is parsed using class ParserExel, as a result, lists with objects-models
 * Student and University are obtained from file US.xlsx; Getting the right
 * comparator for the corresponding objects-models; Sorting with these
 * comparators in streams of lists obtained earlier and outputting them to
 * the console and file .log.
 * In VM-options specify:
 * -Djava.util.logging.config.file=path to file log.properties
 */

public class AppModule33 {

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
