/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Department;

import CourseCatalog.Course;
import CourseCatalog.CourseCatalog;
import CourseSchedule.CourseLoad;
import CourseSchedule.CourseOffer;
import CourseSchedule.CourseSchedule;
import Degree.Degree;
import Employer.EmployerDirectory;
import Persona.Faculty.FacultyDirectory;
import Persona.PersonDirectory;
import Persona.StudentDirectory;
import Persona.StudentProfile;
import java.util.HashMap;

/**
 *
 * @author kal bugrara
 */
public class Department {

    String name;
    CourseCatalog coursecatalog;
    PersonDirectory persondirectory;
    StudentDirectory studentdirectory;
    FacultyDirectory facultydirectory;
    EmployerDirectory employerdirectory;
    Degree degree;

    HashMap<String, CourseSchedule> mastercoursecatalog;

    public Department(String departmentName, String degreeName) {
        name = departmentName;
        mastercoursecatalog = new HashMap<>();
        coursecatalog = new CourseCatalog(this);
        studentdirectory = new StudentDirectory(this); // pass the department object so it stays linked to it
        persondirectory = new PersonDirectory(this);
        degree = new Degree(degreeName);
    }

    public void addCoreCourse(Course c) {
        degree.addCoreCourse(c);
    }

    public void addElectiveCourse(Course c) {
        degree.addElectiveCourse(c);
    }

    public PersonDirectory getPersonDirectory() {
        return persondirectory;
    }

    public StudentDirectory getStudentDirectory() {
        return studentdirectory;
    }

    public CourseSchedule newCourseSchedule(String semester) {
        CourseSchedule cs = new CourseSchedule(semester, coursecatalog);
        mastercoursecatalog.put(semester, cs);
        return cs;
    }

    public CourseSchedule getCourseSchedule(String semester) {
        return mastercoursecatalog.get(semester);
    }

    public CourseCatalog getCourseCatalog() {
        return coursecatalog;
    }

    public Course newCourse(String n, String nm, int cr) {
        Course c = coursecatalog.newCourse(n, nm, cr);
        return c;
    }

    public int calculateRevenuesBySemester(String semester) {
        CourseSchedule css = mastercoursecatalog.get(semester);
        return css.calculateTotalRevenues();
    }

    public void registerForAClass(String studentid, String cn, String semester) {
        StudentProfile sp = studentdirectory.findStudent(studentid);
        CourseLoad cl = sp.getCourseLoadBySemester(semester);

        if (cl == null) {
            System.out.println("Student with id " + studentid + " has not registered for a class in " + semester
                    + " semester yet.");
            System.out.println("Adding new semester section in student transcript for semester " + semester + ".");
            cl = sp.newCourseLoad(semester);
        }

        CourseSchedule cs = mastercoursecatalog.get(semester);
        CourseOffer co = cs.getCourseOfferByNumber(cn);

        if (co == null) {
            System.out.println("Course number " + cn + " is not being taught this " + semester + " semester.");
            return;
        }

        co.assignEmptySeat(cl);
    }

    public void printDepartmentInfo(String semester) {
        System.out.println("---------------------------------------------------------");
        System.out.println("Department name: " + name);
        System.out.println("---------------------------------------------------------");

        CourseSchedule semesterSchedule = mastercoursecatalog.get(semester);
        if (semesterSchedule == null) {
            System.out.println("Schedule for semester :" + semester + " was not found.");
            return;
        }

        semesterSchedule.printScheduledCourses();

        studentdirectory.printStudentInformation();

    }

}
