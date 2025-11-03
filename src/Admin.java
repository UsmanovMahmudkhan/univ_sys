import java.util.List;

public class Admin {
    String adminId;
    String username;
    String password;

    public Admin(String adminId, String username, String password) {
        this.adminId = adminId;
        this.username = username;
        this.password = password;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addStudent(Department department, Student student) {
        department.addStudent(student);
        System.out.println(ConsoleColor.LIME_GREEN.apply("Added student: " + student.getStudentName()));
    }

    public void removeStudent(Department department, Student student) {
        department.removeStudent(student);
        System.out.println(ConsoleColor.ELECTRIC_PURPLE.apply("Removed student: " + student.getStudentName()));
    }

    public void addInstructor(Department department, Instructor instructor) {
        department.addInstructor(instructor);
        System.out.println(ConsoleColor.LIME_GREEN.apply("Added instructor: " + instructor.getInstructorName()));
    }

    public void removeInstructor(Department department, Instructor instructor) {
        department.removeInstructor(instructor);
        System.out.println(ConsoleColor.CYBER_YELLOW.apply("Removed instructor: " + instructor.getInstructorName()));
    }

    public void addCourse(Department department, Course course) {
        department.addCourse(course);
        System.out.println(ConsoleColor.LIME_GREEN.apply("Added course: " + course.getCourseName()));
    }

    public void removeCourse(Department department, Course course) {
        department.removeCourse(course);
        System.out.println(ConsoleColor.CYBER_YELLOW.apply("Removed course: " + course.getCourseName()));
    }

    public void viewDepartmentSummary(Department department) {
        System.out.println(ConsoleColor.GOLD.apply("---- Department Summary ----"));
        department.displayDepartmentDetails();
        System.out.println(ConsoleColor.GOLD.apply("-----------------------------"));
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId='" + adminId + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
