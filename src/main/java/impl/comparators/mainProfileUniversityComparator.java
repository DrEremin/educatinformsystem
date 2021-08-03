package impl.comparators;

import interf.universityComparator;
import impl.education.University;

public class mainProfileUniversityComparator implements universityComparator {

    public int compare(University u1, University u2) {
        return u1.getMainProfile().compareTo(u2.getMainProfile());
    }
}
