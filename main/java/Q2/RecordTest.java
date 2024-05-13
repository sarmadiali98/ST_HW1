package Q2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RecordTest {

    @Test
    void testHasPassedPreWithNoCoursePrerequisites() {
        List<Record> records = new ArrayList<>();
        Course course = new Course();
        course.id = 1;
        course.pre = new ArrayList<>();
        assertTrue(Record.hasPassedPre(records, course));
    }

    @Test
    void testHasPassedPreWithNoRecords() {
        List<Record> records = new ArrayList<>();
        Course course = new Course();
        course.id = 1;
        course.pre = Arrays.asList(2, 3);
        assertFalse(Record.hasPassedPre(records, course));
    }

    @Test
    void testHasPassedPreWithPassedPrerequisites() {
        List<Record> records = new ArrayList<>();
        Record record1 = new Record();
        record1.termId = 1;
        record1.courseId = 2;
        record1.grade = 15;
        record1.isMehman = false;
        records.add(record1);
        
        Record record2 = new Record();
        record2.termId = 1;
        record2.courseId = 3;
        record2.grade = 12;
        record2.isMehman = false;
        records.add(record2);
        
        Course course = new Course();
        course.id = 1;
        course.pre = Arrays.asList(2, 3);
        assertTrue(Record.hasPassedPre(records, course));
    }

    @Test
    void testHasPassedPreWithFailedPrerequisites() {
        List<Record> records = new ArrayList<>();
        Record record1 = new Record();
        record1.termId = 1;
        record1.courseId = 2;
        record1.grade = 8;
        record1.isMehman = false;
        records.add(record1);

        Record record2 = new Record();
        record2.termId = 1;
        record2.courseId = 3;
        record2.grade = 10;
        record2.isMehman = false;
        records.add(record2);

        Course course = new Course();
        course.id = 1;
        course.pre = Arrays.asList(2, 3);
        assertFalse(Record.hasPassedPre(records, course));
    }

    @Test
    void testHasPassedPreWithMixedPrerequisites() {
        List<Record> records = new ArrayList<>();
        Record record1 = new Record();
        record1.termId = 1;
        record1.courseId = 2;
        record1.grade = 15;
        record1.isMehman = false;
        records.add(record1);

        Record record2 = new Record();
        record2.termId = 1;
        record2.courseId = 3;
        record2.grade = 8;
        record2.isMehman = false;
        records.add(record2);

        Record record3 = new Record();
        record3.termId = 1;
        record3.courseId = 4;
        record3.grade = 12;
        record3.isMehman = true;
        records.add(record3);

        Course course = new Course();
        course.id = 1;
        course.pre = Arrays.asList(2, 3, 4);
        assertFalse(Record.hasPassedPre(records, course));
    }

    @Test
    void testHasPassedPreWithMehmanStudents() {
        List<Record> records = new ArrayList<>();
        Record record1 = new Record();
        record1.termId = 1;
        record1.courseId = 2;
        record1.grade = 10;
        record1.isMehman = false;
        records.add(record1);

        Record record2 = new Record();
        record2.termId = 1;
        record2.courseId = 3;
        record2.grade = 14;
        record2.isMehman = true;
        records.add(record2);

        Course course = new Course();
        course.id = 1;
        course.pre = Arrays.asList(2, 3);
        assertTrue(Record.hasPassedPre(records, course));
    }

    @Test
    void testHasPassedPreWithDuplicatePrerequisites() {
        List<Record> records = new ArrayList<>();
        Record record1 = new Record();
        record1.termId = 1;
        record1.courseId = 2;
        record1.grade = 15;
        record1.isMehman = false;
        records.add(record1);

        Record record2 = new Record();
        record2.termId = 1;
        record2.courseId = 3;
        record2.grade = 8;
        record2.isMehman = false;
        records.add(record2);

        Course course = new Course();
        course.id = 1;
        course.pre = Arrays.asList(2, 2, 3);
        assertFalse(Record.hasPassedPre(records, course));
    }

    @Test
    void testHasPassedPreWithNonMehmanStudentGradeBetween10And12() {
        List<Record> records = new ArrayList<>();
        Record record1 = new Record();
        record1.termId = 1;
        record1.courseId = 2;
        record1.grade = 11;
        record1.isMehman = false;
        records.add(record1);

        Course course = new Course();
        course.id = 1;
        course.pre = Arrays.asList(2);
        assertTrue(Record.hasPassedPre(records, course));
    }

    @Test
    void testHasPassedPreWithNonMehmanStudentGradeBelow10() {
        List<Record> records = new ArrayList<>();
        Record record1 = new Record();
        record1.termId = 1;
        record1.courseId = 2;
        record1.grade = 9;
        record1.isMehman = false;
        records.add(record1);

        Course course = new Course();
        course.id = 1;
        course.pre = Arrays.asList(2);
        assertFalse(Record.hasPassedPre(records, course));
    }

    @Test
    void testHasPassedPreWithMehmanStudentGradeBelow12() {
        List<Record> records = new ArrayList<>();
        Record record1 = new Record();
        record1.termId = 1;
        record1.courseId = 2;
        record1.grade = 11;
        record1.isMehman = true;
        records.add(record1);

        Course course = new Course();
        course.id = 1;
        course.pre = Arrays.asList(2);
        assertFalse(Record.hasPassedPre(records, course));
    }

    @Test
    void testHasPassedPreWithMehmanStudentGradeAtLeast12() {
        List<Record> records = new ArrayList<>();
        Record record1 = new Record();
        record1.termId = 1;
        record1.courseId = 2;
        record1.grade = 12;
        record1.isMehman = true;
        records.add(record1);

        Course course = new Course();
        course.id = 1;
        course.pre = Arrays.asList(2);
        assertTrue(Record.hasPassedPre(records, course));
    }

    @Test
    void testHasPassedPreWithNegativeGrade() {
        List<Record> records = new ArrayList<>();
        Record record1 = new Record();
        record1.termId = 1;
        record1.courseId = 2;
        record1.grade = -5;
        record1.isMehman = false;
        records.add(record1);

        Course course = new Course();
        course.id = 1;
        course.pre = Arrays.asList(2);

        assertThrows(IllegalArgumentException.class, () -> Record.hasPassedPre(records, course));
    }

    @Test
    void testHasPassedPreWithGradeAbove20() {
        List<Record> records = new ArrayList<>();
        Record record1 = new Record();
        record1.termId = 1;
        record1.courseId = 2;
        record1.grade = 25;
        record1.isMehman = false;
        records.add(record1);

        Course course = new Course();
        course.id = 1;
        course.pre = Arrays.asList(2);

        assertThrows(IllegalArgumentException.class, () -> Record.hasPassedPre(records, course));
    }
}