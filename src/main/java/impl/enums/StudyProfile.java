package impl.enums;

public enum StudyProfile {

    MEDICINE ("Медицина"),
    LEGAL_SCIENCE ("Юриспруденция"),
    ECONOMICS ("Экономика"),
    JOURNALISM ("Журналистика"),
    THEATER_ARTS ("Театральное искусство"),
    MANAGEMENT ("Управление"),
    COMPUTER_SCIENCES ("Компьютерные науки"),
    ARCHITECTURE ("Архитектура"),
    MAX_BOUND ("Предел перечисления");

    private String profileName;

    StudyProfile(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileName() {
        return profileName;
    }
}
