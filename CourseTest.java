package Q2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {
    Course course;

    @BeforeEach
    void setUp() {
        course = new Course();
    }

    @AfterEach
    void tearDown() {
        course = null;
    }

    @Test
    void testId() {
        int expectedId = 1;
        course.id = expectedId;
        assertEquals(expectedId, course.id);
    }

    @Test
    void testPre() {
        course.pre = Arrays.asList(1, 2, 3);
        assertEquals(3, course.pre.size());
        assertTrue(course.pre.contains(1));
        assertTrue(course.pre.contains(2));
        assertTrue(course.pre.contains(3));
    }
}
