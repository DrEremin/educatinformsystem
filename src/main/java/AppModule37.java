import impl.education.Statistics;
import impl.education.Student;
import impl.education.University;
import impl.enums.ComparatorsOfStudent;
import impl.enums.ComparatorsOfUniversity;
import impl.rest.StructOfDoc;
import impl.util.*;
import interf.StudentComparator;
import interf.UniversityComparator;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Logger;

/**
 * In this class, the following events occur in the main function: File US.xlsx
 * is parsed using class ParserExel, as a result, lists with objects-models
 * Student and University are obtained from file US.xlsx; Сollecting statistics
 * on universities and students and getting a list with objects of the
 * Statistics class; Getting the right comparator for  objects-models
 * University and Student; Sorting lists with these comparators; Creating the
 * structure of future documents; Filling this structure with data from
 * Statistics, University and Student objects; Using this structure for
 * creating of files .json and .xml
 * In VM-options specify:
 * -Djava.util.logging.config.file=path to file log.properties
 */

public class AppModule37 {

    private static final Logger logger = Logger
            .getLogger(AppModule35.class.getName());

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
        LinkedList<Statistics> statisticsList = new LinkedList<>(StatisticsCollector
                .collector(listOfUniversities, listOfStudents));

        StudentComparator studentComparator = ComparatorSelector
                .getStudentComparator(ComparatorsOfStudent.FULL_NAME);
        UniversityComparator universityComparator = ComparatorSelector
                .getUniversityComparator(ComparatorsOfUniversity.FULL_NAME);

        listOfStudents.sort(studentComparator);
        listOfUniversities.sort(universityComparator);

        StructOfDoc structOfDoc = new StructOfDoc(listOfStudents
                , listOfUniversities
                , statisticsList);

        JavaClassWriterToXmlFile.writeObjectToXml(structOfDoc, "xmlReqs");

        JavaClassWriterToJsonFile.writeObjectToJson(structOfDoc, "jsonReqs");

        logger.info("The application has exited successfully");
    }
}
