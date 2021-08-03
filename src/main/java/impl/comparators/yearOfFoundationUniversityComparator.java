package impl.comparators;

import interf.universityComparator;
import impl.education.University;

public class yearOfFoundationUniversityComparator implements universityComparator {

    public int compare(University u1, University u2) {
        return Integer.compare(u1.getYearOfFoundation(), u2.getYearOfFoundation());
    }
}
