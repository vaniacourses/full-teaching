package com.fullteaching.backend.coursedetails;

import com.fullteaching.backend.course.Course;
import com.fullteaching.backend.filegroup.FileGroup;
import com.fullteaching.backend.forum.Forum;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;

public class courseDetailsTest {

    @Test
    public void createCourseDetails() {
        CourseDetails courseDetails = new CourseDetails();
        Assertions.assertEquals(0, courseDetails.getId());
    }

    @Test
    public void createCourseDetailsWithCourse() {
        Course course = mock(Course.class);
        Mockito.when(course.getTitle()).thenReturn("title test");
        CourseDetails courseDetails = new CourseDetails(course);
        Assertions.assertEquals("title test", courseDetails.getCourse().getTitle());
        Assertions.assertEquals(course, courseDetails.getCourse());
    }


    @Test
    public void testId() {
        CourseDetails courseDetails = new CourseDetails();
        courseDetails.setId(3);
        Assertions.assertEquals(3, courseDetails.getId());
    }

    @Test
    public void testInfo() {
        CourseDetails courseDetails = new CourseDetails();
        courseDetails.setInfo("info test");
        Assertions.assertEquals("info test", courseDetails.getInfo());
    }

    @Test
    public void testForum() {
        Forum forum = mock(Forum.class);
        Mockito.when(forum.isActivated()).thenReturn(true);
        CourseDetails courseDetails = new CourseDetails();
        courseDetails.setForum(forum);
        Assertions.assertEquals(true, courseDetails.getForum().isActivated());
    }

    @Test
    public void testFiles() {
        CourseDetails courseDetails = new CourseDetails();
        FileGroup fileGroup = mock(FileGroup.class);
        Mockito.when(fileGroup.getTitle()).thenReturn("file group test");
        List<FileGroup> listFileGroup = new ArrayList<FileGroup>();
        listFileGroup.add(fileGroup);
        courseDetails.setFiles(listFileGroup);
        Assertions.assertEquals(listFileGroup, courseDetails.getFiles());
    }

    @Test
    public void testCourse() {
        Course course = mock(Course.class);
        Mockito.when(course.getTitle()).thenReturn("course test");
        CourseDetails courseDetails = new CourseDetails();
        courseDetails.setCourse(course);
        Assertions.assertEquals("course test", courseDetails.getCourse().getTitle());
    }
    
    @Test
    public void testeCourseNull() {
        CourseDetails courseDetails = new CourseDetails();
        Assertions.assertFalse(courseDetails.equals(null));
    }
} 