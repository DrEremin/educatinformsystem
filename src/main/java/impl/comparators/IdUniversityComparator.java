package impl.comparators;

import interf.UniversityComparator;
import impl.education.University;
import org.apache.commons.lang3.StringUtils;

public class IdUniversityComparator implements UniversityComparator {

    public int compare(University u1, University u2) {
        return StringUtils.compare(u1.getId(), u2.getId());
    }
}
