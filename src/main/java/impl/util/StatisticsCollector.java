package impl.util;

import java.util.ArrayList;
import java.util.Collection;
import impl.education.Statistics;
import impl.education.Student;
import impl.education.University;
import impl.enums.StudyProfile;

public class StatisticsCollector {

    private static final ArrayList<Statistics> statCollection = new ArrayList<>();

    private StatisticsCollector() {}

    private static void collectorUniversities (Collection<University> uniCollection) {

        for (StudyProfile profile : StudyProfile.values()) {

            if (uniCollection.stream().anyMatch(u -> u.getMainProfile() == profile)) {
                final Statistics statistics = new Statistics(profile);

                /**
                 * Перебор потока университетов,
                 * соответствующих очередному учебному профилю
                 */

                uniCollection.stream().filter(u -> u.getMainProfile() == profile)
                        .forEach(u -> {
                            statistics.incNumberOfUniversitiesByProfile();
                            statistics.addNameOfUniversity(u.getFullName());
                            statistics.addUniversitiesId(u.getId());
                        });
                statCollection.add(statistics);
            }
        }
    }

    private static void collectorStudents(Collection<Student> studCollection) {

        for (Statistics statistics : statCollection) {
            for (String uid : statistics.getUniversitiesId()) {

                /**
                 * Перебор потока студентов, соответствующих очередному университету
                 */

                studCollection.stream().filter(s -> s.getUniversityId().equals(uid))
                        .forEach(s -> {
                            statistics.incNumberOfStudentsByProfile();
                            statistics.accumulatorTotalScoresOfStudents(s
                                    .getAvgExamSource());
                        });
            }
            statistics.computeAvgExamScore();
        }
    }


    public static Collection<Statistics> collector(
            Collection<University> uniCollection,
            Collection<Student> studCollection) {

        collectorUniversities(uniCollection);
        collectorStudents(studCollection);

        return statCollection;
    }
}