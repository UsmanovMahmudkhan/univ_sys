import java.util.ArrayList;
import java.util.List;

public class Course {
    String courseId;
    String courseName;
    int credits;
    Instructor instructor;
    List<Student> enrolledStudents;

    public Course(String courseId, String courseName, int credits, Instructor instructor) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.credits = credits;
        this.instructor = instructor;
        this.enrolledStudents = new ArrayList<>();
    }

    public void assignInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
    }

    public void removeStudent(Student student) {
        enrolledStudents.remove(student);
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void displayCourseInfo() {
        System.out.println("Course ID: " + courseId);
        System.out.println("Course Name: " + courseName);
        System.out.println("Credits: " + credits);
        System.out.println("Instructor: " + (instructor != null ? instructor.getInstructorName() : "Not Assigned"));
        System.out.println("Enrolled Students: " + enrolledStudents.size());
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", credits=" + credits +
                ", instructor=" + instructor +
                ", enrolledStudents=" + enrolledStudents.size() +
                '}';
    }
}
