import impl.education.*;
import impl.enums.*;

public class App {
    public static void main(String[] args) {


        University university1 = new University("M1",
                "Первый Санкт-Петербургский государственный медицинский университет им. акад. И.П.Павлова",
                "ПСПбГМУ",
                1897,
                StudyProfile.valueOf("Медицина"));
        System.out.println("Hello World!");
    }
}
