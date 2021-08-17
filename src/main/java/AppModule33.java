import impl.education.Student;
import impl.education.University;
import impl.enums.ComparatorsOfStudent;
import impl.enums.ComparatorsOfUniversity;
import impl.util.ComparatorSelector;
import impl.util.ParseExcel;
import interf.StudentComparator;
import interf.UniversityComparator;
import java.io.IOException;
import java.util.LinkedList;

public class AppModule33 {

    public static void main(String[] args) throws IOException {

        LinkedList<Student> listOfStudents = ParseExcel
                .readStudents("src/main/resources/US.xlsx");
        LinkedList<University> listOfUniversities = ParseExcel
                .readUniversities("src/main/resources/US.xlsx");
        StudentComparator studentComparator = ComparatorSelector
                .getStudentComparator(ComparatorsOfStudent.FULL_NAME);
        UniversityComparator universityComparator = ComparatorSelector
                .getUniversityComparator(ComparatorsOfUniversity.SHORT_NAME);
        listOfStudents.stream()
                .sorted(studentComparator)
                .forEach(System.out::println);
        listOfUniversities.stream()
                .sorted(universityComparator)
                .forEach(System.out::println);
    }
}
