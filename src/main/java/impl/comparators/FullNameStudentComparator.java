package impl.comparators;

import interf.StudentComparator;
import impl.education.Student;
import org.apache.commons.lang3.StringUtils;

public class FullNameStudentComparator implements StudentComparator {

    @Override
    public int compare(Student s1, Student s2) {
        return StringUtils.compare(s1.getFullName(), s2.getFullName());
    }
}

