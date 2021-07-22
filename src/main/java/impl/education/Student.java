package impl.education;

public class Student {

    private String fullName;
    private String universityId;
    private int currentCourseNumber;
    private float avgExamSource;

    public Student(String fullName,
                   String universityId,
                   int currentCourseNumber,
                   float avgExamSource) {

        this.fullName = fullName;
        this.universityId = universityId;
        this.currentCourseNumber = currentCourseNumber;
        this.avgExamSource = avgExamSource;
    }

    public String getFullName() {
        return fullName;
    }

    public String getUniversityId() {
        return universityId;
    }

    public int getCurrentCourseNumber() {
        return currentCourseNumber;
    }

    public float getAvgExamSource() {
        return avgExamSource;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setUniversityId(String universityId) {
        this.universityId = universityId;
    }

    public void setCurrentCourseNumber(int currentCourseNumber) {
        this.currentCourseNumber = currentCourseNumber;
    }

    public void setAvgExamSource(float avgExamSource) {
        this.avgExamSource = avgExamSource;
    }
}
