package impl.education;

import com.google.gson.annotations.SerializedName;
import impl.enums.StudyProfile;
import interf.EducationalUnit;

public class University implements EducationalUnit {

    @SerializedName("UID")
    private String id;

    @SerializedName("Full title")
    private String fullName;

    @SerializedName("Abbreviation")
    private String shortName;

    @SerializedName("Opening year")
    private int yearOfFoundation;

    @SerializedName("Profile")
    private StudyProfile mainProfile;

    public Builder builder;

    private University() {}

    public static class Builder {

        private University newUniversity;

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

    public void setBuilder(EducationalUnit educationalUnit) {
        this.builder.newUniversity = (University) educationalUnit;
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
