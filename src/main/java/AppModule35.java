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
