package com.fullteaching.backend.course;

import com.fullteaching.backend.coursedetails.CourseDetails;
import com.fullteaching.backend.session.Session;
import com.fullteaching.backend.user.User;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.mock;

public class CourseTest {


    @Test
    public void createCourse() {
        Course course = new Course();
        Assertions.assertEquals(0, course.getId());
    }


    @Test
    public void createCourseWithTeacher() {
        User teacher = mock(User.class);
        String title = "title test";
        String image = "image test";
        Course course = new Course(title, image, teacher);
        Assertions.assertEquals("title test", course.getTitle());
        Assertions.assertEquals("image test", course.getImage());
    }


    @Test
    public void createCourseWithTeacherAndCourseDetails() {
        User teacher = mock(User.class);
        CourseDetails courseDetails = mock(CourseDetails.class);
        Mockito.when(courseDetails.getInfo()).thenReturn("info test");
        String title = "title test";
        String image = "image test";
        Course course = new Course(title, image, teacher, courseDetails);
        Assertions.assertEquals("title test", course.getTitle());
        Assertions.assertEquals("image test", course.getImage());
        Assertions.assertEquals("info test", courseDetails.getInfo());
    }

    @Test
    public void testId() {
        Course course = new Course();
        course.setId(3);
        Assertions.assertEquals(3, course.getId());
    }

    @Test
    public void testTitle() {
        Course course = new Course();
        course.setTitle("title test");
        Assertions.assertEquals("title test", course.getTitle());
    }

    @Test
    public void testImage() {
        Course course = new Course();
        course.setImage("image test");
        Assertions.assertEquals("image test", course.getImage());
    }

    @Test
    public void testTeacher() {
    	Course course = new Course();
        User teacher = mock(User.class);
        Mockito.when(teacher.getName()).thenReturn("Teacher");
        Assertions.assertEquals("Teacher", teacher.getName());
        course.setTeacher(teacher);
        Assertions.assertEquals(teacher, course.getTeacher());
    }


    @Test
    public void testCourseDetails() {
        CourseDetails courseDetails = mock(CourseDetails.class);
        Mockito.when(courseDetails.getInfo()).thenReturn("info test");
        Course course = new Course();
        course.setCourseDetails(courseDetails);
        Assertions.assertEquals("info test", course.getCourseDetails().getInfo());
    }

    @Test
    public void testAttenders() {
        User teacher = mock(User.class);
        Mockito.when(teacher.getName()).thenReturn("Teacher");
        Course course = new Course();
        Set<User> user = new HashSet<User>();
        user.add(teacher);
        course.setAttenders(user);
        Assertions.assertEquals(user, course.getAttenders());
    }

    @Test
    public void testSessions() {
        Session session = mock(Session.class);
        Mockito.when(session.getTitle()).thenReturn("Session");
        Course course = new Course();
        Set<Session> sessionList = new HashSet<Session>();
        sessionList.add(session);
        course.setSessions(sessionList);
        Assertions.assertEquals(sessionList, course.getSessions());
    }
    
    @Test
    public void testCourseNull() {
        Course course = new Course();
        Assertions.assertFalse(course.equals(null));
    }

    @Test
    public void testSameInstance() {
        User teacher = Mockito.mock(User.class);
        Course anotherCourse = new Course("Title test", " image test", teacher);
        Assertions.assertTrue(anotherCourse.equals(anotherCourse));
    }

    @Test
    public void testEqualsDifferentClasses() {
        Course course = new Course();
        User teacher = Mockito.mock(User.class);
        Assertions.assertFalse(course.equals(teacher));
    }
    
    @Test
    public void testEquals() {
        Course course = new Course();
        Course anotherCourse = new Course();
        Course differentCourse = new Course();
        course.setId(1);
        anotherCourse.setId(1);
        differentCourse.setId(2);
        Assertions.assertTrue(course.equals(anotherCourse) && !course.equals(differentCourse));
    }
} 