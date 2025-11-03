public class Main {
    public static void main(String[] args) {

        Department csDept = new Department("D001", "Computer Science");

        Instructor profKim = new Instructor("I101", "Prof. Kim","kim@univ.edu","Computer Science");
        Instructor profLee = new Instructor("I102", "Prof. Lee", "lee@univ.edu", "Computer Science");

        csDept.addInstructor(profKim);
        csDept.addInstructor(profLee);

        Course javaCourse = new Course("C101", "Java Programming", 3, profKim);
        Course dbCourse = new Course("C102", "Database Systems", 3, profLee);

        csDept.addCourse(javaCourse);
        csDept.addCourse(dbCourse);

        Student mahmud = new Student("S001", "Mahmud Khan", "mahmud@univ.edu", "Computer Science");
        Student mina = new Student("S002", "Mina Park", "mina@univ.edu", "Computer Science");

        csDept.addStudent(mahmud);
        csDept.addStudent(mina);

        mahmud.enroll(javaCourse);
        mahmud.enroll(dbCourse);
        mina.enroll(javaCourse);

        Admin admin = new Admin("A001", "admin01", "admin123");


        admin.addStudent(csDept, new Student("S003", "Ali Raza", "ali@univ.edu", "Computer Science"));
        admin.addInstructor(csDept, new Instructor("I103", "Dr. Yoon", "yoon@univ.edu", "Computer Science"));
        admin.addCourse(csDept, new Course("C103", "Data Structures", 3, profKim));

        admin.viewDepartmentSummary(csDept);

        mahmud.viewCourses();

        javaCourse.displayCourseInfo();
    }
}
