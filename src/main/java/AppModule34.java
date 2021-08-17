import com.google.gson.JsonParseException;
import impl.education.*;
import impl.enums.ComparatorsOfStudent;
import impl.enums.ComparatorsOfUniversity;
import impl.util.ComparatorSelector;
import impl.util.ParseExcel;
import interf.StudentComparator;
import interf.UniversityComparator;
import impl.util.JsonUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class AppModule34 {
    public static void main(String[] args) throws IOException {

        LinkedList<Student> listOfStudents = ParseExcel
                .readStudents("src/main/resources/US.xlsx");
        LinkedList<University> listOfUniversities = ParseExcel
                .readUniversities("src/main/resources/US.xlsx");

        System.out.println("++++++++++++++++" +
                "Collections serialization to JSON+++++++++++++++++++");

        String studentsListJson = JsonUtil
                .studentsCollectionSerializer(listOfStudents);
        String universitiesListJson = JsonUtil
                .universitiesCollectionSerializer(listOfUniversities);

        System.out.println(studentsListJson);
        System.out.println(universitiesListJson);

        System.out.println("++++++++++++++++" +
                "++++++++++++++++++++++++++++++++++++++++++++++++++++");

        System.out.println("+++++++++++++++" +
                "Collections deserialization from JSON++++++++++++++++");

        LinkedList<Student> listOfStudents2 = new LinkedList<>(JsonUtil
                .studentsCollectionDeserializer(studentsListJson));
        LinkedList<University> listOfUniversities2 = new LinkedList<>(JsonUtil
                .universitiesCollectionDeserializer(universitiesListJson));

        for (Student student : listOfStudents2) {
            System.out.println(student);
        }
        for (University university : listOfUniversities2) {
            System.out.println(university);
        }
        System.out.println("++++++++++++++++" +
                "++++++++++++++++++++++++++++++++++++++++++++++++++++");

        System.out.println("==========================Streams===================================");
        ArrayList<String> studentsListJsonStream = new ArrayList<>();
        ArrayList<String> universitiesListJsonStream = new ArrayList<>();
        listOfStudents.stream()
                .forEach(s -> {
                    String str = JsonUtil.studentSerializer(s);
                    System.out.println(str);
                    s = JsonUtil.studentDeserializer(str);
                    System.out.println(s);
                });
        listOfUniversities.stream()
                .forEach(u -> {
                    String str = JsonUtil.universitySerializer(u);
                    System.out.println(str);
                    u = JsonUtil.universityDeserializer(str);
                    System.out.println(u);
                });

        System.out.println("====================================================================");
    }
}
