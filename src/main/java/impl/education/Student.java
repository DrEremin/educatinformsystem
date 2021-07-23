package impl.education;

public class Student {

    private String fullName;
    private String universityId;
    private int currentCourseNumber;
    private float avgExamSource;
    public Builder builder;

    private Student() {}

    public static final class Builder {

        private final Student newStudent;

        public Builder() {

            newStudent = new Student();
        }

        public Builder setFullName(String fullName) {
            newStudent.fullName = fullName;
            return this;
        }

        public Builder setUniversityId(String universityId) {
            newStudent.universityId = universityId;
            return this;
        }

        public Builder setCurrentCourseNumber(int currentCourseNumber) {
            newStudent.currentCourseNumber = currentCourseNumber;
            return this;
        }

        public Builder setAvgExamSource(float avgExamSource) {
            newStudent.avgExamSource = avgExamSource;
            return this;
        }

        public Student build() {
            newStudent.builder = this;
            return newStudent;
        }
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
}
