package impl.comparators;

import interf.UniversityComparator;
import impl.education.University;
import org.apache.commons.lang3.StringUtils;

public class ShortNameUniversityComparator implements UniversityComparator {

    public int compare(University u1, University u2) {
        return StringUtils.compare(u1.getShortName(), u2.getShortName());
    }
}
