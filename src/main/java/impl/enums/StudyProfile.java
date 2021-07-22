package impl.enums;

public enum StudyProfile {

    MEDICINE ("Медицина"),
    LEGAL_SCIENCE ("Юриспруденция"),
    ECONOMICS ("Экономика"),
    JOURNALISM ("Журналистика"),
    THEATER_ARTS ("Театральное искусство"),
    MANAGEMENT ("Управление"),
    COMPUTER_SCIENCES ("Компьютерные науки");

    private String profileName;

    StudyProfile() {

    }

    StudyProfile(String profileName) {
        this.profileName = profileName;
    }

}
