package impl.education;

import com.google.gson.annotations.SerializedName;
import interf.EducationalUnit;

public class Student implements EducationalUnit {

    @SerializedName("Name")
    private String fullName;

    @SerializedName("UID")
    private String universityId;

    @SerializedName("Course")
    private int currentCourseNumber;

    @SerializedName("Average score")
    private float avgExamSource;

    public Builder builder;

    private Student() {}

    public static final class Builder {

        private Student newStudent;

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

    @Override
    public void setBuilder(EducationalUnit educationalUnit) {
        this.builder.newStudent = (Student) educationalUnit;
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

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("---------------------------------");
        stringBuilder.append("\nStudent: ");
        stringBuilder.append(fullName);
        stringBuilder.append("\nId of University: ");
        stringBuilder.append(universityId);
        stringBuilder.append("\nNumber of a current course: ");
        stringBuilder.append(currentCourseNumber);
        stringBuilder.append("\nThe average grade for exams: ");
        stringBuilder.append(avgExamSource);
        stringBuilder.append("\n---------------------------------");
        return stringBuilder.toString();
    }
}
