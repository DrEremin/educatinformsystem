package impl.education;

import impl.enums.StudyProfile;

public class University {

    private String id;
    private String fullName;
    private String shortName;
    private int yearOfFoundation;
    private StudyProfile mainProfile;

    University(String id,
               String fullName,
               String shortName,
               int yearOfFoundation,
               StudyProfile mainProfile) {

        this.id = id;
        this.fullName = fullName;
        this.shortName = shortName;
        this.yearOfFoundation = yearOfFoundation;
        this.mainProfile = mainProfile;
    }
}
