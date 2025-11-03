import java.util.ArrayList;
import java.util.List;

public class Department {
    String departmentId;
    String departName;
    List<Course> listOfCourses;
    List<Student> listOfStudents;
    List<Instructor> listOfInstructors;

    public Department(String departmentId, String departName) {
        this.departmentId = departmentId;
        this.departName = departName;
        this.listOfCourses = new ArrayList<>();
        this.listOfStudents = new ArrayList<>();
        this.listOfInstructors = new ArrayList<>();
    }

    public void addCourse(Course course) {
        listOfCourses.add(course);
    }

    public void removeCourse(Course course) {
        listOfCourses.remove(course);
    }

    public void addStudent(Student student) {
        listOfStudents.add(student);
    }

    public void removeStudent(Student student) {
        listOfStudents.remove(student);
    }

    public void addInstructor(Instructor instructor) {
        listOfInstructors.add(instructor);
    }

    public void removeInstructor(Instructor instructor) {
        listOfInstructors.remove(instructor);
    }

    public void displayDepartmentDetails() {
        System.out.println("Department ID: " + departmentId);
        System.out.println("Department Name: " + departName);
        System.out.println("Total Courses: " + listOfCourses.size());
        System.out.println("Total Students: " + listOfStudents.size());
        System.out.println("Total Instructors: " + listOfInstructors.size());
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    public List<Course> getListOfCourses() {
        return listOfCourses;
    }

    public List<Student> getListOfStudents() {
        return listOfStudents;
    }

    public List<Instructor> getListOfInstructors() {
        return listOfInstructors;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId='" + departmentId + '\'' +
                ", departName='" + departName + '\'' +
                ", courses=" + listOfCourses.size() +
                ", students=" + listOfStudents.size() +
                ", instructors=" + listOfInstructors.size() +
                '}';
    }
}
