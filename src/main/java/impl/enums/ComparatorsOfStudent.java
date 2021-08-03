package impl.enums;

import impl.comparators.AvgExamSourceStudentComparator;
import impl.comparators.CurrentCourseNumberStudentComparator;
import impl.comparators.FullNameStudentComparator;
import impl.comparators.UniversityIdStudentComparator;
import interf.StudentComparator;

public enum ComparatorsOfStudent {
    FULL_NAME (new FullNameStudentComparator()),
    UNIVERSITY_ID (new UniversityIdStudentComparator()),
    CURRENT_COURSE_NUMBER (new CurrentCourseNumberStudentComparator()),
    AVG_EXAM_SOURCE (new AvgExamSourceStudentComparator());

    private StudentComparator comparator;

    ComparatorsOfStudent(StudentComparator comparator) {
        this.comparator = comparator;
    }

    public StudentComparator getComparator() {
        return comparator;
    }
}

