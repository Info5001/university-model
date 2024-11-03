/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CourseSchedule;

import CourseCatalog.Course;
import CourseCatalog.CourseCatalog;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class CourseSchedule {
    CourseCatalog coursecatalog;
    ArrayList<CourseOffer> schedule;
    String semester;

    public CourseSchedule(String s, CourseCatalog cc) {
        semester = s;
        coursecatalog = cc;
        schedule = new ArrayList();
    }

    public CourseOffer newCourseOffer(String n) {
        Course c = coursecatalog.getCourseByNumber(n);
        if (c == null)
            return null;

        CourseOffer co = new CourseOffer(c);
        schedule.add(co);
        return co;
    }

    public CourseOffer getCourseOfferByNumber(String n) {
        for (CourseOffer co : schedule) {
            if (co.getCourseNumber().equals(n)) {
                return co;
            }
        }
        return null;
    }

    public int calculateTotalRevenues() {
        int sum = 0;
        for (CourseOffer co : schedule) {
            sum = sum + co.getTotalCourseRevenues();
        }
        return sum;
    }

    public void printScheduledCourses() {
        System.out.println("Schedule for semester: " + semester);
        System.out.println("===============================================================");
        for (CourseOffer eachCourseOffer : schedule) {
            eachCourseOffer.printCourseOfferInformation();
        }

        System.out.println("===============================================================");

    }

}
