import java.util.ArrayList;

public class Student {
    String studentId;
    String studentName;
    String studentEmail;
    String studentDepart;
    ArrayList<Course> enrolledCourses;

    public Student(String studentId, String studentName, String studentEmail, String studentDepart) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentEmail = studentEmail;
        this.studentDepart = studentDepart;
        this.enrolledCourses = new ArrayList<>();
    }

    public Student() {
        this.enrolledCourses = new ArrayList<>();
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentDepart() {
        return studentDepart;
    }

    public void setStudentDepart(String studentDepart) {
        this.studentDepart = studentDepart;
    }

    public ArrayList<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(ArrayList<Course> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    public void enroll(Course course) {
        if (!enrolledCourses.contains(course)) {
            enrolledCourses.add(course);
            System.out.println(ConsoleColor.LIME_GREEN.apply("Enrolled in: " + course.getCourseName()));
        } else {
            System.out.println(ConsoleColor.LIME_GREEN.apply("Already enrolled in this course"));
        }
    }

    public void dropCourse(String courseId) {
        Course toRemove = null;
        for (Course c : enrolledCourses) {
            if (c.getCourseId().equals(courseId)) {
                toRemove = c;
                break;
            }
        }
        if (toRemove != null) {
            enrolledCourses.remove(toRemove);
            System.out.println(ConsoleColor.NEON_BLUE.apply("Dropped course: " + toRemove.getCourseName()));
        } else {
            System.out.println(ConsoleColor.TURQUOISE.apply("Course not found"));
        }
    }

    public void viewCourses() {
        if (enrolledCourses.isEmpty()) {
            System.out.println(ConsoleColor.HOT_PINK.apply("No enrolled courses"));
        } else {
            System.out.println(ConsoleColor.GOLD.apply("Enrolled Courses:"));
            for (Course c : enrolledCourses) {
                System.out.println(ConsoleColor.GOLD.apply(c.toString()));
            }
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", studentEmail='" + studentEmail + '\'' +
                ", studentDepart='" + studentDepart + '\'' +
                ", enrolledCourses=" + enrolledCourses.size() +
                '}';
    }
}
