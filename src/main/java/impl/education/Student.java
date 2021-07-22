package impl.education;

public class Student {

    String fullName;
    String universityId;
    int currentCourseNumber;
    float avgExamSource;

    public Student(String fullName,
                   String universityId,
                   int currentCourseNumber,
                   float avgExamSource) {

        this.fullName = fullName;
        this.universityId = universityId;
        this.currentCourseNumber = currentCourseNumber;
        this.avgExamSource = avgExamSource;
    }
}
