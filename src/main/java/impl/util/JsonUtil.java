package impl.util;

import impl.education.Student;
import impl.education.University;
import interf.EducationalUnit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import java.util.Collection;

public class JsonUtil {

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private JsonUtil() {}

    public static String educationalUnitSerializer(EducationalUnit educationalUnit) {
        educationalUnit.setBuilder(null);
        String json = gson.toJson(educationalUnit, educationalUnit.getClass());
        educationalUnit.setBuilder(educationalUnit);
        return json;
    }

    public static String educationalUnitCollectionSerializer
            (Collection<? extends EducationalUnit> collection) {

        for (EducationalUnit educationalUnit : collection) {
            educationalUnit.setBuilder(null);
        }

        String json = gson.toJson(collection, collection.getClass());

        for (EducationalUnit educationalUnit : collection) {
            educationalUnit.setBuilder(educationalUnit);
        }
        return json;
    }

    public static Student studentDeserializer(String json) throws JsonParseException {
        Student student = gson.fromJson(json, Student.class);
        student.setBuilder(student);
        return student;
    }

    public static Collection<Student> studentsCollectionDeserializer(String json) {
        Collection<Student> collection = gson.fromJson(
                json,
                new TypeToken<Collection<Student>>(){}.getType());
        for (Student student : collection) {
            student.setBuilder(student);
        }
        return collection;
    }

    public static University universityDeserializer(String json) throws JsonParseException {
        University university = gson.fromJson(json, University.class);
        university.setBuilder(university);
        return university;
    }

    public static Collection<University> universitiesCollectionDeserializer(String json) {
        Collection<University> collection = gson.fromJson(
                json,
                new TypeToken<Collection<University>>(){}.getType());
        for (University university : collection) {
            university.setBuilder(university);
        }
        return collection;
    }
}
