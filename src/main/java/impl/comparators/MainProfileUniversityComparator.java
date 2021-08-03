package impl.comparators;

import interf.UniversityComparator;
import impl.education.University;

public class MainProfileUniversityComparator implements UniversityComparator {

    @Override
    public int compare(University u1, University u2) {
        return u1.getMainProfile().compareTo(u2.getMainProfile());
    }
}
