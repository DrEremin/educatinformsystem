package impl.comparators;

import interf.StudentComparator;
import impl.education.Student;

public class CurrentCourseNumberStudentComparator implements StudentComparator {

    public int compare(Student s1, Student s2) {
        return Integer.compare(s1.getCurrentCourseNumber(), s2.getCurrentCourseNumber());
    }
}
