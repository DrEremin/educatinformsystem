import java.io.IOException;
import java.util.LinkedList;
import impl.education.Statistics;
import impl.education.Student;
import impl.education.University;
import impl.util.ParseExcel;
import impl.util.StatisticsCollector;
import impl.util.XlsWriter;

public class AppModule35 {
    public static void main(String[] args) throws IOException {

        LinkedList<Student> listOfStudents = ParseExcel
                .readStudents("src/main/resources/US.xlsx");
        LinkedList<University> listOfUniversities = ParseExcel
                .readUniversities("src/main/resources/US.xlsx");

        LinkedList<Statistics> statisticsList = new LinkedList<>(StatisticsCollector
                .collector(listOfUniversities, listOfStudents));

        XlsWriter.generationFileXLXS(statisticsList, "src/main/resources/test.xlsx");
    }
}
