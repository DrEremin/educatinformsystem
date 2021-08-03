package impl.comparators;

import interf.studentComparator;
import impl.education.Student;

public class currentCourseNumberStudentComparator implements studentComparator {

    public int compare(Student s1, Student s2) {
        return Integer.compare(s1.getCurrentCourseNumber(), s2.getCurrentCourseNumber());
    }
}
