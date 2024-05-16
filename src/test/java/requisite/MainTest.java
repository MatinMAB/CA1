package requisite;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    void throwExceptionIfCourseIsNull() {
        //Arrange
        Course course = null;
        var records = List.<Record>of();
        //Assert
        assertThrows(NullPointerException.class, () -> Main.hasPassedPre(records, course));
    }

    @Test
    void throwExceptionIfCoursePreIsNull() {
        //Arrange
        Course course = new Course(0, null);
        var records = List.<Record>of();
        //Assert
        assertThrows(NullPointerException.class, () -> Main.hasPassedPre(records, course));
    }
    @Test
    void throwExceptionIfRecordsIsNull() {
        //Arrange
        Course course = new Course(0, List.of(1));
        List<Record> records = null;
        //Assert
        assertThrows(NullPointerException.class, () -> Main.hasPassedPre(records, course));
    }

    @Test
    void returnTrueIfCourseHasNoPreRequisite() {
        //Arrange
        var course = new Course(0, List.of());
        var records = List.<Record>of();
        //Act
        var actual = Main.hasPassedPre(records, course);
        //Assert
        assertTrue(actual);
    }

    @Test
    void returnFalseIfNotPassed() {
        //Arrange
        var course = new Course(0, List.of(1));
        var records = List.<Record>of();
        //Act
        var actual = Main.hasPassedPre(records, course);
        //Assert
        assertFalse(actual);
    }

    @Test
    void returnTrueIfCourseHasPreRequisiteAndTakeAndItPassed() {
        //Arrange
        var course = new Course(0, List.of(1));
        var records = List.of(new Record(1,1,10,false));
        //Act
        var actual = Main.hasPassedPre(records, course);
        //Assert
        assertTrue(actual);
    }

    @Test
    void returnTrueIfCourseHasPreRequisiteAndTakeAndItFailed() {
        //Arrange
        var course = new Course(0, List.of(1));
        var records = List.of(new Record(1,1,9.5,false));
        //Act
        var actual = Main.hasPassedPre(records, course);
        //Assert
        assertFalse(actual);
    }

    @Test
    void returnTrueIfCourseHasPreRequisiteAndTakeAndItPassedMehman() {
        //Arrange
        var course = new Course(0, List.of(1));
        var records = List.of(new Record(1,1,12,true));
        //Act
        var actual = Main.hasPassedPre(records, course);
        //Assert
        assertTrue(actual);
    }

    @Test
    void returnTrueIfCourseHasPreRequisiteAndTakeAndItFailedMehman() {
        //Arrange
        var course = new Course(0, List.of(1));
        var records = List.of(new Record(1,1,11.5,true));
        //Act
        var actual = Main.hasPassedPre(records, course);
        //Assert
        assertFalse(actual);
    }

    @Test
    void returnTrueIfCourseHasPreRequisiteAndPassedInSecondAttempt() {
        //Arrange
        var course = new Course(0, List.of(1));
        var records = List.of(
                new Record(1,1,9,false),
                new Record(1,1,10,false)
        );
        //Act
        var actual = Main.hasPassedPre(records, course);
        //Assert
        assertTrue(actual);
    }

    @Test
    void returnTrueIfCourseHasSomePreRequisiteAndAllPassed() {
        //Arrange
        var course = new Course(0, List.of(1,2,3));
        var records = List.of(
                new Record(1,1,10,false),
                new Record(1,2,10,false),
                new Record(1,3,10,false)
        );
        //Act
        var actual = Main.hasPassedPre(records, course);
        //Assert
        assertTrue(actual);
    }

    @Test
    void returnTrueIfCourseHasSomePreRequisiteAndOneFailed() {
        //Arrange
        var course = new Course(0, List.of(1,2,3));
        var records = List.of(
                new Record(1,1,10,false),
                new Record(1,2,9.5,false),
                new Record(1,3,10,false)
        );
        //Act
        var actual = Main.hasPassedPre(records, course);
        //Assert
        assertFalse(actual);
    }
}