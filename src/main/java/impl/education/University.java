package impl.education;

import impl.enums.StudyProfile;

public class University {

    private String id;
    private String fullName;
    private String shortName;
    private int yearOfFoundation;
    private StudyProfile mainProfile;
    public Builder builder;

    private University() {}

    public static class Builder {

        private final University newUniversity;

        public Builder() {
            newUniversity = new University();
        }

        public Builder setId(String id) {
            newUniversity.id = id;
            return this;
        }

        public Builder setFullName(String fullName) {
            newUniversity.fullName = fullName;
            return this;
        }

        public Builder setShortName(String shortName) {
            newUniversity.shortName = shortName;
            return this;
        }

        public Builder setYearOfFoundation(int yearOfFoundation) {
            newUniversity.yearOfFoundation = yearOfFoundation;
            return this;
        }

        public Builder setMainProfile(String profile) {
            newUniversity.mainProfile = StudyProfile.valueOf(profile);
            return this;
        }

        public University build() {
            newUniversity.builder = this;
            return newUniversity;
        }
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public StudyProfile getMainProfile() {
        return mainProfile;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("---------------------------------\n");
        stringBuilder.append(fullName);
        stringBuilder.append("\n(");
        stringBuilder.append(shortName);
        stringBuilder.append(")");
        stringBuilder.append("\nId of university: ");
        stringBuilder.append(id);
        stringBuilder.append("\nYear Of foundation: ");
        stringBuilder.append(yearOfFoundation);
        stringBuilder.append("\nMain profile: ");
        stringBuilder.append(mainProfile.getProfileName());
        stringBuilder.append("\n---------------------------------");
        return stringBuilder.toString();
    }
}
