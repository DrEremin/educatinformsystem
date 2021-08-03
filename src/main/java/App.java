import impl.education.*;
import impl.enums.ComparatorsOfStudent;
import impl.enums.ComparatorsOfUniversity;
import impl.util.ComparatorSelector;
import impl.util.ParseExcel;
import interf.StudentComparator;
import interf.UniversityComparator;

import java.io.IOException;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) throws IOException {

        LinkedList<Student> listOfStudents = ParseExcel
                .readStudents("src/main/resources/US.xlsx");
        LinkedList<University> listOfSUniversities = ParseExcel
                .readUniversities("src/main/resources/US.xlsx");
        StudentComparator studentComparator = ComparatorSelector.
                getStudentComparator(ComparatorsOfStudent.FULL_NAME);
        UniversityComparator universityComparator = ComparatorSelector.
                getUniversityComparator(ComparatorsOfUniversity.SHORT_NAME);
        listOfStudents.stream()
                .sorted(studentComparator)
                .forEach(System.out::println);
        listOfSUniversities.stream()
                .sorted(universityComparator)
                .forEach(System.out::println);
    }
}
