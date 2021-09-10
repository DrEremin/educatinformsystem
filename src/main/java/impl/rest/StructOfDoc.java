package impl.rest;

import impl.education.Statistics;
import impl.education.Student;
import impl.education.University;

import com.google.gson.annotations.SerializedName;
import javax.xml.bind.annotation.*;
import java.util.Collection;
import java.util.LinkedList;

@XmlRootElement(name = "root")
@XmlType (propOrder =
        { "studentsInfo"
        , "universitiesInfo"
        , "statisticalInfo" })
public class StructOfDoc {

    @XmlElementWrapper(name = "studentsInfo")
    @XmlElements(@XmlElement(name = "studentEntry"))
    private LinkedList<StudentEntry> studentsInfo;

    @XmlElementWrapper(name = "universitiesInfo")
    @XmlElements(@XmlElement(name = "universityEntry"))
    private LinkedList<UniversityEntry> universitiesInfo;

    @XmlElementWrapper(name = "statisticalInfo")
    @XmlElements(@XmlElement(name = "statisticsEntry"))
    private LinkedList<StatisticsEntry> statisticalInfo;

    private StructOfDoc() {}

    public StructOfDoc( Collection<Student> listOfStudents
            , Collection<University> listOfUniversities
            , Collection<Statistics> listOfStatistics) {

        setStudentInfo(listOfStudents);
        setUniversitiesInfo(listOfUniversities);
        setStatisticalInfo(listOfStatistics);
    }

    @XmlType (propOrder =
            { "studentName"
            , "universityId"
            , "avgScore" })
    public static class StudentEntry {

        @SerializedName("studentName")
        private final String STUDENT_NAME;

        @SerializedName("universityId")
        private final String UNIVERSITY_ID;

        @SerializedName("avgScore")
        private final float AVG_SCORE;

        private StudentEntry(Student student) {
            this.STUDENT_NAME = student.getFullName();
            this.UNIVERSITY_ID = student.getUniversityId();
            this.AVG_SCORE = student.getAvgExamSource();
        }

        @XmlElement(name = "studentName")
        public String getStudentName() {
            return STUDENT_NAME;
        }

        @XmlElement(name = "universityId")
        public String getUniversityId() {
            return UNIVERSITY_ID;
        }

        @XmlElement(name = "avgScore")
        public float getAvgScore() {
            return AVG_SCORE;
        }
    }

    @XmlType (propOrder =
            { "universityId"
            , "universityName"
            , "universityProfile" })
    public static class UniversityEntry {

        @SerializedName("universityId")
        private final String UNIVERSITY_ID;

        @SerializedName("universityName")
        private final String UNIVERSITY_NAME;

        @SerializedName("universityProfile")
        private final String UNIVERSITY_PROFILE;

        private UniversityEntry(University university) {
            this.UNIVERSITY_ID = university.getId();
            this.UNIVERSITY_NAME = university.getFullName();
            this.UNIVERSITY_PROFILE = university.getMainProfile().name();
        }

        @XmlElement(name = "universityId")
        public String getUniversityId() {
            return UNIVERSITY_ID;
        }

        @XmlElement(name = "universityName")
        public String getUniversityName() {
            return UNIVERSITY_NAME;
        }

        @XmlElement(name = "universityProfile")
        public String getUniversityProfile() {
            return UNIVERSITY_PROFILE;
        }
    }

    @XmlType (propOrder =
            { "universityProfile"
            , "avgScore"})
    public static class StatisticsEntry {

        @SerializedName("universityProfile")
        private final String UNIVERSITY_PROFILE;

        @SerializedName("avgScore")
        private final float AVG_SCORE;

        private StatisticsEntry(Statistics statistics) {
            this.UNIVERSITY_PROFILE = statistics.getStudyProfile().name();
            this.AVG_SCORE = statistics.getAvgExamScore();
        }

        @XmlElement(name = "universityProfile")
        public String getUniversityProfile() {
            return UNIVERSITY_PROFILE;
        }

        @XmlElement(name = "avgScore")
        public float getAvgScore() {
            return AVG_SCORE;
        }
    }

    /**
     * Setters
     */

    public void setStudentInfo(Collection<Student> listOfStudents) {

        studentsInfo = new LinkedList<>();
        for (Student student : listOfStudents) {
            studentsInfo.add(new StudentEntry(student));
        }
    }

    public void setUniversitiesInfo(
            Collection<University> listOfUniversities) {

        universitiesInfo = new LinkedList<>();
        for (University university : listOfUniversities) {
            universitiesInfo.add(new UniversityEntry(university));
        }
    }

    public void setStatisticalInfo(
            Collection<Statistics> listOfStatistics) {

        statisticalInfo = new LinkedList<>();
        for (Statistics statistics : listOfStatistics) {
            statisticalInfo.add(new StatisticsEntry(statistics));
        }
    }

    /**
     * Getters
     */

    public LinkedList<StudentEntry> getStudentsInfo() {
        return new LinkedList<>(studentsInfo);
    }

    public LinkedList<UniversityEntry> getUniversitiesInfo() {
        return new LinkedList<>(universitiesInfo);
    }

    public LinkedList<StatisticsEntry> getStatisticalInfo() {
        return new LinkedList<>(statisticalInfo);
    }
}
