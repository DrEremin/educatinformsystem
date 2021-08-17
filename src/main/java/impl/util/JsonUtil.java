package impl.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import impl.education.Student;
import impl.education.University;

import java.lang.reflect.Type;
import java.util.Collection;

public class JsonUtil {

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private JsonUtil() {}

    public static String studentSerializer(Student student) {
        student.setBuilderNewStudent(null);
        String json = gson.toJson(student, student.getClass());
        student.setBuilderNewStudent(student);
        return json;
    }

    public static String universitySerializer(University university) {
        university.setBuilderNewUniversity(null);
        String json = gson.toJson(university, university.getClass());
        university.setBuilderNewUniversity(university);
        return json;
    }

    public static String studentsCollectionSerializer(Collection<Student> collection) {
        for (Student student : collection) {
            student.setBuilderNewStudent(null);
        }
        String json = gson.toJson(collection, collection.getClass());
        for (Student student : collection) {
            student.setBuilderNewStudent(student);
        }
        return json;
    }

    public static String universitiesCollectionSerializer(Collection<University> collection) {
        for (University university : collection) {
            university.setBuilderNewUniversity(null);
        }
        String json = gson.toJson(collection, collection.getClass());
        for (University university : collection) {
            university.setBuilderNewUniversity(university);
        }
        return json;
    }

    public static Student studentDeserializer(String json) {
        Student student = gson.fromJson(json, Student.class);
        student.setBuilderNewStudent(student);
        return student;
    }

    public static Collection<Student> studentsCollectionDeserializer(String json) {
        Collection<Student> collection = gson.fromJson(
                json,
                new TypeToken<Collection<Student>>(){}.getType());
        for (Student student : collection) {
            student.setBuilderNewStudent(student);
        }
        return collection;
    }

    public static University universityDeserializer(String json) throws JsonParseException {
        University university = gson.fromJson(json, University.class);
        university.setBuilderNewUniversity(university);
        return university;
    }

    public static Collection<University> universitiesCollectionDeserializer(String json) {
        Collection<University> collection = gson.fromJson(
                json,
                new TypeToken<Collection<University>>(){}.getType());
        for (University university : collection) {
            university.setBuilderNewUniversity(university);
        }
        return collection;
    }

}
