/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import CourseCatalog.Course;
import CourseCatalog.CourseCatalog;
import CourseSchedule.CourseLoad;
import CourseSchedule.CourseOffer;
import CourseSchedule.CourseSchedule;
import Department.Department;
import Persona.Person;
import Persona.PersonDirectory;
import Persona.StudentDirectory;
import Persona.StudentProfile;

/**
 *
 * @author kal bugrara
 */
public class UniversityExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /**
         * 1. Create a department +
         * 2. Create a course +
         * 3. Create a course schedule for Spring'25
         * 4. Create a course offer
         * 
         * ------------------ The list below will be covered on Sunday -------------
         * 5. Create seats in the course offer
         * 6. Create students
         * 7. Register students for the course
         * 8. Print College information and everything below (Departments, Courses,
         * Course Schedules....)
         */

        Department mgenDepartment = new Department("MGEN", "MSIS");

        CourseCatalog mgenCourseCatalog = mgenDepartment.getCourseCatalog();

        mgenCourseCatalog.newCourse("Application Engineering", "INFO5100", 4);
        mgenCourseCatalog.newCourse("Advanced Java", "INFO6250", 4);
        mgenCourseCatalog.newCourse("Web design class", "INFO6150", 4);

        CourseSchedule mgenScheduleSpring2025 = mgenDepartment.newCourseSchedule("Spring2025");

        CourseOffer info5100Spring25 = mgenScheduleSpring2025.newCourseOffer("INFO5100");
        CourseOffer info6250Spring25 = mgenScheduleSpring2025.newCourseOffer("INFO6250");
        CourseOffer info6150Spring25 = mgenScheduleSpring2025.newCourseOffer("INFO6150");

        // I scheduled INFO5100, INFO6250, INFO6150 for the Spring 25 semester.
        // One issue is I haven't created any Seats, not sure if its a problem.

        info5100Spring25.generateSeats(5);
        info6250Spring25.generateSeats(5);
        info6150Spring25.generateSeats(10);

        // Students....

        PersonDirectory mgenPd = mgenDepartment.getPersonDirectory();
        StudentDirectory mgenSd = mgenDepartment.getStudentDirectory();

        Person archil = mgenPd.newPerson("01");
        Person jack = mgenPd.newPerson("02");
        Person amanda = mgenPd.newPerson("03");
        Person jane = mgenPd.newPerson("04");

        mgenSd.newStudentProfile(archil);
        mgenSd.newStudentProfile(jack);
        mgenSd.newStudentProfile(amanda);
        mgenSd.newStudentProfile(jane);

        mgenDepartment.registerForAClass("01", "INFO5100", "Spring2025");
        mgenDepartment.registerForAClass("01", "INFO6250", "Spring2025");
        mgenDepartment.registerForAClass("02", "INFO5100", "Spring2025");
        mgenDepartment.registerForAClass("02", "INFO6150", "Spring2025");
        mgenDepartment.registerForAClass("03", "INFO5100", "Spring2025");
        mgenDepartment.registerForAClass("03", "INFO6250", "Spring2025");

        System.out.println();
        System.out.println();
        System.out.println();

        mgenDepartment.printDepartmentInfo("Spring2025");

    }

}
