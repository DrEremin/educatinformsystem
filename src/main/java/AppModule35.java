import impl.education.Student;
import impl.education.University;
import impl.util.ParseExcel;
import impl.util.XlsWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;

public class AppModule35 {
    public static void main(String[] args) throws IOException {

        LinkedList<Student> listOfStudents = ParseExcel
                .readStudents("src/main/resources/US.xlsx");
        LinkedList<University> listOfUniversities = ParseExcel
                .readUniversities("src/main/resources/US.xlsx");

        /*FileOutputStream fos = XlsWriter.createFileOutputStream("src/main/resources/test.txt");
        fos.write(66);*/
    }
}
