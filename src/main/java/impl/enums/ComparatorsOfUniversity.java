package impl.enums;

import impl.comparators.*;
import interf.StudentComparator;
import interf.UniversityComparator;

public enum ComparatorsOfUniversity {
    ID (new IdUniversityComparator()),
    FULL_NAME (new FullNameUniversityComparator()),
    SHORT_NAME (new ShortNameUniversityComparator()),
    YEAR_OF_FOUNDATION (new YearOfFoundationUniversityComparator()),
    MAIN_PROFILE (new MainProfileUniversityComparator());

    private UniversityComparator comparator;

    ComparatorsOfUniversity(UniversityComparator comparator) {
        this.comparator = comparator;
    }

    public UniversityComparator getComparator() {
        return comparator;
    }
}
