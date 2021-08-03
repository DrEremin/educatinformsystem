package impl.util;

import impl.enums.ComparatorsOfStudent;
import impl.enums.ComparatorsOfUniversity;
import interf.StudentComparator;
import interf.UniversityComparator;

public class ComparatorSelector {

    private ComparatorSelector() {}

    public static StudentComparator getStudentComparator(
            ComparatorsOfStudent comparatorsOfStudent) {

        return comparatorsOfStudent.getComparator();
    }

    public static UniversityComparator getUniversityComparator(
            ComparatorsOfUniversity comparatorsOfUniversity) {

        return comparatorsOfUniversity.getComparator();
    }
}
