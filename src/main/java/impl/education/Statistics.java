package impl.education;

import impl.enums.StudyProfile;
import java.util.ArrayList;

public class Statistics {

    private StudyProfile studyProfile;
    private float avgExamScore;
    private float totalScoresOfStudents;
    private int numberOfStudentsByProfile;
    private int numberOfUniversitiesByProfile;
    private ArrayList<String> namesOfUniversities;
    private ArrayList<String> universitiesId;

    public Statistics(StudyProfile studyProfile) {
        this.studyProfile = studyProfile;
        avgExamScore = 0.0f;
        totalScoresOfStudents = 0.0f;
        numberOfStudentsByProfile = 0;
        numberOfUniversitiesByProfile = 0;
        namesOfUniversities = new ArrayList<>();
        universitiesId = new ArrayList<>();
    }

    /**
     * Methods
     */

    public void incNumberOfUniversitiesByProfile() {
        numberOfUniversitiesByProfile++;
    }

    public void incNumberOfStudentsByProfile() {
        numberOfStudentsByProfile++;
    }

    public void accumulatorTotalScoresOfStudents(float scoresOfStudent) {
        totalScoresOfStudents += scoresOfStudent;
    }

    public void computeAvgExamScore() {
        if (numberOfStudentsByProfile != 0) {
            avgExamScore = totalScoresOfStudents / numberOfStudentsByProfile;
        }
    }

    public void addNameOfUniversity(String universityName) {
        namesOfUniversities.add(universityName);
    }

    public void addUniversitiesId(String universityId) {
        universitiesId.add(universityId);
    }

    /**
     * Getters
     */

    public StudyProfile getStudyProfile() {
        return StudyProfile.valueOf(studyProfile.name());
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    public float getTotalScoresOfStudents() {
        return totalScoresOfStudents;
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

    public ArrayList<String> getUniversitiesId() {
        return new ArrayList<>(universitiesId);
    }

    /**
     * Setters
     */

    public void setStudyProfile(String profile) {
        this.studyProfile = StudyProfile.valueOf(profile);
    }

    public void setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
    }

    public void setTotalScoresOfStudents(float totalScoresOfStudents) {
        this.totalScoresOfStudents = totalScoresOfStudents;
    }

    public void setNumberOfStudentsByProfile(int numberOfStudentsByProfile) {
        this.numberOfStudentsByProfile = numberOfStudentsByProfile;
    }

    public void setNumberOfUniversitiesByProfile(int numberOfUniversitiesByProfile) {
        this.numberOfUniversitiesByProfile = numberOfUniversitiesByProfile;
    }

    public void setNamesOfUniversities(ArrayList<String> namesOfUniversities) {
        this.namesOfUniversities = namesOfUniversities;
    }

    public void setIdOfUniversities(ArrayList<String> universitiesId) {
        this.universitiesId = universitiesId;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("---------------------------------");
        stringBuilder.append("\nProfile: ");
        stringBuilder.append(studyProfile.getProfileName());
        stringBuilder.append("\navgExamScore: ");
        stringBuilder.append(avgExamScore);
        stringBuilder.append("\nnumberOfStudentsByProfile: ");
        stringBuilder.append(numberOfStudentsByProfile);
        stringBuilder.append("\nnumberOfUniversitiesByProfile: ");
        stringBuilder.append(numberOfUniversitiesByProfile);
        stringBuilder.append("\nUniversities:");
        for (String string : namesOfUniversities) {
            stringBuilder.append("\n");
            stringBuilder.append(string);
        }
        stringBuilder.append("\n---------------------------------");
        return stringBuilder.toString();
    }

}
