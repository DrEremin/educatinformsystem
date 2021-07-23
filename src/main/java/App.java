import impl.education.*;
import impl.enums.*;

public class App {
    public static void main(String[] args) {

        University university1 = new University.Builder()
                .setId("M1")
                .setFullName("Первый Санкт-Петербургский " +
                        "государственный медицинский университет " +
                        "им. акад. И.П.Павлова")
                .setShortName("ПСПбГМУ")
                .setYearOfFoundation(1897)
                .setMainProfile("MEDICINE")
                .build();
        System.out.println(university1.getId());
        System.out.println(university1.getFullName());
        System.out.println(university1.getShortName());
        System.out.println(university1.getYearOfFoundation());
        System.out.println(university1.getMainProfile().getProfileName());
        Student student1 = new Student.Builder()
                .setFullName("Макаров Сергей Петрович")
                .setUniversityId("M1")
                .setCurrentCourseNumber(5)
                .setAvgExamSource(4.5f)
                .build();
        System.out.println(student1.getFullName());
        System.out.println(student1.getUniversityId());
        System.out.println(student1.getCurrentCourseNumber());
        System.out.println(student1.getAvgExamSource());
        student1.builder.setFullName("qwerwe");
        System.out.println(student1.getFullName());
    }
}
