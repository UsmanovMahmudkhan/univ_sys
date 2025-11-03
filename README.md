# University Management System (U-Sys)
### Java Console Application — Object-Oriented Simulation of Academic Infrastructure


[![View Diagram in Excalidraw](https://img.shields.io/badge/Open%20in-Excalidraw-blue?logo=excalidraw)](https://excalidraw.com/#json=wG_XptdBwUXJ76PbzCgvn,PG_HDVWSbKdtY511WwJ8TA)


---

## 1. Introduction

The **University Management System (U-Sys)** is a full-scale **object-oriented simulation** of the administrative, instructional, and academic workflows within a university environment.  
Developed in **pure Java**, it demonstrates structured programming architecture, modular class design, and clear data relationships through composition and encapsulation.

Unlike conventional prototypes, U-Sys serves both as an **academic learning project** and as a **production-ready console system** that can later evolve into a database-driven or web-based platform.

This documentation outlines not only how to install and run U-Sys, but also how it was designed, the reasoning behind its class architecture, and how you can extend it into a professional-grade software system.

---

## 2. Vision and Purpose

The motivation for creating U-Sys stems from three guiding principles:

1. **Pedagogical Clarity**  
   A clear, educational implementation of university management concepts using fundamental OOP practices.

2. **Architectural Integrity**  
   A system built on the principles of cohesion, modularity, and scalability.

3. **Evolutionary Design**  
   A codebase structured to grow — from console interaction to full web-based, API-enabled management software.

U-Sys demonstrates how academic entities such as **Departments**, **Instructors**, **Courses**, **Students**, and **Admins** can interact in a digital academic ecosystem governed by structured relationships.

---

## 3. Conceptual Model Overview

At its core, U-Sys simulates the **academic ecosystem** of a university through six principal components:

| Component | Description | Example Objects |
|------------|--------------|----------------|
| **Department** | Organizational unit managing courses, students, and staff. | "Computer Science" |
| **Instructor** | Academic faculty responsible for teaching courses. | "Prof. Kim" |
| **Course** | Educational unit offering content under an instructor. | "Java Programming" |
| **Student** | Individual participant in academic programs. | "Mahmud Khan" |
| **Admin** | System operator handling setup and administrative tasks. | "admin01" |
| **Enrollment** | (Inferred) A linking entity between students and courses. | Student–Course Record |

Together, these classes model a simplified yet accurate representation of real university operations.

---

## 4. High-Level Architecture

### 4.1 Architectural Layers

The system is structured into **four layers** for conceptual clarity:

1. **Entity Layer** – Core business classes (`Department`, `Instructor`, `Student`, `Course`, `Admin`).
2. **Utility Layer** – Shared resources such as `ConsoleColor`.
3. **Data Layer** – Basic text file storage within `src/univer/data/`.
4. **Application Layer** – Entry point (`Main.java`) orchestrating all functionality.

### 4.2 UML-Like Overview (Textual Representation)

```
+-----------------------+
|        Admin          |
|-----------------------|
| +addStudent()         |
| +addCourse()          |
| +viewDepartmentSummary|
+-----------+-----------+
            |
            v
+-----------+-----------+
|      Department        |
|-------------------------|
| +addInstructor()        |
| +addCourse()            |
| +addStudent()           |
+-----------+-------------+
            |
  +---------+---------+
  |         |         |
  v         v         v
Student   Course   Instructor
```

This structural diagram shows hierarchical dependencies and message flow among entities.

---

## 5. Class-by-Class Deep Dive

### 5.1 `Department.java`

Responsible for managing **academic units**.  
Maintains collections of instructors, courses, and students.  
Implements methods to display departmental summaries, ensuring encapsulation of lists.

Key Methods:
- `addInstructor(Instructor instructor)`
- `addStudent(Student student)`
- `addCourse(Course course)`
- `displayDepartmentDetails()`

---

### 5.2 `Course.java`

Encapsulates the attributes of a single course and its enrollments.  
Manages relationships between `Instructor` and `Student`.

Attributes:
- `courseId`
- `courseName`
- `credits`
- `instructor`
- `List<Student> enrolledStudents`

Key Methods:
- `assignInstructor(Instructor instructor)`
- `enrollStudent(Student student)`
- `removeStudent(Student student)`
- `displayEnrollment()`

---

### 5.3 `Student.java`

Models the behavior and data of individual learners.  
Supports operations for enrolling and dropping courses.

Attributes:
- `studentId`
- `studentName`
- `email`
- `department`
- `List<Course> enrolledCourses`

Key Methods:
- `enroll(Course course)`
- `dropCourse(Course course)`
- `viewSchedule()`

---

### 5.4 `Instructor.java`

Represents teaching faculty members, including their assigned courses and departments.

Attributes:
- `instructorId`
- `instructorName`
- `email`
- `department`
- `List<Course> assignedCourses`

Key Methods:
- `assignCourse(Course course)`
- `viewAssignedCourses()`

---

### 5.5 `Admin.java`

Handles administrative control over departments.  
Acts as the **superuser** capable of adding or removing courses, students, or instructors.

Example implementation:

```java
public void addCourse(Department department, Course course) {
    department.addCourse(course);
    System.out.println(ConsoleColor.LIME_GREEN.apply("Added course: " + course.getCourseName()));
}
```

Methods also include:
- `addStudent()`, `removeStudent()`
- `addInstructor()`, `removeInstructor()`
- `viewDepartmentSummary()`

---

### 5.6 `ConsoleColor.java`

Utility class offering ANSI codes for styled terminal output.  
Improves UX by distinguishing success, error, and informational messages.

Example usage:

```java
System.out.println(ConsoleColor.RED.apply("Error occurred."));
```

---

### 5.7 `Main.java`

Serves as the **entry point** and demonstration driver.  
Illustrates system initialization, entity creation, and simulated workflow.

Execution Steps:
1. Instantiate a Department (e.g., Computer Science).
2. Create instructors and assign them.
3. Define and register courses.
4. Enroll students.
5. Display department summaries through Admin.

---

## 6. Data Management

### 6.1 Text-Based Storage

Data is saved in plain text files located under:

```
src/univer/data/
├── courses.txt
└── student.txt
```

This structure makes the system simple and transparent while remaining extensible for file I/O or JDBC integration.

### 6.2 Future Database Migration Plan

To migrate to a relational database:
1. Create a JDBC connection using `DriverManager`.
2. Map each class to a database table.
3. Replace `List` collections with database queries.
4. Introduce a DAO layer for persistence.

---

## 7. Installation and Setup

### 7.1 Prerequisites
- **JDK 8+**
- **Git**
- Optional: IntelliJ IDEA or VS Code

### 7.2 Steps

```bash
git clone https://github.com/UsmanovMahmudkhan/univ_sys.git
cd univ_sys/src/univer
javac *.java
java Main
```

### 7.3 Expected Console Output (Sample)

```
Added Instructor: Prof. Kim
Added Course: Java Programming
Enrolled Student: Mahmud Khan
---- Department Summary ----
Courses: 2
Instructors: 2
Students: 3
-----------------------------
```

---

## 8. Configuration and Customization

### 8.1 Customizing Initialization

All entities are instantiated in `Main.java`.  
To introduce a new Department:

```java
Department aiDept = new Department("D002", "Artificial Intelligence");
Admin admin = new Admin("A002", "sysadmin", "password123");
admin.viewDepartmentSummary(aiDept);
```

### 8.2 Expanding Console Aesthetics

Developers can modify or extend `ConsoleColor.java` to include:

- Background colors  
- Text styles (bold/underline)  
- Custom themes (e.g., university branding colors)

### 8.3 Introducing Persistence

Add file handling via `BufferedReader` and `BufferedWriter` or integrate **JSON serialization** using `Gson`.

---

## 9. System Flow

```
+----------------------+
|      Main.java       |
+----------+-----------+
           |
           v
+----------+-----------+
|    Department.java   |
+----------+-----------+
| Courses  | Students  |
+----------+-----------+
| Instructors | Admin  |
+----------------------+
```

The execution sequence is deterministic — each operation updates the in-memory model synchronously, maintaining consistency across all entity lists.

---

## 10. Core Object-Oriented Principles

U-Sys embodies textbook OOP design:

| Principle | Implementation Example |
|------------|------------------------|
| **Encapsulation** | Private fields with getter/setter accessors. |
| **Abstraction** | Classes abstract university entities. |
| **Inheritance** | Extendable base behaviors (future Admin/Person hierarchy). |
| **Polymorphism** | Overridable `toString()` methods. |
| **Composition** | Department “has-a” relationship with Students and Courses. |

This structure makes the system readable, testable, and expandable.

---

## 11. Extension Roadmap

1. **Phase 1 – File Persistence**  
   Introduce CSV/JSON data export and import.

2. **Phase 2 – GUI Migration**  
   Port to JavaFX for interactive visualization.

3. **Phase 3 – Web API Layer**  
   Implement REST endpoints via Spring Boot.

4. **Phase 4 – Authentication & Security**  
   Hash admin credentials, introduce role-based permissions.

5. **Phase 5 – Cloud Deployment**  
   Containerize the application using Docker and deploy on AWS.

---

## 12. Testing Strategy

### 12.1 Manual Testing
Run `Main.java` and verify:
- Course addition/removal
- Student enrollment
- Department summaries

### 12.2 Unit Testing (Planned)
JUnit 5 structure proposal:

```java
@Test
void testAddStudent() {
    Department dept = new Department("D001", "CS");
    Student s = new Student("S001", "Ali");
    dept.addStudent(s);
    assertEquals(1, dept.getStudents().size());
}
```

---

## 13. Performance and Complexity Notes

- Most operations run in **O(1)** or **O(n)** time due to `ArrayList` usage.
- For large datasets, future optimization may include:
  - HashMaps for ID-based lookups.
  - Caching frequently accessed data.
  - Lazy loading for departments.

---

## 14. Code Style and Standards

### 14.1 Naming
- Classes: `PascalCase`
- Methods/Variables: `camelCase`
- Constants: `UPPER_SNAKE_CASE`

### 14.2 File Layout
Each file begins with imports, class declarations, and method blocks ordered logically:
1. Constructors  
2. Accessors (get/set)  
3. Business logic methods  
4. Overrides (`toString`)

### 14.3 Documentation
Use standard Javadoc format:

```java
/**
 * Adds a student to the department list.
 * @param student the student to be added
 */
```

---

## 15. Repository Structure

```
univ_sys/
├── src/
│   ├── univer/
│   │   ├── Admin.java
│   │   ├── ConsoleColor.java
│   │   ├── Course.java
│   │   ├── Department.java
│   │   ├── Instructor.java
│   │   ├── Student.java
│   │   ├── Enrollment.java
│   │   ├── Main.java
│   │   └── data/
│   │       ├── courses.txt
│   │       └── student.txt
├── README.md (this file)
└── .gitignore
```

---

## 16. Sample Data Snapshot

| Entity | ID | Name | Role | Affiliation |
|---------|----|------|------|--------------|
| Department | D001 | Computer Science | Academic Unit | — |
| Instructor | I101 | Prof. Kim | Faculty | CS |
| Instructor | I102 | Prof. Lee | Faculty | CS |
| Course | C101 | Java Programming | 3 Credits | Prof. Kim |
| Course | C102 | Database Systems | 3 Credits | Prof. Lee |
| Student | S001 | Mahmud Khan | Undergraduate | CS |
| Student | S002 | Mina Park | Undergraduate | CS |
| Admin | A001 | admin01 | System Admin | — |

---

## 17. Advanced Ideas for Developers

1. **Observer Pattern Implementation**  
   Notify instructors when a new student joins a course.

2. **Decorator Pattern**  
   Extend console color messages with prefixes or icons.

3. **Command Pattern**  
   Introduce command objects for administrative actions to enable undo/redo functionality.

4. **Serialization**  
   Convert Java objects to bytes for disk storage and restoration.

5. **Analytics Module**  
   Compute total enrollments per course, student load averages, or instructor teaching hours.

---

## 18. Contribution Guidelines

### 18.1 Workflow
1. Fork → Clone → Branch → Commit → Push → Pull Request.
2. Keep commits atomic and messages descriptive.

### 18.2 Review Standards
- Code must pass compilation with `javac`.
- Maintain class separation and formatting consistency.
- Avoid hardcoded paths for data files.

---

## 19. Licensing Information

This project is released under the **MIT License**:

```
MIT License

Copyright (c) 2025
UsmanovMahmudkhan

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```

---

## 20. Author and Maintainer

**Mahmudkhan Usmanov**  
Student, Department of Computer Science  
**Sejong University, Seoul, Republic of Korea**  
GitHub: [UsmanovMahmudkhan](https://github.com/UsmanovMahmudkhan)

---

## 21. Acknowledgements

This project acknowledges:
- Oracle Java Documentation for API references.  
- MIT 6.042J course for structural inspiration.  
- Developers and peers providing academic feedback and code reviews.

---

## 22. Closing Thoughts

U-Sys stands as both an academic exercise and a production-ready foundation for software modeling of complex systems.  
It demonstrates how **clarity, modularity, and adherence to OOP design** can produce sustainable and evolvable codebases.

> “A system that begins as a console prototype can grow into an ecosystem — provided its architecture was pure from the start.”

---

## 23. Appendix: Suggested Reading

- *Effective Java* by Joshua Bloch  
- *Clean Code* by Robert C. Martin  
- *Design Patterns: Elements of Reusable Object-Oriented Software* by Gamma et al.  
- *Java Platform Standard Edition API Specification*

---

## 24. Versioning

| Version | Date | Description |
|----------|------|-------------|
| 1.0.0 | Nov 2025 | Initial public release |
| 1.1.0 | Planned | File persistence and testing suite |
| 1.2.0 | Planned | JavaFX GUI and REST API |

---

## 25. Final Reflection

Every software system is a reflection of its creator’s discipline.  
U-Sys exemplifies this by translating **organizational complexity** into **computational simplicity**, with reusable abstractions and precise control.

Developers are encouraged to fork, extend, and adapt this repository — not just as a project, but as a **foundation for continuous learning** in software engineering.

---

*End of Document*
