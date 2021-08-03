package impl.comparators;

import interf.studentComparator;
import impl.education.Student;

public class avgExamSourceStudentComparator implements studentComparator {

    public int compare(Student s1, Student s2) {
        return Float.compare(s1.getAvgExamSource(), s2.getAvgExamSource());
    }
}
