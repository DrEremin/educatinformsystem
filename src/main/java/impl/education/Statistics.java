package impl.education;

import impl.enums.StudyProfile;
import java.util.ArrayList;

public class Statistics {

    private StudyProfile studyProfile;
    private float avgExamScore;
    private int numberOfStudentsByProfile;
    private int numberOfUniversitiesByProfile;
    private ArrayList<String> namesOfUniversities;

    Statistics() {
        studyProfile = null;
        avgExamScore = 0.0f;
        numberOfStudentsByProfile = 0;
        numberOfUniversitiesByProfile = 0;
        namesOfUniversities = new ArrayList<>();
    }

    public Statistics(StudyProfile studyProfile,
                      float avgExamScore,
                      int numberOfStudentsByProfile,
                      int numberOfUniversitiesByProfile,
                      String nameOfUniversity) {
        this.studyProfile = studyProfile;
        this.avgExamScore = avgExamScore;
        this.numberOfStudentsByProfile = numberOfStudentsByProfile;
        this.numberOfUniversitiesByProfile = numberOfUniversitiesByProfile;
        this.namesOfUniversities = new ArrayList<>();
        namesOfUniversities.add(nameOfUniversity);
    }

    public Statistics(StudyProfile studyProfile,
                      float avgExamScore,
                      int numberOfStudentsByProfile,
                      int numberOfUniversitiesByProfile,
                      ArrayList<String> namesOfUniversities) {
        this.studyProfile = studyProfile;
        this.avgExamScore = avgExamScore;
        this.numberOfStudentsByProfile = numberOfStudentsByProfile;
        this.numberOfUniversitiesByProfile = numberOfUniversitiesByProfile;
        this.namesOfUniversities = namesOfUniversities;
    }

    public StudyProfile getStudyProfile() {
        return StudyProfile.valueOf(studyProfile.name());
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    public int getNumberOfStudentsByProfile() {
        return numberOfStudentsByProfile;
    }

    public int getNumberOfUniversitiesByProfile() {
        return numberOfUniversitiesByProfile;
    }

    public ArrayList<String> getNamesOfUniversities() {
        return new ArrayList<>(namesOfUniversities);
    }

    public Statistics setStudyProfile(String profile) {
        this.studyProfile = StudyProfile.valueOf(profile);
        return this;
    }

    public Statistics setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
        return this;
    }

    public Statistics setNumberOfStudentsByProfile(int numberOfStudentsByProfile) {
        this.numberOfStudentsByProfile = numberOfStudentsByProfile;
        return this;
    }

    public Statistics setNumberOfUniversitiesByProfile(int numberOfUniversitiesByProfile) {
        this.numberOfUniversitiesByProfile = numberOfUniversitiesByProfile;
        return this;
    }

    public Statistics setNamesOfUniversities(ArrayList<String> namesOfUniversities) {
        this.namesOfUniversities = namesOfUniversities;
        return this;
    }
}
