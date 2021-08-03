package impl.comparators;

import interf.studentComparator;
import impl.education.Student;
import org.apache.commons.lang3.StringUtils;

public class fullNameStudentComparator implements studentComparator {

    public int compare(Student s1, Student s2) {
        return StringUtils.compare(s1.getFullName(), s2.getFullName());
    }
}

