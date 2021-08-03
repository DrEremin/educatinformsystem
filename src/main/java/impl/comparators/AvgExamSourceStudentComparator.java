package impl.comparators;

import interf.StudentComparator;
import impl.education.Student;

public class AvgExamSourceStudentComparator implements StudentComparator {

    public int compare(Student s1, Student s2) {
        return Float.compare(s1.getAvgExamSource(), s2.getAvgExamSource());
    }
}
