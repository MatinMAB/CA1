package requisite;

import java.util.List;

public class Main {
    public static boolean hasPassedPre(List<Record> rec, Course course) {
        for (int i = 0; i < course.pre().size(); i++) {
            boolean prePassed = false;
            for (Record record : rec) {
                if (record.courseId() != course.pre().get(i))
                    continue;
                if (record.grade() >= 10 &&
                        (!record.isMehman() || record.grade() >= 12)) {
                    prePassed = true;
                    break;
                }
            }
            if (!prePassed)
                return false;
        }
        return true;
    }
}
