import javax.xml.crypto.Data;

public class Enrollment {
    String enrollmentId;
    Student student;
    Course course;
    Data enrollmentDate;
    String grade;

    public Enrollment(String enrollmentId, Student student, Course course, Data enrollmentDate, String grade) {
        this.enrollmentId = enrollmentId;
        this.student = student;
        this.course = course;
        this.enrollmentDate = enrollmentDate;
        this.grade = grade;
    }

    public String getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(String enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Data getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(Data enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Enrollment{" +
                "enrollmentId='" + enrollmentId + '\'' +
                ", student=" + student +
                ", course=" + course +
                ", enrollmentDate=" + enrollmentDate +
                ", grade='" + grade + '\'' +
                '}';
    }
}
