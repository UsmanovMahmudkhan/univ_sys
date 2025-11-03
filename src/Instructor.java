import java.util.ArrayList;

public class Instructor {
    String instructorId;
    String instructorName;
    String insEmail;
    String insDepartment;
    ArrayList<Course> assignedCourses;

    public Instructor(String instructorId, String instructorName, String insEmail, String insDepartment) {
        this.instructorId = instructorId;
        this.instructorName = instructorName;
        this.insEmail = insEmail;
        this.insDepartment = insDepartment;
        this.assignedCourses = new ArrayList<>();
    }

    public Instructor() {
        this.assignedCourses = new ArrayList<>();
    }

    public String getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(String instructorId) {
        this.instructorId = instructorId;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public String getInsEmail() {
        return insEmail;
    }

    public void setInsEmail(String insEmail) {
        this.insEmail = insEmail;
    }

    public String getInsDepartment() {
        return insDepartment;
    }

    public void setInsDepartment(String insDepartment) {
        this.insDepartment = insDepartment;
    }

    public ArrayList<Course> getAssignedCourses() {
        return assignedCourses;
    }

    public void setAssignedCourses(ArrayList<Course> assignedCourses) {
        this.assignedCourses = assignedCourses;
    }

    public void assignCourse(Course course) {
        if (!assignedCourses.contains(course)) {
            assignedCourses.add(course);
            System.out.println(ConsoleColor.LIME_GREEN.apply("Course assigned: " + course.getCourseName()));
        } else {
            System.out.println(ConsoleColor.HOT_PINK.apply("Course already assigned."));
        }
    }

    public void removeCourse(Course course) {
        if (assignedCourses.contains(course)) {
            assignedCourses.remove(course);
            System.out.println(ConsoleColor.HOT_PINK.apply("Course removed: " + course.getCourseName()));
        } else {
            System.out.println(ConsoleColor.HOT_PINK.apply("Course not found."));
        }
    }

    public void viewAssignedCourses() {
        if (assignedCourses.isEmpty()) {
            System.out.println(ConsoleColor.NEON_BLUE.apply("No assigned courses."));
        } else {
            System.out.println(ConsoleColor.GOLD.apply("Courses assigned to " + instructorName + ":"));
            for (Course c : assignedCourses) {
                System.out.println(ConsoleColor.GOLD.apply(c.toString()));
            }
        }
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "instructorId='" + instructorId + '\'' +
                ", instructorName='" + instructorName + '\'' +
                ", insEmail='" + insEmail + '\'' +
                ", insDepartment='" + insDepartment + '\'' +
                ", assignedCourses=" + assignedCourses.size() +
                '}';
    }
}
