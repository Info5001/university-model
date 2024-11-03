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
         
         ------------------ The list below will be covered on Sunday -------------
         * 5. Create seats in the course offer
         * 6. Create students
         * 7. Register students for the course
         * 8. Print College information and everything below (Departments, Courses, Course Schedules....)
         */

        Department mgenDepartment = new Department("MGEN", "MSIS");
        
        CourseCatalog mgenCourseCatalog = mgenDepartment.getCourseCatalog();
        
        mgenCourseCatalog.newCourse("Application Engineering", "INFO5100", 4);
        mgenCourseCatalog.newCourse("Advanced Java", "INFO6250", 4);
        mgenCourseCatalog.newCourse("Web design class", "INFO6150", 4);

        CourseSchedule mgenScheduleSpring2025 = mgenDepartment.newCourseSchedule("Spring2025");

        CourseOffer info5100Spring25 = mgenScheduleSpring2025.newCourseOffer("INFO5100");
        mgenScheduleSpring2025.newCourseOffer("INFO6250");
        mgenScheduleSpring2025.newCourseOffer("INFO6150");
        
        // I scheduled INFO5100, INFO6250, INFO6150 for the Spring 25 semester.
        // One issue is I haven't created any Seats, not sure if its a problem.



//         CourseOffer courseoffer = courseschedule.newCourseOffer("INFO5100");
//         if (courseoffer==null)return;
//         courseoffer.generatSeats(10);
//         PersonDirectory pd = department.getPersonDirectory();
//         Person person = pd.newPerson("0112303");
//         StudentDirectory sd = department.getStudentDirectory();
//         StudentProfile student = sd.newStudentProfile(person);
//         CourseLoad courseload = student.newCourseLoad("Fall2023"); 
// //        
//         courseload.newSeatAssignment(courseoffer); //register student in class
        
//         int total = department.calculateRevenuesBySemester("Fall2023");
//         System.out.println("Total: " + total);

    }

}
