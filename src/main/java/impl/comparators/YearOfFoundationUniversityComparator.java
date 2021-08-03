package impl.comparators;

import interf.UniversityComparator;
import impl.education.University;

public class YearOfFoundationUniversityComparator implements UniversityComparator {

    @Override
    public int compare(University u1, University u2) {
        return Integer.compare(u1.getYearOfFoundation(), u2.getYearOfFoundation());
    }
}
