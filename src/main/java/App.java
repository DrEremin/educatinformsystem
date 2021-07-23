import impl.education.*;
import impl.util.ParseExcel;

import java.io.IOException;
import java.util.LinkedList;

public class App {
    public static void main(String[] args) throws IOException {

        LinkedList<Student> listOfStudents = ParseExcel
                .readStudents("src/main/resources/US.xlsx");
        LinkedList<University> listOfSUniversities = ParseExcel
                .readUniversities("src/main/resources/US.xlsx");
        for (Student student :listOfStudents) {
            System.out.println(student);
        }
        for (University university :listOfSUniversities) {
            System.out.println(university);
        }
    }
}
