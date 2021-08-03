package impl.comparators;

import interf.universityComparator;
import impl.education.University;
import org.apache.commons.lang3.StringUtils;

public class shortNameUniversityComparator implements universityComparator {

    public int compare(University u1, University u2) {
        return StringUtils.compare(u1.getShortName(), u2.getShortName());
    }
}
