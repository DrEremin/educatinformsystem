package impl.comparators;

import interf.studentComparator;
import impl.education.Student;
import org.apache.commons.lang3.StringUtils;

public class universityIdStudentComparator implements studentComparator {

    public int compare(Student s1, Student s2) {
        return StringUtils.compare(s1.getUniversityId(), s2.getUniversityId());
    }
}
