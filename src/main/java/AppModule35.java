import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Logger;

import impl.education.Statistics;
import impl.education.Student;
import impl.education.University;
import impl.util.ParseExcel;
import impl.util.StatisticsCollector;
import impl.util.XlsWriter;

/**
 * In this class, the following events occur in the main function: File US.xlsx
 * is parsed using class ParserExel, as a result, lists with objects-models
 * Student and University are obtained from file US.xlsx; Сollecting statistics
 * on universities and students and getting a list with objects of the
 * Statistics class; creating a new file test.xlsx and writing statistics data
 * to it.
 * In VM-options specify:
 * -Djava.util.logging.config.file=path to file log.properties
 */

public class AppModule35 {

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

        XlsWriter.generationFileXLXS(statisticsList, "src"
                + File.separator
                + "main"
                + File.separator
                + "resources"
                + File.separator
                + "test.xlsx");

        logger.info("The application has exited successfully");
    }
}
